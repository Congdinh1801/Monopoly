package playerGUI;

import java.awt.Image;

//import game.dice.Dice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import serverBackend.dice.Dice;

public class GamePanelControl implements ActionListener {

	private JPanel container;
	private ChatClient client;
	private GameData gameData;
	
	private JLabel label1;
	private ImageIcon tempImage1;
	private Image image1;
	
	private JLabel label2;
	private ImageIcon tempImage2;
	private Image image2;
	private ExecutorService pool = Executors.newFixedThreadPool(1);	//2
	
	private ArrayList<SquarePanel> squareCollections;

	public GamePanelControl(JPanel container, ChatClient client) {
		this.container = container;
		this.client = client;
		this.gameData = new GameData();
	}
	
	public void setSquareCollections(ArrayList<SquarePanel> squareCollections) {
		this.squareCollections = squareCollections;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}
	
	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command == "Roll Dice") {
			gameData.play();
			
			int previousPosition = gameData.getPreviousPosition();
			Runnable r1 = new Animator(squareCollections, previousPosition, gameData.getPlayer().getPosition());
			if(gameData.canBuy()) {
				if(gameData.isAirport()) {
					System.out.println("You are in an Airplane Square");
				} else if(gameData.isCityProperty()) {
					System.out.println("You are in City Property Square");
				} else if(gameData.isUtilities()) {
					System.out.println("You are in an Utility Square");
				}
			}
			pool.execute(r1);
			
			Dice die = gameData.getDice1();
			int die1;
			die1 = die.getDiceNumber();
			
			switch (die1) {
			case 1:
				tempImage1 = new ImageIcon(GamePanel.class.getResource("/Alea_1.png"));
				image1 = tempImage1.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label1.setIcon(new ImageIcon(image1));
				break;
			case 2:
				tempImage1 = new ImageIcon(GamePanel.class.getResource("/Alea_2.png"));
				image1 = tempImage1.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label1.setIcon(new ImageIcon(image1));
				break;
			case 3:
				tempImage1 = new ImageIcon(GamePanel.class.getResource("/Alea_3.png"));
				image1 = tempImage1.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label1.setIcon(new ImageIcon(image1));
				break;
			case 4:
				tempImage1 = new ImageIcon(GamePanel.class.getResource("/Alea_4.png"));
				image1 = tempImage1.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label1.setIcon(new ImageIcon(image1));
				break;
			case 5:
				tempImage1 = new ImageIcon(GamePanel.class.getResource("/Alea_5.png"));
				image1 = tempImage1.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label1.setIcon(new ImageIcon(image1));
				break;
			case 6:
				tempImage1 = new ImageIcon(GamePanel.class.getResource("/Alea_6.png"));
				image1 = tempImage1.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label1.setIcon(new ImageIcon(image1));
				break;
			}
			
			int die2 = gameData.getDice2().getDiceNumber();
			switch(die2) {
			case 1:
				tempImage2 = new ImageIcon(GamePanel.class.getResource("/Alea_1.png"));
				image2 = tempImage2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label2.setIcon(new ImageIcon(image2));
				break;
			case 2:
				tempImage2 = new ImageIcon(GamePanel.class.getResource("/Alea_2.png"));
				image2 = tempImage2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label2.setIcon(new ImageIcon(image2));
				break;
			case 3:
				tempImage2 = new ImageIcon(GamePanel.class.getResource("/Alea_3.png"));
				image2 = tempImage2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label2.setIcon(new ImageIcon(image2));
				break;
			case 4:
				tempImage2 = new ImageIcon(GamePanel.class.getResource("/Alea_4.png"));
				image2 = tempImage2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label2.setIcon(new ImageIcon(image2));
				break;
			case 5:
				tempImage2 = new ImageIcon(GamePanel.class.getResource("/Alea_5.png"));
				image2 = tempImage2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label2.setIcon(new ImageIcon(image2));
				break;
			case 6:
				tempImage2 = new ImageIcon(GamePanel.class.getResource("/Alea_6.png"));
				image2 = tempImage2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				label2.setIcon(new ImageIcon(image2));
				break;
			}
			
			try {
				client.sendToServer(die);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}
	
	// After dice has been rolled, update gui
	public void RollDiceSuccess() {
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
