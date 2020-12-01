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
	private StringBuffer playersLog;
	private String playerMoney;
	
	public GameData(){
		board = new MonopolyBoard();
		dice1 = new Dice();
		dice2 = new Dice();
		players = new ArrayList<>();
		money = new ArrayList<>();
		playersLog = new StringBuffer();
	}
	
	public void play(int currentPlayer) {
		int dice1 = 0;
		int dice2 = 0;
		this.currentPlayer = currentPlayer;
		canBuy = false;
		buyButton = true;
		playersLog.delete(0, playersLog.length());
		setCurrentAsset(false, false, false); //Reset assets incase the square a player land is not an asset
		dice1 = this.dice1.rollDice();
		dice2 = this.dice2.rollDice();
		
		playersLog.append("You Roll ");
		playersLog.append((dice1 + dice2));
		playersLog.append(System.lineSeparator());
		
		previousPosition = players.get(currentPlayer).getPosition();
		players.get(currentPlayer).setPosition((players.get(currentPlayer).getPosition() + dice1 + dice2) % 40);
		currentPosition = players.get(currentPlayer).getPosition();

		if(currentPosition < previousPosition && currentPosition != 0) {
			passedStart();
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
		
		updatePlayersMoney();
		checkForLoser();
	}

	public int getPreviousPosition() {
		return previousPosition;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}
	
	public StringBuffer getPlayersLog() {
		return playersLog;
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
		playersLog.delete(0, playersLog.length());
		playerMoney = "Your Money is \n" + players.get(currentPlayer).getMoney();
		
		if(isAirport()) {
			buyAirport();
		} else if(isCityProperty()) {
			buyCityProperty();
		} else if(isUtilities()) {
			buyUtilitites();
		}
		
		playersLog.append(System.lineSeparator());
		playersLog.append(playerMoney);
		playersLog.append(System.lineSeparator());
		updatePlayersMoney();
	}
	
	private void buyCityProperty() {
		CityProperty city = board.getCityProperty(currentPosition);
		city.buyAsset(players.get(currentPlayer));
		playersLog.append("purchased ");
		playersLog.append(System.lineSeparator());
		playersLog.append(city.getName());
		playersLog.append(" for ");
		playersLog.append(city.getPurchasePrice());
		
		playerMoney += " - " + city.getPurchasePrice() + " = " + players.get(currentPlayer).getMoney();
	}
	
	private void buyAirport() {
		Airport airport = board.getAirport(currentPosition);
		airport.buyAsset(players.get(currentPlayer));
		playersLog.append("purchased ");
		playersLog.append(System.lineSeparator());
		playersLog.append(airport.getName());
		playersLog.append(" for ");
		playersLog.append(airport.getPurchasePrice());

		playerMoney += " - " + airport.getPurchasePrice() + " = " + players.get(currentPlayer).getMoney();
	}
	
	private void buyUtilitites() {
		Utilities util = board.getUtilities(currentPosition);
		util.buyAsset(players.get(currentPlayer));
		playersLog.append("purchased ");
		playersLog.append(System.lineSeparator());
		playersLog.append(util.getName());
		playersLog.append(" for ");
		playersLog.append(util.getPurchasePrice());
		
		playerMoney += " - " + util.getPurchasePrice() + " = " + players.get(currentPlayer).getMoney();
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
			playersLog.append("Here " + board.getStart(0).getFreeMoney() + " since you passed start");
			playersLog.append(System.lineSeparator());
		} else {
			board.getStart(currentPosition).action(players.get(currentPlayer));
			playersLog.append("You are in the Start square! Here is " + board.getStart(0).getFreeMoney());
			playersLog.append(System.lineSeparator());
		}
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
			playersLog.append("pay ");
			playersLog.append(city.getRentPrice());
			playersLog.append(System.lineSeparator());
			playersLog.append("to ");
			playersLog.append(players.get((currentPlayer + 1) % players.size()).getName());
			playersLog.append(System.lineSeparator());
		}
		
		setCurrentAsset(false, true, false);
		
	}
	
	private void tax() {
		int money = players.get(currentPlayer).getMoney();
		
		board.getTax(currentPosition).action(players.get(currentPlayer));
		playersLog.append("You are taxed by");
		playersLog.append(System.lineSeparator());
		playersLog.append(board.getTax(currentPosition).getName());
		playersLog.append(System.lineSeparator());
		playersLog.append("Pay ");
		playersLog.append(board.getTax(currentPosition).getTax());
		playersLog.append(System.lineSeparator());
		playersLog.append("Your Money is");
		playersLog.append(System.lineSeparator());
		playersLog.append(money);
		playersLog.append(" - ");
		playersLog.append(board.getTax(currentPosition).getTax());
		playersLog.append(" = ");
		playersLog.append(players.get(currentPlayer).getMoney());
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
			playersLog.append("pay ");
			playersLog.append(airport.getRentPrice());
			playersLog.append(System.lineSeparator());
			playersLog.append("to ");
			playersLog.append(players.get((currentPlayer + 1) % players.size()).getName());
			playersLog.append(System.lineSeparator());
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
			playersLog.append("pay ");
			playersLog.append(util.getRentPrice());
			playersLog.append(System.lineSeparator());
			playersLog.append("to ");
			playersLog.append(players.get((currentPlayer + 1) % players.size()).getName());
			playersLog.append(System.lineSeparator());
		}
		
		setCurrentAsset(false, false, true);
	}
	
	private void vacation() {
		board.getVacation(currentPosition).action(players.get(currentPlayer));
		playersLog.append("are on vacation!!");
		playersLog.append(System.lineSeparator());
	}
	
	private void goToJail() {
		board.getGoToJail(currentPosition).action(players.get(currentPlayer));
		playersLog.append("are arrested, and now are in jail!!");
		playersLog.append(System.lineSeparator());
	}
	
	private void lottery() {
		board.getLottery(currentPosition).action(players.get(currentPlayer));
		playersLog.append("got a lottery ticket");
		playersLog.append(System.lineSeparator());
	}
	
	private void casino() {
		board.getCasino(currentPosition).action(players.get(currentPlayer));
		playersLog.append("is in the casino,");
		playersLog.append(System.lineSeparator());
		playersLog.append("Don't lose your money");
		playersLog.append(System.lineSeparator());
	}
	
	private void jail() {
		board.getJail(currentPosition).action(players.get(currentPlayer));
		playersLog.append("Thanks for visiting");
		playersLog.append(System.lineSeparator());
		playersLog.append("the Euro's jail");
		playersLog.append(System.lineSeparator());
	}
	
	private void checkForLoser() {
		if(players.get(currentPlayer).getMoney() <= 0 ) {
			gameover = true;
			players.get(currentPlayer).setMoney(0);
		}
	}
	
	private void setCurrentAsset(boolean isAirport, boolean isCityProperty, boolean isUtilities) {
		this.isAirport = isAirport;
		this.isCityProperty = isCityProperty;
		this.isUtilities = isUtilities;
	}
	
}
