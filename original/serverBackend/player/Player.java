package serverBackend.player;

public class Player{
	private int money;
	private String name;
	private boolean isJail;
	private int position;
	private int id; //are you player1 or player2, 0 for player1, 1 for player2

	public Player(String name) {
		this.name = name;
		setMoney(40000);
		setJail(false);
		setPosition(0);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isJail() {
		return isJail;
	}

	public void setJail(boolean isJail) {
		this.isJail = isJail;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
