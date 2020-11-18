package playerGUI;

import ocsf.client.AbstractClient;
import playerCommunication.Error;

public class ChatClient extends AbstractClient {
	// Private data fields for storing the GUI controllers.
	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
	private GamePanelControl gamePanelControl;

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
	public ChatClient() {
		super("localhost", 8300);
	}

	// Method that handles messages from the server.
	public void handleMessageFromServer(Object arg0) {
		// If we received a String, figure out what this event is.
		if (arg0 instanceof String) {
			// Get the text of the message.
			String message = (String) arg0;

			// If we successfully logged in, tell the login controller.
			if (message.equals("LoginSuccessful")) {
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
				gamePanelControl.RollDiceSuccess();
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
		}
	}
}
