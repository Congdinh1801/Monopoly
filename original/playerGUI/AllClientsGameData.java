package playerGUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import serverBackend.board.MonopolyBoard;
import serverBackend.dice.Dice;
import serverBackend.player.Player;

public class AllClientsGameData implements Serializable  {
	private int dice1 = 0;
	private int dice2 = 0;
	private int previousPosition = 0;
	private int currentPosition = 0; //current position for current player
	private int currentPlayerID = -1;//0 for player1, 1 for player2
	private int opponentPosition = -1; //position of opponent
	private int pos;
	private boolean endTurn = false;
	private boolean canBuy = false;
	private boolean initilizedPlayer = false;
	private boolean rollDice = false;
	private String buyOrNot = "";	//buy is when you buy, no buy when you don't buy, null if no action
	private ArrayList<String> name = new ArrayList<>();
	private ArrayList<Integer> currentMoney = new ArrayList<>();
	private MonopolyBoard board;
	private String playersLog;
	
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
	
	public void setEndTurn(boolean endTurn) {
		this.endTurn = endTurn;
	}
	
	public boolean isEndTurn() {
		return endTurn;
	}

	public int getOpponentPosition() {
		return opponentPosition;
	}

	public void setOpponentPosition(int opponentPosition) {
		this.opponentPosition = opponentPosition;
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

	public boolean isInitilizedPlayer() {
		return initilizedPlayer;
	}

	public void setInitilizedPlayer(boolean initilizedPlayer) {
		this.initilizedPlayer = initilizedPlayer;
	}

	public ArrayList getName() {
		return name;
	}

	public void setName(ArrayList name) {
		this.name = name;
	}

	public ArrayList<Integer> getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(ArrayList<Integer> currentMoney) {
		this.currentMoney = currentMoney;
	}

	public boolean isRollDice() {
		return rollDice;
	}

	public void setRollDice(boolean rollDice) {
		this.rollDice = rollDice;
	}

	public String getPlayersLog() {
		return playersLog;
	}

	public void setPlayersLog(String playersLog) {
		this.playersLog = playersLog;
	}
}
