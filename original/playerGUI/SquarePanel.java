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
	
	public SquarePanel(String image, int width, int height) {
		createSquare(image, width, height);
		createPlayer();
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
	
	public void createPlayer() {
		catPieceLabel = new JLabel();
		//catPieceTempImage = new ImageIcon(GameFrame.class.getResource("/cat.PNG"));
		catPieceTempImage = new ImageIcon(SquarePanel.class.getResource("/cat.PNG"));
		catPieceImage = catPieceTempImage.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		catPieceLabel.setIcon(new ImageIcon(catPieceImage));
		catPieceLabel.setVisible(true);
		this.add(catPieceLabel);
	}
	
	public void removeImage() {
		this.removeAll();
		this.add(backgroundLabel);
		repaint();
	}
	
	public void addCatPiece() {
		//this.removeAll(); //
		this.add(catPieceLabel);
		this.add(backgroundLabel);
		repaint();
	}
}
