package playerGUI;

import java.io.Serializable;

import serverBackend.dice.Dice;
import serverBackend.player.Player;

public class AllClientGameData implements Serializable  {
	private int dice1 = 0;
	private int dice2 = 0;
	private int previousPosition = 0;
	private int currentPosition = 0; //current position for current player
	private int currentPlayerID = -1;//0 for player1, 1 for player2
	private int opponentPosition = -1; //position of opponent
//	private int playerid;
//	public int getPlayerid() {
//		return playerid;
//	}
//
//	public void setPlayerid(int playerid) {
//		this.playerid = playerid;
//	}

	public int getOpponentPosition() {
		return opponentPosition;
	}

	public void setOpponentPosition(int opponentPosition) {
		this.opponentPosition = opponentPosition;
	}

	private String buyOrNot = "";	//buy is when you buy, no buy when you don't buy, null if no action
	
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
	
	public int getPreviousPosition() {
		return previousPosition;
	}

	public void setPreviousPosition(int previousPosition) {
		this.previousPosition = previousPosition;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getBuyOrNot() {
		return buyOrNot;
	}

	public void setBuyOrNot(String buyOrNot) {
		this.buyOrNot = buyOrNot;
	}

	public int getcurrentPlayerID() {
		return currentPlayerID;
	}

	public void setcurrentPlayerID(int currentPlayerID) {
		this.currentPlayerID = currentPlayerID;
	}

}
