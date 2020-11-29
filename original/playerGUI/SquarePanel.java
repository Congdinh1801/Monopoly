package playerGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class SquarePanel extends JPanel{
	private ImageIcon backgroundTempImage;
	private Image backgroundImage;
	private JLabel backgroundLabel;
	
	private JLabel catPieceLabel;
	private ImageIcon catPieceTempImage;
	private Image catPieceImage;
	
	private JLabel dogPieceLabel;
	private ImageIcon dogPieceTempImage;
	private Image dogPieceImage;
	
	private String image;
	private int width;
	private int height;
	
//	private int playerid;
	
	public SquarePanel(String image, int width, int height) {
		this.image = image;
		this.height = height;
		this.width = width;
		createSquare(image, width, height);
		createPlayers();
	}
	
	public void createSquare(String image, int width, int height) {
		OverlayLayout myLayout = new OverlayLayout(this);
		this.setLayout(myLayout);
		backgroundLabel = new JLabel();
		backgroundTempImage = new ImageIcon(SquarePanel.class.getResource(image));
		backgroundImage = backgroundTempImage.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		backgroundLabel.setIcon(new ImageIcon(backgroundImage));
		this.add(backgroundLabel);
	}
	
	public void createPlayers() {
		catPieceLabel = new JLabel();
		dogPieceLabel = new JLabel();
		
		catPieceTempImage = new ImageIcon(SquarePanel.class.getResource("/cat.PNG"));
		catPieceImage = catPieceTempImage.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		catPieceLabel.setIcon(new ImageIcon(catPieceImage));
		
		dogPieceTempImage = new ImageIcon(SquarePanel.class.getResource("/dog.png"));
		dogPieceImage = dogPieceTempImage.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		dogPieceLabel.setIcon(new ImageIcon(dogPieceImage));
		
		dogPieceLabel.setVisible(true);
		catPieceLabel.setVisible(true);
		
//		dogPieceLabel.setAlignmentX(-3f);
		dogPieceLabel.setAlignmentY(0.0f);
		
//		catPieceLabel.setAlignmentX(-3f);
		catPieceLabel.setAlignmentY(1.0f);
		
		this.add(dogPieceLabel);
		this.add(catPieceLabel);
		
	}
	
	public void removeImage(int playerid, boolean same_position) {
		this.removeAll();
		if(playerid == 0  && same_position)
		{
			this.add(dogPieceLabel);
		}
		if(playerid == 1  && same_position)
		{
			this.add(catPieceLabel);
		}

		this.add(backgroundLabel);
		repaint();
	}

	public void addBothPieces() {
		this.removeAll(); 
		this.add(catPieceLabel);
		this.add(dogPieceLabel);
		this.add(backgroundLabel);
		repaint();
	}
	
	public void addCatPiece() {
		this.removeAll(); 
		this.add(catPieceLabel);
		this.add(backgroundLabel);
		repaint();
	}
	public void addDogPiece() {
		this.removeAll(); 
		this.add(dogPieceLabel);
		this.add(backgroundLabel);
		repaint();
	}
}
