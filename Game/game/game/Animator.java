package game.game;

import java.util.ArrayList;

public class Animator implements Runnable{

	ArrayList<SquarePanel> squareCollections;
	
	public Animator(ArrayList<SquarePanel> squareCollections) {
		this.squareCollections = squareCollections;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 4; i++) {
			squareCollections.get(i).addCatPiece();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			squareCollections.get(i).removeImage();
		}
	}

}
