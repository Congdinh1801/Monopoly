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
	
	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public GamePanel(){
		BoardPanel();
	}

	
	private void BoardPanel() {
		
		JPanel mainPanel2 = new JPanel();
		OverlayLayout myLayout = new OverlayLayout(mainPanel2);
		mainPanel2.setLayout(myLayout);
		
		southPanel.setLayout(new GridLayout(1, 11));
//		northPanel.setLayout(new GridLayout(1, 13));
//		westPanel.setLayout(new GridLayout(7, 1));
//		eastPanel.setLayout(new GridLayout(7, 1));
		
		tempImage = new ImageIcon(GameFrame.class.getResource("/centerimage.PNG"));
		Image image = tempImage.getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(image));
		
		JLabel catPiece = new JLabel();
		ImageIcon tempImage2 = new ImageIcon(GameFrame.class.getResource("/cat.PNG"));
		Image image2 = tempImage2.getImage().getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
		catPiece.setIcon(new ImageIcon(image2));
		
		SquarePanel startButton = new SquarePanel();
		SquarePanel startButton1 = new SquarePanel();
		SquarePanel startButton2 = new SquarePanel();
		SquarePanel startButton3 = new SquarePanel();
		SquarePanel startButton4 = new SquarePanel();
		SquarePanel startButton5 = new SquarePanel();
		SquarePanel startButton6 = new SquarePanel();
		SquarePanel startButton7 = new SquarePanel();
		SquarePanel startButton8 = new SquarePanel();
		SquarePanel startButton9 = new SquarePanel();
		SquarePanel startButton10 = new SquarePanel();
		
				
		JButton myButton = new JButton("Test");
		myButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("test");
				startButton.removeImage();
				startButton.addCatPiece(catPiece);
				southPanel.removeAll();
				southPanel.add(startButton);
				southPanel.add(startButton1);
				southPanel.add(startButton2);
				southPanel.add(startButton3);
				southPanel.add(startButton4);
				southPanel.add(startButton5);
				southPanel.add(startButton6);
				southPanel.add(startButton7);
				southPanel.add(startButton8);
				southPanel.add(startButton9);
				southPanel.add(startButton10);
				add(southPanel);
				repaint();
			}
			
		});
		
		southPanel.add(startButton);
		southPanel.add(startButton1);
		southPanel.add(startButton2);
		southPanel.add(startButton3);
		southPanel.add(startButton4);
		southPanel.add(startButton5);
		southPanel.add(startButton6);
		southPanel.add(startButton7);
		southPanel.add(startButton8);
		southPanel.add(startButton9);
		southPanel.add(startButton10);
		
		this.setPreferredSize(new Dimension(500, 500));

		
		add(myButton);
		add(imageLabel);
		add(southPanel);
	}
}
