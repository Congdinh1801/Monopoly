package game.game;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Monopoly Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		frame.getContentPane().add(new GamePanel());
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
