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
import serverBackend.board.Square;

import serverBackend.dice.Dice;

public class GamePanelControl implements ActionListener {

	private JPanel container;
	private ChatClient client;
	private GameData gameData;
	private Asset asset;
	private serverBackend.board.Square square;
	
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
			
			try {
				client.sendToServer(clientGameData);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

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
	
	//Display Land information
	public void RollDiceSuccess() {
		
		GamePanel gamePanel = (GamePanel) container.getComponent(1);
		asset = new Asset(gameData.getPlayer().getPosition()) {
		};
		square = new Square(gameData.getPlayer().getPosition()) {
		};
		
		//name label
		gamePanel.setPropertyName(square.getName());
		
		//price labels
		if(gameData.canBuy()) {
			String rent = Integer.toString(asset.getRentPrice());
			gamePanel.setRentPrice(rent);
			String price = Integer.toString(asset.getPurchasePrice());
			gamePanel.setPurchasePrice(price);
			gamePanel.setBuyBttn(true);
			gamePanel.setCancelBttn(true);
		}
		else {
			gamePanel.setBuyBttn(false);
			gamePanel.setCancelBttn(false);
		}
	}
	
	public void BuyPropSuccess()
	{
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
