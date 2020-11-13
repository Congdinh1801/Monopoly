package longtingui;

import java.util.ArrayList;

public class Animator implements Runnable{

	ArrayList<SquarePanel> squareCollections;
	
	public Animator(ArrayList<SquarePanel> squareCollections) {
		this.squareCollections = squareCollections;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < squareCollections.size(); i = (i + 1) % 40) {
			squareCollections.get(i).addCatPiece();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			squareCollections.get(i).removeImage();
		}
	}

}
