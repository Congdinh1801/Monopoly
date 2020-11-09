//package lab7out;
//
//import javax.swing.JPanel;
//
//public class GamePanel extends JPanel{
//
//	public GamePanel(GamePanegpcontrol gpc) {
//		
//	}
//
//}
package clientGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

//import testingPackage.Test.DrawPanel;

import java.awt.event.*;

public class GamePanel extends JPanel {
	// Private data fields for the important GUI components.
//	private JTextField usernameField;
//	private JPasswordField passwordField;
//	private JLabel errorLabel;
	private JPanel[] squares = new JPanel[40];
	private JLabel[] sqLbs = new JLabel[40];
	//private DrawPanel drawPanel;

	public void setUpSquares() {
		//drawPanel = new DrawPanel();
		for (int i = 0; i < squares.length; i++) {
			squares[i] = new JPanel(new FlowLayout());
			sqLbs[i] = new JLabel("local tax", JLabel.CENTER);
			squares[i].add(sqLbs[i]);
			squares[i].setBackground(Color.RED);
			squares[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			
			// squares[i].setBackground(bg);
//		  Object image;
//		  squares[i]).setIconImage(image);
		}
	}
//	class DrawPanel extends JPanel {
//		private static final long serialVersionUID = 1L;
//
//		public void paintComponent(Graphics g) {
//			g.setColor(Color.BLUE);
//			g.fillRect(0, 0, this.getWidth(), this.getHeight());
//		}
//	}
	// Constructor for the login panel.
	public GamePanel(GamePanelControl gpc) {
		// Create the controller and set it in the chat client.
		// LoginControl controller = new LoginControl(container, client);
		// client.setLoginControl(controller);

		// Create a panel for the labels at the top of the GUI.
		setUpSquares();
		JPanel outermost = new JPanel(new BorderLayout());
		JPanel north = new JPanel(new FlowLayout());
		JPanel south = new JPanel(new FlowLayout());
		JPanel west = new JPanel(new FlowLayout());
		JPanel east = new JPanel(new FlowLayout());
		JPanel center = new JPanel(new FlowLayout());

		JPanel gridNorth = new JPanel(new GridLayout(1, 13, 8, 12));
		JPanel gridSouth = new JPanel(new GridLayout(1, 13, 8, 12));
		JPanel gridWest = new JPanel(new GridLayout(7, 1, 8, 12));
		JPanel gridEast = new JPanel(new GridLayout(7, 1, 8, 12));
		for (int i = 0; i < squares.length; i++) {
			if (i >= 0 && i <= 12) {
				gridSouth.add(squares[i]);
			}
			if (i >= 13 && i <= 19) {
				gridWest.add(squares[i]);
			}
			if (i >= 20 && i <= 32) {
				gridNorth.add(squares[i]);
			}
			if (i >= 33 && i <= 39) {
				gridEast.add(squares[i]);
			}
		}

		// add grid layout to its respective flow layout
		north.add(gridNorth);
		south.add(gridSouth);
		east.add(gridEast);
		west.add(gridWest);


		outermost.add(north, BorderLayout.NORTH);
		outermost.add(south, BorderLayout.SOUTH);
		outermost.add(west, BorderLayout.WEST);
		outermost.add(east, BorderLayout.EAST);
		outermost.add(center, BorderLayout.CENTER);
		
		
		//testing
		String msg = "hello";
		msg.charAt(0);
		
		this.add(outermost);
	}
	
//	public static void main(String[] args)
//	{
//	    new GamePanel(null); //args[0] represents the title of the GUI, since the bat file don't have the server put it here
//	}
}
