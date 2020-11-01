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
//				currentPlayer.setPosition((player.getPosition() + dice) % 40);
				System.out.println("Enter position: ");
				currentPlayer.setPosition(scan.nextInt());
				
				if(currentPlayer.getPosition() == 0) {
					passedStart();
				} else if(currentPlayer.getPosition() == 1) {
					cityProperty();
				} else if(currentPlayer.getPosition() == 4) {
					tax();
				} else if(currentPlayer.getPosition() == 5) {
					airport();
				} else if(currentPlayer.getPosition() == 10) {
					utilities();
				} else if(currentPlayer.getPosition() == 20) {
					vacation();
				} else if(currentPlayer.getPosition() == 32) {
					goToJail();
				}
				
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

	public List<Player> getPlayer() {
		return player;
	}
}
