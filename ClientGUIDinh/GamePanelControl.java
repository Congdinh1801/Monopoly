package clientGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanelControl implements ActionListener {

	private JPanel container;
	private ChatClient chatClient;

	public GamePanelControl(JPanel container, ChatClient chatClient) {
		this.container = container;
		this.chatClient = chatClient;
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command == "Dice") {
			
		}
	}

}
