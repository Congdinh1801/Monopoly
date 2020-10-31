package game.game;

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
	private Player player;
	private Dice dice;
	private boolean stillPlaying;
	private Scanner scan;
	
	public PlayGame(){
		board = new MonopolyBoard();
		player = new Player("Longtin");
		dice = new Dice();
		stillPlaying = true;
		scan = new Scanner(System.in);
	}
	
	public void run() {
		play();
	}
	
	public void play() {
		String roll = "";
		int dice = 0;
		
		while(stillPlaying) {
			System.out.println("Enter \"roll\" to begin\n");
			roll = scan.next();
			
			if(roll.equals("roll")) {
				dice = this.dice.rollDice();
//				player.setPosition(player.getPosition() + dice);
				System.out.println("Enter position: ");
				player.setPosition(scan.nextInt());
				
				if(player.getPosition() == 0) {
					passedStart();
				} else if(player.getPosition() == 1) {
					cityProperty();
				} else if(player.getPosition() == 4) {
					tax();
				} else if(player.getPosition() == 5) {
					airport();
				} else if(player.getPosition() == 10) {
					utilities();
				} else if(player.getPosition() == 20) {
					vacation();
				} else if(player.getPosition() == 32) {
					goToJail();
				}
			} else {
				stillPlaying = false;
			}
			
		}
	}

	private void passedStart() {
		board.getStart(player.getPosition()).action(player);
	}
	
	private void cityProperty() {
		CityProperty city = board.getCityProperty(player.getPosition());
		String playerOption = "";
		
		if(city.getOwner() == null) {
			System.out.println("Would you like to buy the property or auction the property?\n");
			playerOption = scan.next();
			
			if(playerOption.equals("buy")) {
				city.buyAsset(player);
			} else {
				autionProperty();
			}
		} else {
			city.action(player);
		}
	}
	
	private void autionProperty() {
		
	}
	
	private void tax() {
		board.getTax(player.getPosition()).action(player);
	}
	
	private void airport() {
		Airport airplane = board.getAirport(player.getPosition());
		String playerOption = "";
		
		if(airplane.getOwner() == null) {
			System.out.println("Would you like to buy the property or auction the property?\n");
			playerOption = scan.next();
			
			if(playerOption.equals("buy")) {
				airplane.buyAsset(player);
			} else {
				autionProperty();
			}
		} else {
			airplane.action(player);
		}
	}
	
	private void utilities() {
		Utilities util = board.getUtilities(player.getPosition());
		String playerOption = "";
		
		if(util.getOwner() == null) {
			System.out.println("Would you like to buy the property or auction the property?\n");
			playerOption = scan.next();
			
			if(playerOption.equals("buy")) {
				util.buyAsset(player);
			} else {
				autionProperty();
			}
		} else {
			util.action(player);
		}
	}
	
	private void vacation() {
		board.getVacation(player.getPosition()).action(player);
	}
	
	private void goToJail() {
		board.getGoToJail(player.getPosition()).action(player);
	}
}
