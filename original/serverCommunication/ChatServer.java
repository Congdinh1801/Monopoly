package serverCommunication;

import java.awt.*;
import javax.swing.*;

import database.Database;
import serverBackend.board.MonopolyBoard;
import serverBackend.dice.*;
import serverBackend.player.Player;

import java.io.IOException;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import playerCommunication.Error;
import playerGUI.AllClientGameData;
import playerGUI.ClientGameData;
import playerGUI.CreateAccountData;
import playerGUI.GameData;
//import playerGUI.GameData;
import playerGUI.LoginData;

public class ChatServer extends AbstractServer {
	// Data fields for this chat server.
	private JTextArea log;
	private JLabel status;
	private boolean running = false;
	private Database database = new Database();
	private int playerCount = 0;
	private int playerTurn;
	private MonopolyBoard board;
	private GameData gameData;
	private int prevPlayerPosition = -1;

	// Constructor for initializing the server with default settings.
	public ChatServer() {
		super(12345);
		this.setTimeout(500);
		gameData = new GameData();
		board = new MonopolyBoard();
	}
	
	// Getter that returns whether the server is currently running.
	public boolean isRunning() {
		return running;
	}

	// Setters for the data fields corresponding to the GUI elements.
	public void setLog(JTextArea log) {
		this.log = log;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}

	// When the server starts, update the GUI.
	public void serverStarted() {
		running = true;
		status.setText("Listening");
		status.setForeground(Color.GREEN);
		log.append("Server started\n");
	}

	// When the server stops listening, update the GUI.
	public void serverStopped() {
		status.setText("Stopped");
		status.setForeground(Color.RED);
		log.append("Server stopped accepting new clients - press Listen to start accepting new clients\n");
	}

	// When the server closes completely, update the GUI.
	public void serverClosed() {
		running = false;
		status.setText("Close");
		status.setForeground(Color.RED);
		log.append("Server and all current clients are closed - press Listen to restart\n");
	}

	// When a client connects or disconnects, display a message in the log.
	public void clientConnected(ConnectionToClient client) {
		log.append("Client " + client.getId() + " connected\n");
	}

	// When a message is received from a client, handle it.
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		// If we received LoginData, verify the account information.
		if (arg0 instanceof LoginData) {
			// Check the username and password with the database.
			LoginData data = (LoginData) arg0;
			Object result;
			if (database.verifyAccount(data.getUsername(), data.getPassword())) {
				result = data.getUsername() + ",LoginSuccessful";
				log.append("Client " + arg1.getId() + " successfully logged in as " + data.getUsername() + "\n");
				Player player = new Player(data.getUsername()); 
				
				//This checks who is the first client and enable the roll button for client
				if(this.getNumberOfClients() == 1) {
					ClientGameData clientGameData = new ClientGameData();
					clientGameData.setFirstPlayer(true);
					try {
						arg1.sendToClient(clientGameData);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				playerCount++;
				gameData.getPlayer().add(player);
			} else {
				result = new Error("The username and password are incorrect.", "Login");
				log.append("Client " + arg1.getId() + " failed to log in\n");
			}

			// Send the result to the client.
			try {
				arg1.sendToClient(result);
			} catch (IOException e) {
				return;
			}
		}

		// If we received CreateAccountData, create a new account.
		else if (arg0 instanceof CreateAccountData) {
			// Try to create the account.
			CreateAccountData data = (CreateAccountData) arg0;
			Object result;
			if (database.createNewAccount(data.getUsername(), data.getPassword())) {
				result = "CreateAccountSuccessful";
				log.append("Client " + arg1.getId() + " created a new account called " + data.getUsername() + "\n");
			} else {
				result = new Error("We're sorry! The username is already in use or An error has occured.",
						"CreateAccount");
				log.append("Client " + arg1.getId() + " failed to create a new account\n");
			}

			// Send the result to the client.
			try {
				arg1.sendToClient(result);
			} catch (IOException e) {
				return;
			}
		} else if (arg0 instanceof String) {
			if(arg0.equals("Roll Dice")) {
				
				playGame();
				
				//Send data to all of the clients to update their GUI
				AllClientGameData allClientGameData = new AllClientGameData();
				allClientGameData.setDice1(gameData.getDice1().getDiceNumber());
				allClientGameData.setDice2(gameData.getDice2().getDiceNumber());
				allClientGameData.setPreviousPosition(gameData.getPreviousPosition());
				allClientGameData.setCurrentPlayer(playerTurn);
				allClientGameData.setCurrentPosition(gameData.getCurrentPosition());
				
				int opponent_position = gameData.getPlayer().get((playerTurn + 1)%2).getPosition();
				
				allClientGameData.setOpponentPosition(opponent_position);
				
				
				sendToAllClients(allClientGameData);
				
				//Send data to a client that is their turn
				ClientGameData clientGameData = new ClientGameData();
				clientGameData.setRoll(true);
				clientGameData.setBoard(board);
				clientGameData.setCanBuy(gameData.canBuy());
				clientGameData.setPos(gameData.getCurrentPosition());
				
				if(!gameData.canBuy()) {
//					allClientGameData.setCurrentPlayer(playerTurn);
					playerTurn = (playerTurn + 1) % playerCount;
				}
				
				try {
					arg1.sendToClient(clientGameData);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (arg0.equals("Buy")) {
				if(gameData.isAirport()) {
					gameData.buyAirport();
				} else if(gameData.isCityProperty()) {
					gameData.buyCityProperty();
				} else if(gameData.isUtilities()) {
					gameData.buyUtilitites();
				}
				
				//update all the clients that a purchase have happened
				AllClientGameData allClientGameData = new AllClientGameData();
				allClientGameData.setBuyOrNot("Buy");
				allClientGameData.setCurrentPosition(gameData.getCurrentPosition());
				allClientGameData.setCurrentPlayer(playerTurn);
				playerTurn = (playerTurn + 1) % playerCount;
				sendToAllClients(allClientGameData);
			} else if(arg0.equals("No Buy")) {
				
				//update all the clients that the player did not buy
				AllClientGameData allClientGameData = new AllClientGameData();
				allClientGameData.setBuyOrNot("No Buy");
				
				allClientGameData.setCurrentPlayer(playerTurn);
				playerTurn = (playerTurn + 1) % playerCount;
				
				sendToAllClients(allClientGameData);
			}
		}
	
	}

	private void playGame() {
		gameData.play(playerTurn);
	}
	
	// Method that handles listening exceptions by displaying exception information.
	public void listeningException(Throwable exception) {
		running = false;
		status.setText("Exception occurred while listening");
		status.setForeground(Color.RED);
		log.append("Listening exception: " + exception.getMessage() + "\n");
		log.append("Press Listen to restart server\n");
	}
}
