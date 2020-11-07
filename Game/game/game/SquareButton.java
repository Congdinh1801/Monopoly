package game.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SquareButton extends JButton{
	private ImageIcon tempImage;
	private Image image;
	private Dimension size;
	private RedSquare redSquare = new RedSquare();
	
	public SquareButton(){
		this.setMargin(new Insets(0, 0, 0, 0));
		tempImage = new ImageIcon(SquareButton.class.getResource("/board.png"));
		image = tempImage.getImage().getScaledInstance(40, 50, java.awt.Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(image));
	}
	
}

class RedSquare{

    private int xPos;
    private int yPos;
    private int width = 20;
    private int height = 20;

    public void setX(int xPos){ 
        this.xPos = xPos;
    }

    public int getX(){
        return xPos;
    }

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public int getWidth(){
        return width;
    } 

    public int getHeight(){
        return height;
    }

    public void paintSquare(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(xPos,yPos,width,height);
        g.setColor(Color.BLACK);
        g.drawRect(xPos,yPos,width,height);  
    }
}
