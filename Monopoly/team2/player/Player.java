package team2.player;

public class Player extends Participant{
	private int money;
	private boolean isJail;
	private int position;

	public Player(String name) {
		super(name);
		setMoney(40000);
		setJail(false);
		setPosition(0);
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
