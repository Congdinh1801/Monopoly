package playerGUI;

//import game.dice.Dice;

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
			//Get number of dice moves
			//Uncomment once RollDiceGUI done
			/*GamePanel rollDicePanel = (GamePanel) container.getComponent(2);
			int diceMoves = rollDicePanel.getDice();

			// Submit to the server.
			Dice diceData = new Dice(diceMoves);
			try {
				client.sendToServer(diceData);
		    } catch (IOException e) {
				displayError("Error connecting to the server.");
				}*/
		
			
			
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
//			GameData data = new GameData();
//			try {
//				client.sendToServer(data);
//			} catch (IOException e) {
//				displayError("Not your turn");
//			}
		}
	}
	
	// After dice has been rolled, update gui
	// screen.
	public void RollDiceSuccess() {
			//RollDicePanel rollDicePanel = (RollDicePanel) container.getComponent(2);
			//ClientGUI clientGUI = (ClientGUI) SwingUtilities.getWindowAncestor(rollDicePanel);
			// clientGUI.setUser(new User(createAccountPanel.getUsername(),
			// createAccountPanel.getPassword()));
			//CardLayout cardLayout = (CardLayout) container.getLayout();
			//cardLayout.show(container, "4");
		}
		
	// Method that displays a message in the error label.
	  public void displayError(String error)
	  {
	    System.out.println(error);
	  }

}
