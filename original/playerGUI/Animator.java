package playerGUI;

import java.util.ArrayList;

public class Animator implements Runnable{

	private ArrayList<SquarePanel> squareCollections;
	private int currentPosition = 0;
	private int nextPosition = 0;
	
	public Animator(ArrayList<SquarePanel> squareCollections, int currentPosition, int nextPosition) {
		this.squareCollections = squareCollections;
		this.currentPosition = currentPosition % 40;
		this.nextPosition = nextPosition % 40;
	}
	
	@Override
	public void run() {
		
		while(currentPosition != nextPosition) {
			squareCollections.get(currentPosition).addCatPiece();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			squareCollections.get(currentPosition).removeImage();
			currentPosition = (currentPosition + 1) % 40;
		}
		squareCollections.get(currentPosition).addCatPiece();
	}
}
