package game.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Component;

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
	private Runnable r1;
	private ExecutorService pool = Executors.newFixedThreadPool(3);
	
	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public GamePanel(){
		squareCollections = new ArrayList<>();
		r1 = new Animator(squareCollections);
		BoardPanel();
	}
	
	private void BoardPanel() {
		this.setLayout(new BorderLayout());
		
		southPanel.setLayout(new GridLayout(1, 4));
//		northPanel.setLayout(new GridLayout(1, 13));
//		westPanel.setLayout(new GridLayout(7, 1));
//		eastPanel.setLayout(new GridLayout(7, 1));
		
		tempImage = new ImageIcon(GameFrame.class.getResource("/centerimage.PNG"));
		Image image = tempImage.getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(image));
		
		
		SquarePanel startButton = new SquarePanel("/start.PNG");
		squareCollections.add(startButton);
		SquarePanel startButton1 = new SquarePanel("/istanbul.PNG");
		squareCollections.add(startButton1);
		SquarePanel startButton2 = new SquarePanel("/lotteryVertical.PNG");
		squareCollections.add(startButton2);
		SquarePanel startButton3 = new SquarePanel("/athens.PNG");
		squareCollections.add(startButton3);
		
		JButton roll = new JButton("Roll Dice");
		roll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pool.execute(r1);
			}
			
		});
		
		southPanel.add(startButton3);
		southPanel.add(startButton2);
		southPanel.add(startButton1);
		southPanel.add(startButton);
		
		this.setPreferredSize(new Dimension(500, 500));

		
		add(roll, BorderLayout.NORTH);
		add(imageLabel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}

}
