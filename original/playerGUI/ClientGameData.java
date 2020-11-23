package playerGUI;

import java.io.Serializable;

import serverBackend.dice.Dice;

public class ClientGameData implements Serializable  {
	private int dice1;
	private int dice2;
	public int getDice1() {
		return dice1;
	}
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}
	public int getDice2() {
		return dice2;
	}
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

}
