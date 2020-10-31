package game.dice;

import java.util.Random;

public class Dice {
	private int dice;
	private Random num;
	
	public Dice(){
		dice = 0;
		num = new Random();
	}
	
	public int rollDice() {
		dice = num.nextInt(6) + 1;
		
		return dice;
	}
	
	public int getDice() {
		return dice;
	}

}
