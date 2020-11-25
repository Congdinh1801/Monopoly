package playerGUI;

import java.util.ArrayList;

public class Animator implements Runnable {

	private ArrayList<SquarePanel> squareCollections;
	private int currentPosition = 0;
	private int nextPosition = 0;
	private int playerid = -1;
	private int opponent_position;

	public Animator(ArrayList<SquarePanel> squareCollections, int currentPosition, int nextPosition, int playerid, int opponent_position) {
		this.squareCollections = squareCollections;
		this.currentPosition = currentPosition % 40;
		this.nextPosition = nextPosition % 40;
		this.playerid = playerid;
		this.opponent_position = opponent_position;
	}

	@Override
	public void run() {
		boolean same_position = false;
		while (currentPosition != nextPosition) {
			if (playerid == 0) {
				squareCollections.get(currentPosition).addCatPiece();
			}

			else {
				squareCollections.get(currentPosition).addDogPiece();
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(currentPosition == opponent_position) {
				same_position = true;
			}
			else {
				same_position = false;
			}
			squareCollections.get(currentPosition).removeImage(playerid, same_position);	
			currentPosition = (currentPosition + 1) % 40;
		}
			
		if (playerid == 0) {
			squareCollections.get(currentPosition).addCatPiece();
		}

		else {
			squareCollections.get(currentPosition).addDogPiece();
		}
	}
}
