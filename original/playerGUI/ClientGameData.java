package playerGUI;

import java.io.Serializable;

import serverBackend.board.MonopolyBoard;

public class ClientGameData implements Serializable {
	private boolean roll;
	private boolean firstPlayer;
	private boolean canBuy;
	private int pos;
	private MonopolyBoard board;

	public boolean isRoll() {
		return roll;
	}

	public void setRoll(boolean roll) {
		this.roll = roll;
	}

	public boolean isFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(boolean firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public boolean isCanBuy() {
		return canBuy;
	}

	public void setCanBuy(boolean canBuy) {
		this.canBuy = canBuy;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public MonopolyBoard getBoard() {
		return board;
	}

	public void setBoard(MonopolyBoard board) {
		this.board = board;
	}
}
