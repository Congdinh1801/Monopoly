package serverBackend.board;

import serverBackend.player.Participant;
import serverBackend.player.Player;

public abstract class Asset extends Square {
	private int purchasePrice;
	private int rentPrice;
	private Participant owner;
	private int value = 0;
	
	public Asset(int position) {
		super(position);
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	public Participant getOwner() {
		return owner;
	}

	public void setOwner(Participant owner) {
		this.owner = owner;
	}
	
	public void action(Player player) {
		value = getRentPrice();
		int currentMoney = player.getMoney() - value;
		player.setMoney(currentMoney);
		System.out.println("you bought something");
	}
	
	public void buyAsset(Player player) {
		setOwner(player);
	}

}
