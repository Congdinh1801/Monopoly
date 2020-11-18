package serverBackend.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JPanel{
	public GameFrame() {
		initUI();
	}
	
	private void initUI() {
		this.add(new GamePanel());
		
		this.setVisible(true);
		//pack();
		
		//setTitle("Monopoly Board");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(() -> {
//			JFrame frame = new GameFrame();
//			frame.setVisible(true);
//		});
//	}
}
