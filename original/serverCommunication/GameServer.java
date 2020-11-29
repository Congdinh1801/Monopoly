package serverCommunication;

import java.awt.*;
import javax.swing.*;

import database.Database;
import serverBackend.board.MonopolyBoard;
import serverBackend.dice.*;
import serverBackend.player.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import playerCommunication.Error;
import playerGUI.AllClientsGameData;
import playerGUI.ClientGameData;
import playerGUI.CreateAccountData;
//import playerGUI.GameData;
import playerGUI.LoginData;

public class GameServer extends AbstractServer {
	// Data fields for this chat server.
	private JTextArea log;
	private JLabel status;
	private boolean running = false;
	private Database database = new Database();
	private int playerCount = 0;
	private int playerTurn;
	private MonopolyBoard board;
	private GameData gameData;
	private ArrayList<String> name;
	private HashMap<Long, Integer> clientID;
//	private int prevPlayerPosition = -1;

	// Constructor for initializing the server with default settings.
	public GameServer() {
		super(12345);
		this.setTimeout(500);
		gameData = new GameData();
		board = new MonopolyBoard();
		name = new ArrayList<>();
		clientID = new HashMap<>();
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
				
				//This checks who is the first client and enable the roll button for client
				updateNumberOfPlayers(data.getUsername(), arg1);
				
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
				
				updateNumberOfPlayers(data.getUsername(), arg1);
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
				AllClientsGameData allClientGameData = new AllClientsGameData();
				updateAllClientsAfterRollDice(allClientGameData);

				if(gameData.isGameover()) {
					ClientGameData determineWinner = new ClientGameData();
					determineWinner.setGameover(gameData.isGameover());
					Thread[] clients = this.getClientConnections();
					int playerID = clientID.get(arg1.getId());
					
					for(Thread client : clients) {
						if(clientID.get(client.getId()) == playerID) {
							determineWinner.setLoser(true);
						} else {
							determineWinner.setLoser(false);
						}
						
						try {
							((ConnectionToClient) client).sendToClient(determineWinner);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
				ClientGameData clientGameData = new ClientGameData();
				clientGameData.setCanBuy(gameData.canBuy());
				clientGameData.setBuyButton(gameData.isBuyButton());
				
				try {
					arg1.sendToClient(clientGameData);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (arg0.equals("Buy")) {
				
				//see what kind of an asset to buy
				gameData.buyAsset();
				
				//update all the clients that a purchase have happened
				AllClientsGameData allClientsGameData = new AllClientsGameData();
				ClientGameData clientGameData = new ClientGameData();

				
				buyOrNot(allClientsGameData, clientGameData,"Buy", arg1);
				
			} else if(arg0.equals("No Buy")) {
				
				//update all the clients that the player did not buy
				AllClientsGameData allClientGameData = new AllClientsGameData();

				ClientGameData clientGameData = new ClientGameData();
				buyOrNot(allClientGameData, clientGameData,"No Buy", arg1);
			}
			
			
		}
	
	}
	
	private void updateNumberOfPlayers(String username, ConnectionToClient arg1) {
		Player player = new Player(username); 
		AllClientsGameData allClientsGameData = new AllClientsGameData();
		
		playerCount = (playerCount + 1) % (getNumberOfClients());
		
		//Reinitialize the game
		if(playerCount == 0) {
			gameData = new GameData();
			board = new MonopolyBoard();
			name = new ArrayList<>();
			clientID = new HashMap<>();
			ClientGameData clientGameData = new ClientGameData();
			clientGameData.setFirstPlayer(true);
			try {
				arg1.sendToClient(clientGameData);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		name.add(username);
		allClientsGameData.setcurrentPlayerID(playerCount);
		allClientsGameData.setName(name);
		allClientsGameData.setInitilizedPlayer(true);
		sendToAllClients(allClientsGameData);
		clientID.put(arg1.getId(), playerCount);
		
		gameData.getPlayer().add(player);
	}
	
	private void updateAllClientsAfterRollDice(AllClientsGameData allClientGameData) {
		allClientGameData.setDice1(gameData.getDice1().getDiceNumber());
		allClientGameData.setDice2(gameData.getDice2().getDiceNumber());
		allClientGameData.setPreviousPosition(gameData.getPreviousPosition());
		allClientGameData.setcurrentPlayerID(playerTurn);
		allClientGameData.setCurrentPosition(gameData.getCurrentPosition());
		allClientGameData.setOpponentPosition(gameData.getPlayer().get((playerTurn + 1) % (playerCount + 1)).getPosition());
		allClientGameData.setCurrentMoney(gameData.getMoney());
		allClientGameData.setBoard(board);
		allClientGameData.setCanBuy(gameData.canBuy());
		allClientGameData.setPos(gameData.getCurrentPosition());
		
		if(!gameData.canBuy()) {
			playerTurn = (playerTurn + 1) % (playerCount + 1);
			allClientGameData.setEndTurn(true);
		}
		
		sendToAllClients(allClientGameData);
	}
	
	private void buyOrNot(AllClientsGameData allClientGameData, ClientGameData clientGameData,
						String buyOrNot, ConnectionToClient arg1) {
		allClientGameData.setCurrentPosition(gameData.getCurrentPosition());
		allClientGameData.setBuyOrNot(buyOrNot);
		allClientGameData.setEndTurn(true);
		allClientGameData.setcurrentPlayerID(playerTurn);
		allClientGameData.setCurrentMoney(gameData.getMoney());
		playerTurn = (playerTurn + 1) % (playerCount + 1);
		sendToAllClients(allClientGameData);
		clientGameData.setEndTurn(true);
		try {
			arg1.sendToClient(clientGameData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void playGame() {
		gameData.play(playerTurn);
	}
	
	public void clientDisconnected(ConnectionToClient client) {
		playerCount--;
		System.out.println("Disconnected: ");
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
