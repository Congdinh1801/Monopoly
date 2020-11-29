package playerGUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private Image image = null;
	private JLabel backgroundLabel = new JLabel();
	
	public ImagePanel(Image image) {
		this.image = image.getScaledInstance(700, 400, java.awt.Image.SCALE_SMOOTH);
		backgroundLabel.setIcon(new ImageIcon(this.image));
		backgroundLabel.setAlignmentX(TOP_ALIGNMENT);
		backgroundLabel.setAlignmentY(TOP_ALIGNMENT);
		add(backgroundLabel);
		this.setPreferredSize(new Dimension(650, 800));
	}
	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.drawImage(image, 0, 0, null);
//	}
}
