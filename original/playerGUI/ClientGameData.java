package playerGUI;

import java.io.Serializable;

import serverBackend.board.MonopolyBoard;

public class ClientGameData implements Serializable {
	private boolean roll = false;
	private boolean firstPlayer = false;
	private boolean isLoser = false;
	private boolean canBuy = false;
	private boolean endTurn = false;
	private boolean buyButton = true;
	private boolean gameover = false;

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

	public boolean isEndTurn() {
		return endTurn;
	}

	public void setEndTurn(boolean endTurn) {
		this.endTurn = endTurn;
	}

	public boolean isCanBuy() {
		return canBuy;
	}

	public void setCanBuy(boolean canBuy) {
		this.canBuy = canBuy;
	}

	public boolean isBuyButton() {
		return buyButton;
	}

	public void setBuyButton(boolean buyButton) {
		this.buyButton = buyButton;
	}

	public boolean isLoser() {
		return isLoser;
	}

	public void setLoser(boolean isLoser) {
		this.isLoser = isLoser;
	}

	public boolean isGameover() {
		return gameover;
	}

	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}

}
