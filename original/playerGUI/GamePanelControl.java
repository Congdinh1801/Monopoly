package playerGUI;

import java.awt.Color;
import java.awt.Image;

//import game.dice.Dice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import serverBackend.board.Asset;
import serverBackend.board.MonopolyBoard;
import serverBackend.board.Square;

import serverBackend.dice.Dice;

public class GamePanelControl implements ActionListener {

	private JPanel container;
	private ChatClient client;
	private GameData gameData;
	private MonopolyBoard board = new MonopolyBoard();

	
	public GameData getGameData() {
		return gameData;
	}

	public void setGameData(GameData gameData) {
		this.gameData = gameData;
	}

	private JLabel label1;
	private ImageIcon tempImage1;
	private Image image1;
	
	private JLabel label2;
	private ImageIcon tempImage2;
	private Image image2;
	private ExecutorService pool = Executors.newFixedThreadPool(1);	//2
	
	private ArrayList<SquarePanel> squareCollections;
	
	private ClientGameData clientGameData = new ClientGameData();

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
		//roll dice control
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
			
			int dice1 = gameData.getDice1().getDiceNumber();
			int dice2 = gameData.getDice2().getDiceNumber();
			
			diceLabel(dice1, dice2);
			
			clientGameData.setDice1(dice1);
			clientGameData.setDice2(dice2);
			clientGameData.setCanbuy(true);
			
			//test updating land info
			//RollDiceSuccess();
			
			try {
				client.sendToServer(clientGameData);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		
		//buy button control
		if (command.contentEquals("Buy")) {
			//client should buy buy himself and then send the message "bought" to the server
//			if (gameData.isAirport()) {
//				try {
//					client.sendToServer("Airport");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					
//				}
//			}
//			else if (gameData.isCityProperty()) {
//				try {
//					client.sendToServer("CityProperty");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			else if (gameData.isUtilities()) {
//				try {
//					client.sendToServer("Utility");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			
		}
		
		//no buy button control
		if (command.contentEquals("No Buy")) {
			//client send the message "don't buy" to the server
//			GamePanel gamePanel = (GamePanel) container.getComponent(3);
//			gamePanel.setBuyBttn(false);
//			gamePanel.setCancelBttn(false);
		}
	}
	
	public void updateRollDice(int dice1, int dice2) {
		diceLabel(dice1, dice2);
	}
	
	public void turnOnRollDiceButton() {
		 GamePanel gamepanel = (GamePanel)container.getComponent(3);
		 gamepanel.turnOnRollDiceButton();
	}
	
	public void turnOffRollDiceButton() {
		GamePanel gamepanel = (GamePanel)container.getComponent(3);
		gamepanel.turnOffRollDiceButton();
	}
	
	public void diceLabel(int dice1, int dice2) {
		switch (dice1) {
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
		
		switch(dice2) {
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
	}
	
	//Land information GUI
	public void RollDiceSuccess() {
		
		GamePanel gamePanel = (GamePanel) container.getComponent(3);		
		int pos = gameData.getPlayer().getPosition();
		String rent = "";
		String price = "";
		String tax = "";
		
		//name label
		gamePanel.setPropertyName(board.getName(pos));
		
		//price labels if player can buy land
		if(gameData.canBuy()) {
			rent = "Rent: " + Integer.toString(board.getRent(pos)) + " €";
			gamePanel.setRentPrice(rent);
			price = "Price: " + Integer.toString(board.getPurchase(pos)) + " €";
			gamePanel.setPurchasePrice(price);
			gamePanel.setBuyBttn(true);
			gamePanel.setCancelBttn(true);
		}
		else if(pos == 4 || pos == 38){
			tax = "Tax: " + Integer.toString(board.getTax(pos).getTax()) + " €";
			gamePanel.setRentPrice(tax);
			gamePanel.setPurchasePrice("");
			gamePanel.setBuyBttn(false);
			gamePanel.setCancelBttn(false);
		}
		else {
			gamePanel.setRentPrice("Property Not For Sale");
			gamePanel.setPurchasePrice("");
			gamePanel.setBuyBttn(false);
			gamePanel.setCancelBttn(false);
		}
			
	}
	
//	public void BuyPropSuccess()
//	{
//		GamePanel gamePanel = (GamePanel) container.getComponent(1);
//		gamePanel.setPropertyName("Property Successfully Purchased!");
//		gamePanel.setBuyBttn(false);
//		gamePanel.setCancelBttn(false);
//	
//		if (clientGameData.getId() == 0)
//		{
//			squareCollections.get(gameData.getPlayer().getPosition()).setBorder(BorderFactory.createLineBorder(Color.RED));
//		}
//		else if (clientGameData.getId() == 1)
//		{
//			squareCollections.get(gameData.getPlayer().getPosition()).setBorder(BorderFactory.createLineBorder(Color.BLUE));
//		}
//	}
	
	public void BuyPropSuccess(ClientGameData clientGameData)
	{
		GamePanel gamePanel = (GamePanel) container.getComponent(1);
		gamePanel.setPropertyName("Property Successfully Purchased!");
		gamePanel.setBuyBttn(false);
		gamePanel.setCancelBttn(false);
	
		if (clientGameData.getId() == 0)
		{
			squareCollections.get(gameData.getPlayer().getPosition()).setBorder(BorderFactory.createLineBorder(Color.RED));
		}
		else if (clientGameData.getId() == 1)
		{
			squareCollections.get(gameData.getPlayer().getPosition()).setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
	}
		
	// Method that displays a message in the error label.
	  public void displayError(String error)
	  {
		GamePanel gamePanel = (GamePanel) container.getComponent(1);
		gamePanel.setError(error);
	  }
	  

}
