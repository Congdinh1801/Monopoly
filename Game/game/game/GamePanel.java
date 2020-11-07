package game.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GamePanel extends JPanel{
	private JPanel container = new JPanel();
	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private ImageIcon tempImage;
	private Image image;
	private JLabel imageLabel = new JLabel();
	
	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public GamePanel(){
		BoardPanel();
	}

	
	private void BoardPanel() {
		JPanel mainPanel = new JPanel();
		JPanel mainPanel2 = new JPanel();
		
		
		southPanel.setLayout(new GridLayout(1, 11));
//		northPanel.setLayout(new GridLayout(1, 13));
//		westPanel.setLayout(new GridLayout(7, 1));
//		eastPanel.setLayout(new GridLayout(7, 1));
		
		tempImage = new ImageIcon(GameFrame.class.getResource("/board.png"));
		Image image = tempImage.getImage().getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(image));
		
		//mainPanel.add(imageLabel);
		
//		mainPanel.add(northPanel, BorderLayout.NORTH);
//		mainPanel.add(westPanel, BorderLayout.WEST);
//		mainPanel.add(eastPanel, BorderLayout.EAST);

		JLabel catPiece = new JLabel();
		ImageIcon tempImage2 = new ImageIcon(GameFrame.class.getResource("/cat.PNG"));
		Image image2 = tempImage2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		catPiece.setIcon(new ImageIcon(image2));
		
		imageLabel.setLayout(new BorderLayout());
		imageLabel.add(catPiece);
		
		mainPanel.add(catPiece);
		mainPanel2.add(imageLabel);
		//masterPanel.add(catPiece, 2, 0);
		//masterPanel.add(imageLabel, 1, 0);
		
		
//		SquareButton startButton = new SquareButton();
//		SquareButton startButton1 = new SquareButton();
//		SquareButton startButton2 = new SquareButton();
//		SquareButton startButton3 = new SquareButton();
//		SquareButton startButton4 = new SquareButton();
//		SquareButton startButton5 = new SquareButton();
//		SquareButton startButton6 = new SquareButton();
//		SquareButton startButton7 = new SquareButton();
//		SquareButton startButton8 = new SquareButton();
//		SquareButton startButton9 = new SquareButton();
//		SquareButton startButton10 = new SquareButton();
//		startButton.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(startButton.getLocationOnScreen().getY());
//				System.out.println(startButton.getWidth());
//				repaint();
//			}
//			
//		});
//		
//		
//		southPanel.add(startButton);
//		southPanel.add(startButton1);
//		southPanel.add(startButton2);
//		southPanel.add(startButton3);
//		southPanel.add(startButton4);
//		southPanel.add(startButton5);
//		southPanel.add(startButton6);
//		southPanel.add(startButton7);
//		southPanel.add(startButton8);
//		southPanel.add(startButton9);
//		southPanel.add(startButton10);
		
		this.add(mainPanel2, BorderLayout.CENTER);
//		this.add(southPanel, BorderLayout.SOUTH);
		
		this.setPreferredSize(new Dimension(500, 500));
	}
}
