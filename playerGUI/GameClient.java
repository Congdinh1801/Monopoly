package playerGUI;

import ocsf.client.AbstractClient;
import playerCommunication.Error;
import serverBackend.dice.Dice;
import serverBackend.player.Player;

public class GameClient extends AbstractClient {
	// Private data fields for storing the GUI controllers.
	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
	private GamePanelControl gamePanelControl;

//	private GameData gamedata;

	// Setters for the GUI controllers.
	public void setLoginControl(LoginControl loginControl) {
		this.loginControl = loginControl;
	}

	public void setCreateAccountControl(CreateAccountControl createAccountControl) {
		this.createAccountControl = createAccountControl;
	}
	
	public void setGamePanelControl(GamePanelControl gamePanelControl) {
		this.gamePanelControl = gamePanelControl;
	}

	// Constructor for initializing the client with default settings.
	public GameClient() {
		super("localhost", 8300);
	}

	// Method that handles messages from the server.
	public void handleMessageFromServer(Object arg0) {
		// If we received a String, figure out what this event is.
		if (arg0 instanceof String) {
			// Get the text of the message.
			String message = (String) arg0;

			// If we successfully logged in, tell the login controller.
			if (message.contains("LoginSuccessful")) {
				loginControl.loginSuccess();
				System.out.println("Login successfully");
			}

			// If we successfully created an account, tell the create account controller.
			else if (message.equals("CreateAccountSuccessful")) {
				createAccountControl.createAccountSuccess();
			}
			//
			else if (message.equals("RollDiceSuccess"))
			{
				
			}
			else if (message.equals("BuyPropertiesSuccess"))
			{
				//gamePanelControl.BuyPropertiesSuccess();
			}
		}

		// If we received an Error, figure out where to display it.
		else if (arg0 instanceof Error) {
			// Get the Error object.
			Error error = (Error) arg0;

			// Display login errors using the login controller.
			if (error.getType().equals("Login")) {
				loginControl.displayError(error.getMessage());
			}

			// Display account creation errors using the create account controller.
			else if (error.getType().equals("CreateAccount")) {
				createAccountControl.displayError(error.getMessage());
			}
			else if (error.getType().equals("RollDice")) {
				gamePanelControl.displayError(error.getMessage());
			}
			else if (error.getType().equals("BuyProperties")) {
				gamePanelControl.displayError(error.getMessage());
			}
		} else if(arg0 instanceof AllClientsGameData) {
			
			AllClientsGameData allClientsGameData = (AllClientsGameData) arg0;
		
			if(allClientsGameData.getBuyOrNot().equals("Buy")) {
				gamePanelControl.turnOffBuyButtons();
				int currentPosition = allClientsGameData.getCurrentPosition();
				int currentPlayer = allClientsGameData.getcurrentPlayerID();
				gamePanelControl.buyPropSuccess(currentPosition, currentPlayer);
			} else if(allClientsGameData.getBuyOrNot().equals("No Buy")) {
				gamePanelControl.turnOffBuyButtons();
			} else if (allClientsGameData.isInitilizedPlayer()) {
				gamePanelControl.setPlayerName(allClientsGameData.getName());
			} else {
				//update the client's GUI
				int dice1 = allClientsGameData.getDice1();
				int dice2 = allClientsGameData.getDice2();
				int previousPosition = allClientsGameData.getPreviousPosition();
				int currentPosition = allClientsGameData.getCurrentPosition();

				gamePanelControl.updateRollDice(dice1, dice2);
				try {
					gamePanelControl.updatePlayer(previousPosition, currentPosition, allClientsGameData.getcurrentPlayerID(), allClientsGameData.getOpponentPosition());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				gamePanelControl.RollDiceSuccess(allClientsGameData.isCanBuy(), allClientsGameData.getPos(), allClientsGameData.getBoard());

				if(allClientsGameData.isEndTurn()) {
					gamePanelControl.turnOnRollDiceButton();
				}
			}

			gamePanelControl.setPlayerMoney(allClientsGameData.getCurrentMoney());
			gamePanelControl.appendPlayersLog(allClientsGameData.getPlayersLog());
		} else if(arg0 instanceof ClientGameData) {
			ClientGameData clientGameData = (ClientGameData) arg0;
			
			if(clientGameData.isGameover()) {
				gamePanelControl.displayTheWinner(clientGameData.isLoser());
			} else {
				if(clientGameData.isFirstPlayer()) {
					gamePanelControl.turnOnRollDiceButton();
				} else {
					gamePanelControl.turnOffRollDiceButton();
				}
				
				if(clientGameData.isCanBuy()) {
					gamePanelControl.displayBuyOrNotButton(clientGameData.isCanBuy(), clientGameData.isBuyButton());
				}
			}
			
			gamePanelControl.appendPlayersLog(clientGameData.getPlayersTurn());
		}
	}
}

