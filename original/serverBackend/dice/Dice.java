package serverBackend.dice;

import java.io.Serializable;
import java.util.Random;

public class Dice implements Serializable{
	private int dice;
	private Random num;
	
	public Dice(){
		dice = 0;
		num = new Random();
	}
	
	//get dice from client - GamePanelControl
	public Dice(int dice) {
		setDice(dice);
	}
	
	public int rollDice() {
		dice = num.nextInt(6) + 1;
		
		return dice;
	}
	
	public void setDice(int dice) {
	    this.dice = dice;
	  }
	
	public int getDiceNumber() {
		return dice;
	}

}
