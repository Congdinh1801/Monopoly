package game.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.board.Airport;
import game.board.CityProperty;
import game.board.MonopolyBoard;
import game.board.Utilities;
import game.board.Vacation;
import game.dice.Dice;
import game.player.Player;

public class PlayGame implements Runnable{
	private MonopolyBoard board;
	private List<Player> player;
	private Dice dice;
	private boolean stillPlaying;
	private int current = 0;
	private Scanner scan;
	private Player currentPlayer;
	
	public PlayGame(){
		board = new MonopolyBoard();
		dice = new Dice();
		stillPlaying = true;
		scan = new Scanner(System.in);
		player = new ArrayList<>();
	}
	
	public void run() {
		play();
	}
	
	public void play() {
		String roll = "";
		int dice = 0;
		
		while(stillPlaying) {
			currentPlayer = player.get(current);
			System.out.println(currentPlayer.getName());
			System.out.println("Enter \"roll\" to begin\n");
			roll = scan.next();
			
			if(roll.equals("roll")) {
				dice = this.dice.rollDice();
				currentPlayer.setPosition((currentPlayer.getPosition() + dice) % 40);
				
				if(currentPlayer.getPosition() == 0) {
					passedStart();
				} else if(currentPlayer.getPosition() == 1) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 2) {
					lottery();
				} else if(currentPlayer.getPosition() == 3) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 4) {
					tax();
				} else if(currentPlayer.getPosition() == 5) {
					airport();
				} else if(currentPlayer.getPosition() == 6) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 7) {
					casino();
				} else if(currentPlayer.getPosition() == 8) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 9) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 10) {
					utilities();
				} else if(currentPlayer.getPosition() == 11) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 12) {
					jail();
				} else if(currentPlayer.getPosition() == 13) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 14) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 15) {
					airport();
				} else if(currentPlayer.getPosition() == 16) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 17) {
					lottery();
				} else if(currentPlayer.getPosition() == 18) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 19) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 20) {
					vacation();
				} else if(currentPlayer.getPosition() == 21) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 22) {
					casino();
				} else if(currentPlayer.getPosition() == 23) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 24) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 25) {
					airport();
				} else if(currentPlayer.getPosition() == 26) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 27) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 28) {
					utilities();
				} else if(currentPlayer.getPosition() == 29) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 30) {
					lottery();
				} else if(currentPlayer.getPosition() == 31) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 32) {
					goToJail();
				}  else if(currentPlayer.getPosition() == 33) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 34) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 35) {
					airport();
				} else if(currentPlayer.getPosition() == 36) {
					casino();
				} else if(currentPlayer.getPosition() == 37) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 38) {
					goToJail();
				} else if(currentPlayer.getPosition() == 39) {
					tax();
				}
				
				System.out.println("Player: " + currentPlayer.getName() + "\n" +
									"Cash: " + currentPlayer.getMoney() + "\n" +
									"Position: " + currentPlayer.getPosition() + "\n");
				
				
				current = (current + 1) % player.size();
			} else {
				stillPlaying = false;
			}
			
		}
	}

	private void passedStart() {
		board.getStart(currentPlayer.getPosition()).action(currentPlayer);
	}
	
	private void cityProperty() {
		CityProperty city = board.getCityProperty(currentPlayer.getPosition());
		
		String playerOption = "";
		
		if(city.getOwner() == null) {
			System.out.println("Would you like to buy the property or auction the property?\n");
			playerOption = scan.next();
			
			if(playerOption.equals("buy")) {
				city.buyAsset(currentPlayer);
			} else {
				autionProperty();
			}
		} else {
			city.action(currentPlayer);
		}
	}
	
	private void autionProperty() {
		
	}
	
	private void tax() {
		board.getTax(currentPlayer.getPosition()).action(currentPlayer);
	}
	
	private void airport() {
		Airport airplane = board.getAirport(currentPlayer.getPosition());
		String playerOption = "";
		
		if(airplane.getOwner() == null) {
			System.out.println("Would you like to buy the property or auction the property?\n");
			playerOption = scan.next();
			
			if(playerOption.equals("buy")) {
				airplane.buyAsset(currentPlayer);
			} else {
				autionProperty();
			}
		} else {
			airplane.action(currentPlayer);
		}
	}
	
	private void utilities() {
		Utilities util = board.getUtilities(currentPlayer.getPosition());
		String playerOption = "";
		
		if(util.getOwner() == null) {
			System.out.println("Would you like to buy the property or auction the property?\n");
			playerOption = scan.next();
			
			if(playerOption.equals("buy")) {
				util.buyAsset(currentPlayer);
			} else {
				autionProperty();
			}
		} else {
			util.action(currentPlayer);
		}
	}
	
	private void vacation() {
		board.getVacation(currentPlayer.getPosition()).action(currentPlayer);
	}
	
	private void goToJail() {
		board.getGoToJail(currentPlayer.getPosition()).action(currentPlayer);
	}
	
	public void lottery() {
		board.getLottery(currentPlayer.getPosition()).action(currentPlayer);
	}
	
	public void casino() {
		board.getCasino(currentPlayer.getPosition()).action(currentPlayer);
	}
	
	public void jail() {
		board.getJail(currentPlayer.getPosition()).action(currentPlayer);
	}
	
	public List<Player> getPlayer() {
		return player;
	}

}
