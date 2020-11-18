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

public class PlayGame{
	private MonopolyBoard board;
	private Dice dice;
	private boolean stillPlaying;
	private int current = 0;
	private Scanner scan;
	private Player player;
	
	public PlayGame(){
		board = new MonopolyBoard();
		dice = new Dice();
		stillPlaying = true;
		scan = new Scanner(System.in);
		player = new Player("longtin");
	}
	
	public void play() {
		String roll = "";
		int dice = 0;
		
		dice = this.dice.rollDice();
		player.setPosition((player.getPosition() + dice) % 40);

		if(player.getPosition() == 0) {
			passedStart();
		} else if(player.getPosition() == 1) {
			cityProperty();
		} else if(player.getPosition() == 2) {
			lottery();
		} else if(player.getPosition() == 3) {
			cityProperty();
		} else if(player.getPosition() == 4) {
			tax();
		} else if(player.getPosition() == 5) {
			airport();
		} else if(player.getPosition() == 6) {
			cityProperty();
		} else if(player.getPosition() == 7) {
			casino();
		} else if(player.getPosition() == 8) {
			cityProperty();
		} else if(player.getPosition() == 9) {
			cityProperty();
		} else if(player.getPosition() == 10) {
			utilities();
		} else if(player.getPosition() == 11) {
			cityProperty();
		} else if(player.getPosition() == 12) {
			jail();
		} else if(player.getPosition() == 13) {
			cityProperty();
		} else if(player.getPosition() == 14) {
			cityProperty();
		} else if(player.getPosition() == 15) {
			airport();
		} else if(player.getPosition() == 16) {
			cityProperty();
		} else if(player.getPosition() == 17) {
			lottery();
		} else if(player.getPosition() == 18) {
			cityProperty();
		} else if(player.getPosition() == 19) {
			cityProperty();
		} else if(player.getPosition() == 20) {
			vacation();
		} else if(player.getPosition() == 21) {
			cityProperty();
		} else if(player.getPosition() == 22) {
			casino();
		} else if(player.getPosition() == 23) {
			cityProperty();
		} else if(player.getPosition() == 24) {
			cityProperty();
		} else if(player.getPosition() == 25) {
			airport();
		} else if(player.getPosition() == 26) {
			cityProperty();
		} else if(player.getPosition() == 27) {
			cityProperty();
		} else if(player.getPosition() == 28) {
			utilities();
		} else if(player.getPosition() == 29) {
			cityProperty();
		} else if(player.getPosition() == 30) {
			lottery();
		} else if(player.getPosition() == 31) {
			cityProperty();
		} else if(player.getPosition() == 32) {
			goToJail();
		}  else if(player.getPosition() == 33) {
			cityProperty();
		} else if(player.getPosition() == 34) {
			cityProperty();
		} else if(player.getPosition() == 35) {
			airport();
		} else if(player.getPosition() == 36) {
			casino();
		} else if(player.getPosition() == 37) {
			cityProperty();
		} else if(player.getPosition() == 38) {
			tax();
		} else if(player.getPosition() == 39) {
			cityProperty();
		}

		System.out.println("Player: " + player.getName() + "\n" +
				"Cash: " + player.getMoney() + "\n" +
				"Position: " + player.getPosition() + "\n");
	}

	private void passedStart() {
		board.getStart(player.getPosition()).action(player);
		
		System.out.println("You passed the Start square! Here is $200\n" );
	}
	
	private void cityProperty() {
		CityProperty city = board.getCityProperty(player.getPosition());
		
		System.out.println("You are in " + city.getName() + "\n");
		
		String playerOption = "";
		
//		if(city.getOwner() == null) {
//			System.out.println("Would you like to buy the property or auction the property?\n");
//			playerOption = scan.next();
//			
//			if(playerOption.equals("buy")) {
//				city.buyAsset(player);
//			} else {
//				autionProperty();
//			}
//		} else {
//			city.action(player);
//		}
	}
	
	private void autionProperty() {
		
	}
	
	private void tax() {
		board.getTax(player.getPosition()).action(player);
		
		System.out.println("You are in taxed by " + board.getTax(player.getPosition()).getName() + "\n");
	}
	
	private void airport() {
		Airport airplane = board.getAirport(player.getPosition());
		String playerOption = "";
		
		System.out.println("You are in " + airplane.getName() + "\n");
		
//		if(airplane.getOwner() == null) {
//			System.out.println("Would you like to buy the property or auction the property?\n");
//			playerOption = scan.next();
//			
//			if(playerOption.equals("buy")) {
//				airplane.buyAsset(player);
//			} else {
//				autionProperty();
//			}
//		} else {
//			airplane.action(player);
//		}
	}
	
	private void utilities() {
		Utilities util = board.getUtilities(player.getPosition());
		String playerOption = "";
		
		System.out.println("You are in " + util.getName() + "\n");
		
//		if(util.getOwner() == null) {
//			System.out.println("Would you like to buy the property or auction the property?\n");
//			playerOption = scan.next();
//			
//			if(playerOption.equals("buy")) {
//				util.buyAsset(player);
//			} else {
//				autionProperty();
//			}
//		} else {
//			util.action(player);
//		}
	}
	
	private void vacation() {
		board.getVacation(player.getPosition()).action(player);
		System.out.println("You are on vacation!!" + "\n");
	}
	
	private void goToJail() {
		board.getGoToJail(player.getPosition()).action(player);
		System.out.println("You are arrested, and now are in jail!!" + "\n");
	}
	
	public void lottery() {
		board.getLottery(player.getPosition()).action(player);
		System.out.println("Here is a lottery ticket" + "\n");
	}
	
	public void casino() {
		board.getCasino(player.getPosition()).action(player);
		System.out.println("Don't lose your money in the casino" + "\n");
	}
	
	public void jail() {
		board.getJail(player.getPosition()).action(player);
		System.out.println("Thanks for visiting the Euro's jail "  + "\n");
	}
	
	public Player getPlayer() {
		return player;
	}

}
