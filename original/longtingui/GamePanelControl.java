package longtingui;

import clientGUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanelControl implements ActionListener {

	private JPanel container;
	private ChatClient client;

	public GamePanelControl(JPanel container, ChatClient client) {
		this.container = container;
		this.client = client;
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command == "Roll Dice") {
		
//			// Get the username and password the user entered.
//			GamePanel loginPanel = (GamePanel) container.getComponent(3);
//			GameData data = new GameData();
//
//			// Check the validity of the information locally first.
//			if (data.getUsername().equals("") || data.getPassword().equals("")) {
//				displayError("You must enter a username and password.");
//				return;
//			}
//
//			// Submit the login information to the server.
			GameData data = new GameData();
			try {
				client.sendToServer(data);
			} catch (IOException e) {
				displayError("Not your turn");
			}
		}
	}
	// Method that displays a message in the error label.
	  public void displayError(String error)
	  {
	    System.out.println(error);
	  }

}
