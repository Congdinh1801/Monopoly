package playerGUI;

import java.io.Serializable;

import serverBackend.dice.Dice;

public class clientGameData implements Serializable  {
	private Dice dice1;
	private Dice dice2;
	public Dice getDice1() {
		return dice1;
	}
	public void setDice1(Dice dice1) {
		this.dice1 = dice1;
	}
	public Dice getDice2() {
		return dice2;
	}
	public void setDice2(Dice dice2) {
		this.dice2 = dice2;
	}

}
