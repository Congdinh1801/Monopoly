package playerGUI;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Animator implements Runnable {

	private ArrayList<SquarePanel> squareCollections;
	private int currentPosition = 0;
	private int nextPosition = 0;
	private int playerid = -1;
	private int opponent_position;
	private CountDownLatch latch = new CountDownLatch(1);

	public Animator(ArrayList<SquarePanel> squareCollections, int currentPosition, int nextPosition,
					int playerid, int opponent_position, CountDownLatch latch) {
		this.squareCollections = squareCollections;
		this.currentPosition = currentPosition % 40;
		this.nextPosition = nextPosition % 40;
		this.playerid = playerid;
		this.opponent_position = opponent_position;
		this.latch = latch;
	}

	@Override
	public void run() {
		boolean same_position = false;
		while (currentPosition != nextPosition) {
			if (playerid == 0) {
				squareCollections.get(currentPosition).addCatPiece();
			} else {
				squareCollections.get(currentPosition).addDogPiece();
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(currentPosition == opponent_position) {
				same_position = true;
			} else {
				same_position = false;
			}
			squareCollections.get(currentPosition).removeImage(playerid, same_position);	
			currentPosition = (currentPosition + 1) % 40;
		}
			
		if (playerid == 0) {
			squareCollections.get(currentPosition).addCatPiece();
			if(currentPosition == 32) {
				squareCollections.get(currentPosition).removeImage(playerid, same_position);
				squareCollections.get(12).addCatPiece();
			}
		}else {
			squareCollections.get(currentPosition).addDogPiece();
			if(currentPosition == 32) {
				squareCollections.get(currentPosition).removeImage(playerid, same_position);
				squareCollections.get(12).addDogPiece();
			}
		}
		
		
		
		latch.countDown();
	}
}
