package game.game;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame() {
		initUI();
	}
	
	private void initUI() {
		add(new GamePanel());
		
		setResizable(false);
		pack();
		
		setTitle("Monopoly Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new GameFrame();
			frame.setVisible(true);
		});
	}
}
