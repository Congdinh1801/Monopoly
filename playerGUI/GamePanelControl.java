package playerGUI;

import java.awt.Color;
import java.awt.Image;

//import game.dice.Dice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import serverBackend.board.Airport;
import serverBackend.board.CityProperty;
import serverBackend.board.MonopolyBoard;
import serverBackend.board.Utilities;
import serverBackend.dice.Dice;
import serverBackend.player.Player;

public class GamePanelControl implements ActionListener {

	private JPanel container;
	private GameClient client;

	private JLabel label1;
	private ImageIcon tempImage1;
	private Image image1;
	
	private JLabel label2;
	private ImageIcon tempImage2;
	private Image image2;

	private ArrayList<SquarePanel> squareCollections;
	private ExecutorService pool = Executors.newFixedThreadPool(1);	//2
	
	public GamePanelControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}
	
	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}
	
	public void setSquareCollections(ArrayList<SquarePanel> squareCollections) {
		this.squareCollections = squareCollections;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		//roll dice control
		if (command == "Roll Dice") {
			try {
				client.sendToServer("Roll Dice");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(command == "Buy") {
			try {
				client.sendToServer("Buy");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(command == "No Buy") {
			try {
				client.sendToServer("No Buy");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updatePlayer(int previousPosition, int currentPosition, int playerid, int opponent_position) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		Runnable r1 = new Animator(squareCollections, previousPosition, currentPosition, playerid, opponent_position, latch);
		pool.execute(r1);
		turnOffRollDiceButton();
		latch.await();
	}
	
	public void turnOffBuyButtons() {
		GamePanel gamePanel = (GamePanel) container.getComponent(3);
		gamePanel.setBuyBttn(false);
		gamePanel.setCancelBttn(false);
		turnOnRollDiceButton();
		
	}
	
	public void buyPropSuccess(int currentPosition, int currentPlayer) {
		if(currentPlayer == 0) {
			squareCollections.get(currentPosition).setBorder(BorderFactory.createLineBorder(Color.RED,1));
		} else if(currentPlayer == 1){
			squareCollections.get(currentPosition).setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
		}
	}
	
	public void appendPlayersLog(String toAppend) {
		GamePanel gamePanel = (GamePanel) container.getComponent(3);
		gamePanel.appendToPlayersLog(toAppend);
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
	
	public void setPlayerName(List<String> name) {
		GamePanel gamepanel = (GamePanel)container.getComponent(3);
		gamepanel.setPlayerName(name);
	}
	
	public void setPlayerMoney(List<Integer> money) {
		GamePanel gamepanel = (GamePanel)container.getComponent(3);
		gamepanel.setPlayerMoney(money);
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
	
	public void RollDiceSuccess(boolean canBuy, int pos, MonopolyBoard board) {
		
		GamePanel gamePanel = (GamePanel) container.getComponent(3);		
		String rent = "";
		String price = "";
		String tax = "";
	
		//name label
		gamePanel.setPropertyName(board.getName(pos));
		
		//price labels if player can buy land
		if(canBuy) {
			if(pos == 10 || pos == 28) {
				rent = "Rent: 100 � x dicesum (1 utilities) Or 300 � x dicesum (2 utilities)";
			}
			else {
				rent = "Rent: " + Integer.toString(board.getRent(pos)) + " �";
			}			
			gamePanel.setRentPrice(rent);
			price = "Price: " + Integer.toString(board.getPurchase(pos)) + " �";
			gamePanel.setPurchasePrice(price);
			gamePanel.setRentPrice(rent);
			gamePanel.setPurchasePrice(price);
		}
		else if(pos == 4 || pos == 38){

			tax = "Tax: " + Integer.toString((board.getTax(pos)).getTax()) + " �";
			gamePanel.setRentPrice(tax);
			gamePanel.setPurchasePrice("");
		}
		else {
			gamePanel.setRentPrice("Property Not For Sale");
			gamePanel.setPurchasePrice("");
		}
			
	}
	
	public void displayBuyOrNotButton(boolean canBuy, boolean buyButton) {
		GamePanel gamePanel = (GamePanel) container.getComponent(3);	
		if(canBuy) {
			gamePanel.setBuyBttn(buyButton);
			gamePanel.setCancelBttn(true);
		} else{
			gamePanel.setBuyBttn(false);
			gamePanel.setCancelBttn(false);
		}
	}
	
	// Method that displays a message in the error label.
	  public void displayError(String error)
	  {
		GamePanel gamePanel = (GamePanel) container.getComponent(1);
		gamePanel.setError(error);
	  }
	  
	  public void displayTheWinner(boolean loser) {
		  GamePanel gamePanel = (GamePanel) container.getComponent(3);
		  
		  if(loser) {
			  gamePanel.loseGame();
		  } else {
			  gamePanel.winGame();
		  }
		  
	  }

}
