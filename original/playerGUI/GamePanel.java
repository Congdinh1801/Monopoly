package playerGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import serverBackend.dice.Dice;

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
	
	private ImageIcon backgroundImage;
	
	private JLabel label1;
	private ImageIcon tempImage1;
	private Image image1;
	
	private JLabel label2;
	private ImageIcon tempImage2;
	private Image image2;
	
	private ArrayList<SquarePanel> squareCollections;
	private double resize = 1.5;// 1.2
	private GameClient client;
	private JButton roll;
	
	private JLabel errorLabel;
	private JLabel rentPriceLabel = new JLabel("");
	private JLabel purchasePriceLabel = new JLabel("");
	private JLabel propertyNameLabel = new JLabel("");
	private JButton buyBttn = new JButton("Buy");
	private JButton cancelBttn = new JButton("No Buy");
	
	private JLabel player1;
	private JLabel player1Name;
	private JLabel player1Money;
	private JLabel player2;
	private JLabel player2Name;
	private JLabel player2Money;
	
	private GamePanelControl gpc;

	public GamePanel(GamePanelControl gpc) {
		squareCollections = new ArrayList<>();
		this.gpc = gpc;
		backgroundImage =  new ImageIcon(SquarePanel.class.getResource("/board.png"));
		BoardPanel();
	}

	private void BoardPanel() {
		this.setLayout(new BorderLayout());
		
		ImagePanel imagePanel = new ImagePanel(backgroundImage.getImage());
		
		northPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		southPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		
		centerPanel.setLayout(new FlowLayout());
		
		label1 = new JLabel();
		tempImage1 = new ImageIcon(GamePanel.class.getResource("/Alea_1.png"));
		image1 = tempImage1.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		label1.setIcon(new ImageIcon(image1));
		
		label2 = new JLabel();
		tempImage2 = new ImageIcon(GamePanel.class.getResource("/Alea_1.png"));
		image2 = tempImage2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		label2.setIcon(new ImageIcon(image2));

		gpc.setSquareCollections(squareCollections);
		gpc.setLabel1(label1);
		gpc.setLabel2(label2);
		
		roll = new JButton("Roll Dice");
		roll.addActionListener(gpc);
		roll.setVisible(false);
		
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
//		centerPanel.add(centerwest, BorderLayout.WEST);
//		centerPanel.add(centereast, BorderLayout.EAST);
//		centerPanel.add(centerwest, BorderLayout.WEST);
//		centerPanel.add(centereast, BorderLayout.EAST);
		//centerwest.add(label3); India use centerwest, i will use centereast
		//land information
		JPanel labelPanel = new JPanel(new GridLayout(3,1,0,10));
		labelPanel.add(propertyNameLabel);
		labelPanel.add(rentPriceLabel);
		labelPanel.add(purchasePriceLabel);
		
		//button panel
		JPanel buttonPanel = new JPanel(new GridLayout(2,1,0,5));
		buyBttn.addActionListener(gpc);
		cancelBttn.addActionListener(gpc);
		buyBttn.setVisible(true);
		cancelBttn.setVisible(true);
		buttonPanel.add(buyBttn);
		buttonPanel.add(cancelBttn);
		
	    JPanel landInfoPanel = new JPanel();
	    landInfoPanel.add(labelPanel);
	    landInfoPanel.add(buttonPanel);
	    landInfoPanel.setOpaque(false);
	    landInfoPanel.setAlignmentX(RIGHT_ALIGNMENT);
	    landInfoPanel.setAlignmentY(CENTER_ALIGNMENT);

		OverlayLayout myLayout = new OverlayLayout(centerPanel);
		centerPanel.setLayout(myLayout);
	    
//		centerwest.add(landInfoPanel);
//		centereast.add(panel3);
		centerPanel.add(landInfoPanel);
		centerPanel.add(cancelBttn);
//		centerPanel.add(centerwest, BorderLayout.WEST);
//		centerPanel.add(centereast, BorderLayout.EAST);
//		centerPanel.add(buyBttn);
//		centerPanel.add(cancelBttn);
		JLabel backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage.getImage().getScaledInstance(680, 430, java.awt.Image.SCALE_SMOOTH)));
		backgroundLabel.setAlignmentX(TOP_ALIGNMENT);
		backgroundLabel.setAlignmentY(TOP_ALIGNMENT);
		centerPanel.add(backgroundLabel);
		
		this.setPreferredSize(new Dimension((int)(900 * resize), (int)(600 * resize)));

		addSquares();
		
		//add(roll, BorderLayout.CENTER);
		JPanel westouter = new JPanel(new BorderLayout());
		JPanel eastouter = new JPanel(new BorderLayout());
		westouter.add(centerPanel, BorderLayout.CENTER);
		westouter.add(southPanel, BorderLayout.SOUTH);
		westouter.add(northPanel, BorderLayout.NORTH);
		westouter.add(westPanel, BorderLayout.WEST);
		westouter.add(eastPanel, BorderLayout.EAST);
		
		
		JPanel playergrid = new JPanel();
		playergrid.setLayout(new GridLayout(2, 1, 0, 10));
		
		player1 = new JLabel("Player 1");
		player1Name = new JLabel("Player");
		player1Money = new JLabel("40000");
		JPanel panelPlayer1 = new JPanel(new FlowLayout());
		panelPlayer1.setLayout(new BoxLayout(panelPlayer1, BoxLayout.Y_AXIS));
		panelPlayer1.add(player1);
		panelPlayer1.add(player1Name);
		panelPlayer1.add(player1Money);
		
		player2 = new JLabel("Player 2");
		player2Name = new JLabel("Player");
		player2Money = new JLabel("40000");
		JPanel panelPlayer2 = new JPanel(new FlowLayout());
		panelPlayer2.setLayout(new BoxLayout(panelPlayer2, BoxLayout.Y_AXIS));
		panelPlayer2.add(player2);
		panelPlayer2.add(player2Name);
		panelPlayer2.add(player2Money);
		
		playergrid.add(panelPlayer1);
		playergrid.add(panelPlayer2);
		
		eastouter.add(playergrid);
		
		JPanel buffer = new JPanel(new BorderLayout());
		
		buffer.add(westouter, BorderLayout.WEST);
		buffer.add(eastouter,  BorderLayout.EAST);
		add(buffer);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage.getImage(), 0, 0, null);
	}
	
	public void turnOnRollDiceButton() {
		roll.setVisible(true);
	}
	
	public void setPlayerName(List<String> name) {
		
		for(int i = 0; i < name.size(); i++) {
			if(i  == 0) {
				player1Name.setText(name.get(i));
			} else if(i == 1) {
				player2Name.setText(name.get(i));
			}
		}
		 
	}
	
	public void setPlayerMoney(List<Integer> money) {
		
		for(int i = 0; i < money.size(); i++) {
			if(i == 0) {
				player1Money.setText(Integer.toString(money.get(i)));
			} else if (i == 1) {
				player2Money.setText(Integer.toString(money.get(i)));
			}
		}
	}
	
	public void turnOffRollDiceButton() {
		roll.setVisible(false);
	}

	public void setClient(GameClient client) {
		this.client = client;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}

	public void setPropertyName(String name) {
		
		propertyNameLabel.setText(name);
	}

	public void setRentPrice(String rent) {

		rentPriceLabel.setText(rent);
	}

	public void setPurchasePrice(String price) {
		
		purchasePriceLabel.setText(price);
	}

	public void setBuyBttn (Boolean t) {
		buyBttn.setVisible(t);
	}
	
	public void setCancelBttn (Boolean t) {
		cancelBttn.setVisible(t);
	}
	// Setter for the error text.
	public void setError(String error) {

		errorLabel.setText(error);
	}
	
	public void winGame() 
	{
		JOptionPane.showMessageDialog(this, "You won!", "Monopoly", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void loseGame() 
	{
		JOptionPane.showMessageDialog(this, "You lost.", "Monopoly", JOptionPane.INFORMATION_MESSAGE);
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

		for(int i = 0; i < squareCollections.size(); i++) {
			squareCollections.get(i).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		}
		
		// display players at the start
		squareCollections.get(0).addBothPieces();

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
	
}
