package serverCommunication;


import java.util.ArrayList;

import serverBackend.board.Airport;
import serverBackend.board.CityProperty;
import serverBackend.board.MonopolyBoard;
import serverBackend.board.Utilities;
import serverBackend.board.Vacation;
import serverBackend.dice.Dice;
import serverBackend.player.Player;

public class GameData{
	private MonopolyBoard board;
	private Dice dice1;
	private Dice dice2;
	private ArrayList<Player> players;
	private int previousPosition;
	private int currentPosition;
	private int currentPlayer;
	private boolean canBuy;
	private boolean isAirport;
	private boolean isCityProperty;
	private boolean isUtilities;
	private boolean buyButton = true;
	private boolean gameover = false;
	private ArrayList<Integer> money;
	private String name;
	
	public GameData(){
		board = new MonopolyBoard();
		dice1 = new Dice();
		dice2 = new Dice();
		players = new ArrayList<>();
		money = new ArrayList<>();
	}
	
	public void play(int currentPlayer) {
		int dice1 = 0;
		int dice2 = 0;
		this.currentPlayer = currentPlayer;
		canBuy = false;
		buyButton = true;
		setCurrentAsset(false, false, false); //Reset assets incase the square a player land is not an asset
		dice1 = this.dice1.rollDice();
		dice2 = this.dice2.rollDice();
//		dice1 = 2;
//		dice2 = 2;
		previousPosition = players.get(currentPlayer).getPosition();
		players.get(currentPlayer).setPosition((players.get(currentPlayer).getPosition() + dice1 + dice2) % 40);
		currentPosition = players.get(currentPlayer).getPosition();

		if(currentPosition < previousPosition && currentPosition != 0) {
			passedStart();
			System.out.println("Here $200 since you passed start\n");
		}
		
		if(currentPosition == 0 ) {
			passedStart();
		} else if(currentPosition == 1) {
			cityProperty();
		} else if(currentPosition == 2) {
			lottery();
		} else if(currentPosition == 3) {
			cityProperty();
		} else if(currentPosition == 4) {
			tax();
		} else if(currentPosition == 5) {
			airport();
		} else if(currentPosition == 6) {
			cityProperty();
		} else if(currentPosition == 7) {
			casino();
		} else if(currentPosition == 8) {
			cityProperty();
		} else if(currentPosition == 9) {
			cityProperty();
		} else if(currentPosition == 10) {
			utilities();
		} else if(currentPosition == 11) {
			cityProperty();
		} else if(currentPosition == 12) {
			jail();
		} else if(currentPosition == 13) {
			cityProperty();
		} else if(currentPosition == 14) {
			cityProperty();
		} else if(currentPosition == 15) {
			airport();
		} else if(currentPosition == 16) {
			cityProperty();
		} else if(currentPosition == 17) {
			lottery();
		} else if(currentPosition == 18) {
			cityProperty();
		} else if(currentPosition == 19) {
			cityProperty();
		} else if(currentPosition == 20) {
			vacation();
		} else if(currentPosition == 21) {
			cityProperty();
		} else if(currentPosition == 22) {
			casino();
		} else if(currentPosition == 23) {
			cityProperty();
		} else if(currentPosition == 24) {
			cityProperty();
		} else if(currentPosition == 25) {
			airport();
		} else if(currentPosition == 26) {
			cityProperty();
		} else if(currentPosition == 27) {
			cityProperty();
		} else if(currentPosition == 28) {
			utilities();
		} else if(currentPosition == 29) {
			cityProperty();
		} else if(currentPosition == 30) {
			lottery();
		} else if(currentPosition == 31) {
			cityProperty();
		} else if(currentPosition == 32) {
			goToJail();
		}  else if(currentPosition == 33) {
			cityProperty();
		} else if(currentPosition == 34) {
			cityProperty();
		} else if(currentPosition == 35) {
			airport();
		} else if(currentPosition == 36) {
			casino();
		} else if(currentPosition == 37) {
			cityProperty();
		} else if(currentPosition == 38) {
			tax();
		} else if(currentPosition == 39) {
			cityProperty();
		}

		System.out.println("Player: " + players.get(currentPlayer).getName() + "\n" +
				"Cash: " + players.get(currentPlayer).getMoney() + "\n" +
				"Position: " + currentPosition + "\n");
		
		updatePlayersMoney();
		checkForLoser();
	}

	public int getPreviousPosition() {
		return previousPosition;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}
	
	public boolean isAirport() {
		return isAirport;
	}

	public boolean isCityProperty() {
		return isCityProperty;
	}

	public boolean isUtilities() {
		return isUtilities;
	}

	public boolean canBuy() {
		//check if the land is available or not
		return canBuy;
	}
	
	public boolean isBuyButton() {
		return buyButton;
	}

	public boolean isGameover() {
		return gameover;
	}

	public void buyAsset() {
		if(isAirport()) {
			buyAirport();
		} else if(isCityProperty()) {
			buyCityProperty();
		} else if(isUtilities()) {
			buyUtilitites();
		}
		
		updatePlayersMoney();
	}
	
	private void buyCityProperty() {
		CityProperty city = board.getCityProperty(currentPosition);
		city.buyAsset(players.get(currentPlayer));
	}
	
	private void buyAirport() {
		Airport airport = board.getAirport(currentPosition);
		airport.buyAsset(players.get(currentPlayer));
	}
	
	private void buyUtilitites() {
		Utilities util = board.getUtilities(currentPosition);
		util.buyAsset(players.get(currentPlayer));
	}
	
	public ArrayList<Player> getPlayer() {
		return players;
	}
	
	public ArrayList<Integer> getMoney() {
		return money;
	}

	public void setMoney(ArrayList<Integer> money) {
		this.money = money;
	}

	public Dice getDice1() {
		return dice1;
	}
	
	public Dice getDice2() {
		return dice2;
	}

	private void updatePlayersMoney() {
		money.removeAll(money);
		
		for(int i = 0; i < players.size(); i++) {
			money.add(players.get(i).getMoney());
		}
	}
	
	private void passedStart() {
		if(currentPosition < previousPosition && currentPosition != 0) {
			board.getStart(0).action(players.get(currentPlayer));
		} else {
			board.getStart(currentPosition).action(players.get(currentPlayer));
		}
		
		System.out.println("You are int the Start square! Here is $200\n" );
	}
	
	
	private void autionProperty() {
		
	}
	
	private void cityProperty() {
		CityProperty city = board.getCityProperty(currentPosition);
		
		if(city.getOwner() == null) {
			if(players.get(currentPlayer).getMoney() > city.getPurchasePrice()) {
				canBuy = true;
			} else {
				buyButton = false;
			}
			
		} else {
			canBuy = false;
			city.action(players.get(currentPlayer));
		}
		
		setCurrentAsset(false, true, false);
		
	}
	
	private void tax() {
		board.getTax(currentPosition).action(players.get(currentPlayer));
		
		System.out.println("You are in taxed by " + board.getTax(currentPosition).getName() + "\n");
	}
	
	private void airport() {
		Airport airport = board.getAirport(currentPosition);
		
		if(airport.getOwner() == null) {
			if(players.get(currentPlayer).getMoney() > airport.getPurchasePrice()) {
				canBuy = true;
			} else {
				buyButton = false;
			}
		} else {
			canBuy = false;
			airport.action(players.get(currentPlayer));
		}
		
		setCurrentAsset(true, false, false);
	}
	
	private void utilities() {
		Utilities util = board.getUtilities(currentPosition);
		
		if(util.getOwner() == null) {
			if(players.get(currentPlayer).getMoney() > util.getPurchasePrice()) {
				canBuy = true;
			} else {
				buyButton = false;
			}
		} else {
			canBuy = false;
			util.action(players.get(currentPlayer));
		}
		
		setCurrentAsset(false, false, true);
	}
	
	private void vacation() {
		board.getVacation(currentPosition).action(players.get(currentPlayer));
		System.out.println("You are on vacation!!" + "\n");
	}
	
	private void goToJail() {
		board.getGoToJail(currentPosition).action(players.get(currentPlayer));
		System.out.println("You are arrested, and now are in jail!!" + "\n");
	}
	
	private void lottery() {
		board.getLottery(currentPosition).action(players.get(currentPlayer));
		System.out.println("Here is a lottery ticket" + "\n");
	}
	
	private void casino() {
		board.getCasino(currentPosition).action(players.get(currentPlayer));
		System.out.println("Don't lose your money in the casino" + "\n");
	}
	
	private void jail() {
		board.getJail(currentPosition).action(players.get(currentPlayer));
		System.out.println("Thanks for visiting the Euro's jail "  + "\n");
	}
	
	private void checkForLoser() {
		if(players.get(currentPlayer).getMoney() <= 0 ) {
			gameover = true;
		}
	}
	
	private void setCurrentAsset(boolean isAirport, boolean isCityProperty, boolean isUtilities) {
		this.isAirport = isAirport;
		this.isCityProperty = isCityProperty;
		this.isUtilities = isUtilities;
	}
	
}
