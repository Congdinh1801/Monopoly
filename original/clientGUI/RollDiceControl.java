package clientGUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import game.dice.Dice;

public class RollDiceControl implements ActionListener {

	private JPanel container;
	private ChatClient client;

	// Constructor
	public RollDiceControl(JPanel container, ChatClient client) {
		this.container = container;
		this.client = client;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae) {
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Cancel button takes the user back to the game
		if (command == "Cancel") {
			CardLayout cardLayout = (CardLayout) container.getLayout();
			//cardLayout.show(container, "1");
		}

		// The Roll button sends data to the server
		else if (command == "Roll") {
			
			// Get number of dice moves
			//RollDicePanel rollDicePanel = (RollDicePanel) container.getComponent(2);
			//int diceMoves = rollDicePanel.getDice();

			// Submit to the server.
			//RollDiceData data = new RollDiceData(diceMoves);
			//try {
			//	client.sendToServer(data);
			//} catch (IOException e) {
			//	displayError("Error connecting to the server.");
			//}
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
	public void displayError(String error) {
		
	}

}
