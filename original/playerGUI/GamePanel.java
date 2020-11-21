package playerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import serverBackend.game.*;

import javax.swing.JButton;

public class GamePanel extends JPanel {
	private JPanel container = new JPanel();
	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel dice1 = new JPanel();
	private JPanel dice2 = new JPanel();
	private ImageIcon tempImage;
	private Image image;
	private JLabel imageLabel = new JLabel();
	private ArrayList<SquarePanel> squareCollections;
	private GameData gameData;
	private ExecutorService pool = Executors.newFixedThreadPool(2);
	private double resize = 1.5;// 1.2
	private JLabel rentPriceLabel;
	private JLabel purchasePriceLabel;
	private JLabel nameLabel;
	private JLabel errorLabel;
	private JButton buyBttn;
	private ChatClient client = new ChatClient();

	public void setClient(ChatClient client) {
		this.client = client;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}

	public GamePanel(GamePanelControl gpc) {
		squareCollections = new ArrayList<>();
		gameData = new GameData();
		BoardPanel();
	}

	private void BoardPanel() {
		this.setLayout(new BorderLayout());
		
		northPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		southPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		
		centerPanel.setLayout(new FlowLayout());
		
		JLabel label1 = new JLabel();
		label1.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_1.png"));
		JLabel label2 = new JLabel();
		label2.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_1.png"));
		
		JButton roll = new JButton("Roll Dice");
		roll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentPosition = gameData.getPlayer().getPosition();
				gameData.play();
				Runnable r1 = new Animator(squareCollections, currentPosition, gameData.getPlayer().getPosition());
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
				
				int die1 = (int)(Math.random() * 6) + 1;
				
				switch (die1) {
				case 1:
					label1.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_1.png"));
					break;
				case 2:
					label1.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_2.png"));
					break;
				case 3:
					label1.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_3.png"));
					break;
				case 4:
					label1.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_4.png"));
					break;
				case 5:
					label1.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_5.png"));
					break;
				case 6:
					label1.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_6.png"));
					break;
				}
				
				int die2 = (int)(Math.random() * 6) + 1;
				switch(die2) {
				case 1:
					label2.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_1.png"));
					break;
				case 2:
					label2.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_2.png"));
					break;
				case 3:
					label2.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_3.png"));
					break;
				case 4:
					label2.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_4.png"));
					break;
				case 5:
					label2.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_5.png"));
					break;
				case 6:
					label2.setIcon(new ImageIcon("C:\\Users\\Blake\\git\\Monopoly\\resources\\Alea_6.png"));
					break;
				}
			}
		});
		
		
		
		
		
		
		JLabel label3 = new JLabel("test");
		JLabel label4 = new JLabel("test");
		
		
		
		JPanel dicePanel = new JPanel(new GridLayout(1,2,10,1));

		
		dice1 = new JPanel(new FlowLayout());
		dice1.setSize(50, 50);
		dice1.add(label1);
		
		dice2 = new JPanel(new FlowLayout());
		dice2.add(label2);
		JPanel rollbuttonbuffer = new JPanel();
		rollbuttonbuffer.add(roll);
		
		
		JPanel panel3 = new JPanel (new GridLayout(2,1,1,0));
		dicePanel.add(dice1);
		dicePanel.add(dice2);
		panel3.add(dicePanel);
		panel3.add(rollbuttonbuffer);
		
		JPanel centerwest = new JPanel(new FlowLayout());
		JPanel centereast = new JPanel(new FlowLayout());
		centerPanel.add(centerwest, BorderLayout.WEST);
		centerPanel.add(centereast, BorderLayout.EAST);
		//centerwest.add(label3); India use centerwest, i will use centereast
		centereast.add(panel3);
		centerPanel.add(centerwest, BorderLayout.WEST);
		centerPanel.add(centereast, BorderLayout.EAST);
		
		this.setPreferredSize(new Dimension((int)(540 * resize), (int)(375 * resize)));

		addSquares();
		//add(roll, BorderLayout.CENTER);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
	}

	private void addSquares() {
		int scaleX = (int) (40 * resize);
		int scaleY = (int) (50 * resize);

		squareCollections.add(new SquarePanel("/start.PNG", scaleY, scaleY));
		squareCollections.add(new SquarePanel("/istanbul.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/lotteryVertical.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/athens.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/localTax.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/fiumicino.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/rome.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/casinoVertical.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/venice.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/milan.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/motorway.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/barcelona.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/jail.PNG", scaleY, scaleY));
		squareCollections.add(new SquarePanel("/seville.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/madrid.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/barajas.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/bordeaux.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/lotteryHorizontal.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/lyon.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/paris.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/vacation.PNG", scaleY, scaleY));
		squareCollections.add(new SquarePanel("/london.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/casinoVertical.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/brussels.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/amsterdam.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/schiphol.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/oslo.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/stockholm.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/ferry.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/copenhagen.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/lotteryVertical.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/berlin.PNG", scaleX, scaleY));
		squareCollections.add(new SquarePanel("/goToJail.PNG", scaleY, scaleY));
		squareCollections.add(new SquarePanel("/frankfurt.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/munich.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/fjStrauss.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/casinoHorizontal.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/prague.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/touristTax.PNG", scaleY, scaleX));
		squareCollections.add(new SquarePanel("/vienna.PNG", scaleY, scaleX));

		// display player at the start
		squareCollections.get(0).addCatPiece();

		southPanel.add(squareCollections.get(12));
		southPanel.add(squareCollections.get(11));
		southPanel.add(squareCollections.get(10));
		southPanel.add(squareCollections.get(9));
		southPanel.add(squareCollections.get(8));
		southPanel.add(squareCollections.get(7));
		southPanel.add(squareCollections.get(6));
		southPanel.add(squareCollections.get(5));
		southPanel.add(squareCollections.get(4));
		southPanel.add(squareCollections.get(3));
		southPanel.add(squareCollections.get(2));
		southPanel.add(squareCollections.get(1));
		southPanel.add(squareCollections.get(0));
		westPanel.add(squareCollections.get(19));
		westPanel.add(squareCollections.get(18));
		westPanel.add(squareCollections.get(17));
		westPanel.add(squareCollections.get(16));
		westPanel.add(squareCollections.get(15));
		westPanel.add(squareCollections.get(14));
		westPanel.add(squareCollections.get(13));
		northPanel.add(squareCollections.get(20));
		northPanel.add(squareCollections.get(21));
		northPanel.add(squareCollections.get(22));
		northPanel.add(squareCollections.get(23));
		northPanel.add(squareCollections.get(24));
		northPanel.add(squareCollections.get(25));
		northPanel.add(squareCollections.get(26));
		northPanel.add(squareCollections.get(27));
		northPanel.add(squareCollections.get(28));
		northPanel.add(squareCollections.get(29));
		northPanel.add(squareCollections.get(30));
		northPanel.add(squareCollections.get(31));
		northPanel.add(squareCollections.get(32));
		eastPanel.add(squareCollections.get(33));
		eastPanel.add(squareCollections.get(34));
		eastPanel.add(squareCollections.get(35));
		eastPanel.add(squareCollections.get(36));
		eastPanel.add(squareCollections.get(37));
		eastPanel.add(squareCollections.get(38));
		eastPanel.add(squareCollections.get(39));
	}

	public void nameLabel(String name) {

		nameLabel.setText(name);
	}

	public void rentPriceLabel(String rentPrice) {

		rentPriceLabel.setText(rentPrice);
	}

	public void purchasePriceLabel(String purchasePrice) {

		purchasePriceLabel.setText(purchasePrice);
	}

	// Setter for the error text.
	public void setError(String error) {

		errorLabel.setText(error);
	}

	// Buy properties
	public void BuyPropertiesPanel(GamePanelControl gpc) {
		// controller and set it in the chat client.
		GamePanelControl controller = new GamePanelControl(container, client);
		client.setGamePanelControl(controller);

		// Create land name and price info label
		JPanel labelPanel = new JPanel(new GridLayout(3, 1, 5, 5));
		nameLabel = new JLabel("", JLabel.CENTER);
		rentPriceLabel = new JLabel("", JLabel.CENTER);
		purchasePriceLabel = new JLabel("", JLabel.CENTER);
		labelPanel.add(nameLabel);
		labelPanel.add(rentPriceLabel);
		labelPanel.add(purchasePriceLabel);

		// Create a panel the buttons
		JPanel buttonPanel = new JPanel();
		buyBttn = new JButton("Buy");
		buyBttn.addActionListener(gpc);
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(gpc);
		buttonPanel.add(buyBttn);
		buttonPanel.add(cancelButton);

		// Arrange the three panels in a grid.
		JPanel grid = new JPanel(new GridLayout(2, 1, 0, 10));
		grid.add(labelPanel);
		grid.add(buttonPanel);
		this.add(grid);
	}

}
