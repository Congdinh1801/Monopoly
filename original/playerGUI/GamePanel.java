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

import serverBackend.game.*;

import javax.swing.JButton;


public class GamePanel extends JPanel{
	private JPanel container = new JPanel();
	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private ImageIcon tempImage;
	private Image image;
	private JLabel imageLabel = new JLabel();
	private ArrayList<SquarePanel> squareCollections;
	//private PlayGame playGame;
	private ExecutorService pool = Executors.newFixedThreadPool(2);
	private double resize = 1.5;//1.2
	private JLabel priceLabel;
	private JLabel errorLabel;
	private JButton buyBttn;
	private ChatClient client = new ChatClient();
	
	public void setClient(ChatClient client) {
	    this.client = client;
	  }
	
	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public GamePanel(GamePanelControl gpc){
		squareCollections = new ArrayList<>();
		//playGame = new PlayGame();
		BoardPanel();
	}
	
	private void BoardPanel() {
		this.setLayout(new BorderLayout());
		
		northPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		southPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		
		
		
		JButton roll = new JButton("Roll Dice");
		roll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//int currentPosition = playGame.getPlayer().getPosition();
				//playGame.play();
				//Runnable r1 = new Animator(squareCollections, currentPosition, playGame.getPlayer().getPosition());
				//pool.execute(r1);
			}
			
		});
		
		this.setPreferredSize(new Dimension((int)(540 * resize), (int)(375 * resize)));

		addSquares();
		add(roll, BorderLayout.CENTER);
		//add(imageLabel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
	}

	private void addSquares() {
		int scaleX = (int)(40 * resize);
		int scaleY = (int)(50 * resize);
		
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
		
		//display player at the start
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
	
	public void setPrice(String price) {
		
		priceLabel.setText(price);
	  }
	
	// Setter for the error text.
	public void setError(String error) {
	    
		errorLabel.setText(error);
	  }
	
	public void BuyPropertiesPanel(GamePanelControl gpc)
	  {
	    //controller and set it in the chat client.
		GamePanelControl controller = new GamePanelControl(container, client);
	    client.setGamePanelControl(controller);
	    
	    // Create a panel for the labels at the top of the GUI.
	    JPanel labelPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	    errorLabel = new JLabel("", JLabel.CENTER);
	    errorLabel.setForeground(Color.RED);
	    priceLabel = new JLabel("", JLabel.CENTER);
	    labelPanel.add(errorLabel);
	    labelPanel.add(priceLabel);
	    
	    // Create a panel the button.
	    JPanel buttonPanel = new JPanel();
	    buyBttn = new JButton("Buy");
	    //buyBttn.addActionListener();
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
