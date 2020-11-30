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
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

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
	
	private ImagePanel imageCenterPanel;
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
	private JTextArea playersLog;
	private DefaultCaret caret;
	
	private GamePanelControl gpc;

	public GamePanel(GamePanelControl gpc) {
		squareCollections = new ArrayList<>();
		this.setBackground(new Color(44, 137, 160));
		this.gpc = gpc;
		backgroundImage = new ImageIcon(SquarePanel.class.getResource("/centerimage.PNG"));
		BoardPanel();
	}

	private void BoardPanel() {
		this.setLayout(new BorderLayout());
		
		imageCenterPanel = new ImagePanel(backgroundImage.getImage());
		
		northPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		northPanel.setOpaque(false);
		southPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		southPanel.setOpaque(false);
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		westPanel.setOpaque(false);
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		eastPanel.setOpaque(false);
		
		centerPanel.setLayout(new FlowLayout());
		centerPanel.setOpaque(false);
		
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
		
		JPanel dicePanel = new JPanel(new GridLayout(1,2,10,1));

		dice1 = new JPanel(new FlowLayout());
		dice1.setSize(50, 50);
		dice1.add(label1);
		dice1.setOpaque(false);
		
		dice2 = new JPanel(new FlowLayout());
		dice2.add(label2);
		dice2.setOpaque(false);
		
		JPanel rollbuttonbuffer = new JPanel();
		rollbuttonbuffer.add(roll);
		rollbuttonbuffer.setOpaque(false);
		
		
		JPanel panel3 = new JPanel (new GridLayout(2,1,1,0));
		dicePanel.add(dice1);
		dicePanel.add(dice2);
		dicePanel.setOpaque(false);
		panel3.add(dicePanel);
		panel3.add(rollbuttonbuffer);
		panel3.setOpaque(false);
		
		JPanel centerwest = new JPanel(new FlowLayout());
		JPanel centereast = new JPanel(new FlowLayout());
		centerwest.setOpaque(false);
		centereast.setOpaque(false);
		//centerwest.add(label3); India use centerwest, i will use centereast
		//land information
		JPanel labelPanel = new JPanel(new GridLayout(3,1,0,10));
		labelPanel.setOpaque(false);
		labelPanel.add(propertyNameLabel);
		labelPanel.add(rentPriceLabel);
		labelPanel.add(purchasePriceLabel);
		
		//button panel
		JPanel buttonPanel = new JPanel(new GridLayout(2,1,0,5));
		buttonPanel.setOpaque(false);
		buyBttn.addActionListener(gpc);
		cancelBttn.addActionListener(gpc);
		buyBttn.setVisible(false);
		cancelBttn.setVisible(false);
		buttonPanel.add(buyBttn);
		buttonPanel.add(cancelBttn);
		
	    JPanel landInfoPanel = new JPanel(new GridLayout(2, 1, 0, 10));
	    landInfoPanel.setOpaque(false);
	    landInfoPanel.add(labelPanel);
	    landInfoPanel.add(buttonPanel);
	    
		centerwest.add(landInfoPanel);
		centereast.add(panel3);
		centerPanel.add(centerwest, BorderLayout.WEST);
		centerPanel.add(centereast, BorderLayout.EAST);
		imageCenterPanel.add(centerPanel);

		addSquares();
		
		//add(roll, BorderLayout.CENTER);
		JPanel westouter = new JPanel(new BorderLayout());
		westouter.setOpaque(false);
		JPanel eastouter = new JPanel(new BorderLayout());
		eastouter.setOpaque(false);
		westouter.add(imageCenterPanel, BorderLayout.CENTER);
		westouter.add(southPanel, BorderLayout.SOUTH);
		westouter.add(northPanel, BorderLayout.NORTH);
		westouter.add(westPanel, BorderLayout.WEST);
		westouter.add(eastPanel, BorderLayout.EAST);
		
		
		JPanel playergrid = new JPanel();
		playergrid.setBackground(Color.WHITE);
		playergrid.setLayout(new BoxLayout(playergrid, BoxLayout.Y_AXIS));
		
		player1 = new JLabel("Player 1");
		player1.setForeground(Color.RED);
		Border player1Border = player1.getBorder();
		Border player1Margin = new EmptyBorder(5,0,0,20);
		player1.setFont(new Font("Verdana", Font.PLAIN, 32));
		player1.setBorder(new CompoundBorder(player1Border, player1Margin));
		
		player1Name = new JLabel("Player");
		Border player1NameBorder = player1Name.getBorder();
		player1Name.setFont(new Font("Verdana", Font.PLAIN, 18));
		player1Name.setBorder(new CompoundBorder(player1NameBorder, player1Margin));
		
		player1Money = new JLabel("Money: 30000");
		Border player1MoneyBorder = player1Name.getBorder();
		Border player1MoneyMargin = new EmptyBorder(5,0,50,20);
		player1Money.setFont(new Font("Verdana", Font.PLAIN, 18));
		player1Money.setBorder(new CompoundBorder(player1MoneyBorder, player1MoneyMargin));

		JPanel panelPlayer1 = new JPanel(new FlowLayout());
		panelPlayer1.setOpaque(false);
		panelPlayer1.setLayout(new BoxLayout(panelPlayer1, BoxLayout.Y_AXIS));
		panelPlayer1.setPreferredSize(new Dimension(200, 150));
		panelPlayer1.add(player1);
		panelPlayer1.add(player1Name);
		panelPlayer1.add(player1Money);
		
		player2 = new JLabel("Player 2");
		player2.setForeground(Color.BLUE);
		Border player2Border = player2.getBorder();
		Border player2Margin = new EmptyBorder(5,0,0,20);
		player2.setFont(new Font("Verdana", Font.PLAIN, 32));
		player2.setBorder(new CompoundBorder(player2Border, player2Margin));
		
		player2Name = new JLabel("Name: Player");
		Border player2NameBorder = player2Name.getBorder();
		player2Name.setFont(new Font("Verdana", Font.PLAIN, 18));
		player2Name.setBorder(new CompoundBorder(player2NameBorder, player2Margin));
		
		player2Money = new JLabel("Money: 30000");
		Border player2MoneyBorder = player1Name.getBorder();
		Border player2BottomMargin = new EmptyBorder(5,0,50,20);
		player2Money.setFont(new Font("Verdana", Font.PLAIN, 18));
		player2Money.setBorder(new CompoundBorder(player2MoneyBorder, player2BottomMargin));
		
		JPanel panelPlayer2 = new JPanel(new FlowLayout());
		panelPlayer2.setOpaque(false);
		panelPlayer2.setLayout(new BoxLayout(panelPlayer2, BoxLayout.Y_AXIS));
		panelPlayer2.add(player2);
		panelPlayer2.add(player2Name);
		panelPlayer2.add(player2Money);
		
		JLabel logTitle = new JLabel("Player's Log");
		logTitle.setFont(new Font("Verdana", Font.PLAIN, 18));
		Border logTitleBorder = player1Name.getBorder();
		Border logTitleMargin = new EmptyBorder(5,30,10,20);
		logTitle.setBorder(new CompoundBorder(logTitleBorder, logTitleMargin));
		
		playersLog = new JTextArea();
		playersLog.setEditable(false);
		playersLog.setFont(new Font("Verdana", Font.PLAIN, 12));
		caret = (DefaultCaret)playersLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane playersLogPane = new JScrollPane(playersLog);
		playersLogPane.setOpaque(false);
		playersLogPane.setPreferredSize(new Dimension(25, 25));

		Border playersLogPaneBorder = playersLogPane.getBorder();
		Border playersLogPaneMargin = new EmptyBorder(20,20,0,0);
		playersLogPane.setBorder(new CompoundBorder(playersLogPaneBorder, playersLogPaneMargin));
		
		playergrid.add(panelPlayer1);
		playergrid.add(panelPlayer2);
		playergrid.add(logTitle);
		playergrid.add(playersLogPane);
		
		eastouter.add(playergrid);
		
		JPanel buffer = new JPanel(new BorderLayout());
		buffer.setOpaque(false);
		
		buffer.add(westouter, BorderLayout.WEST);
		buffer.add(eastouter,  BorderLayout.EAST);
		this.setPreferredSize(new Dimension((int)(950 * resize), (int)(600 * resize)));
		add(buffer);
	}
	
	public void turnOnRollDiceButton() {
		roll.setVisible(true);
	}
	
	public void appendToPlayersLog(String toAppend) {
		playersLog.append(toAppend);
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}
	
	public void setPlayerName(List<String> name) {
		
		for(int i = 0; i < name.size(); i++) {
			if(i  == 0) {
				player1Name.setText("Name: " + name.get(i));
			} else if(i == 1) {
				player2Name.setText("Name: " + name.get(i));
			}
		}
		 
	}
	
	public void setPlayerMoney(List<Integer> money) {
		
		for(int i = 0; i < money.size(); i++) {
			if(i == 0) {
				player1Money.setText("Money: " + Integer.toString(money.get(i)));
			} else if (i == 1) {
				player2Money.setText("Money: " + Integer.toString(money.get(i)));
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
	
	private void setPlayerTable() {
		
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
			squareCollections.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
			squareCollections.get(i).setOpaque(false);
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
