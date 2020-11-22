package serverBackend.board;

import serverBackend.player.Participant;
import serverBackend.player.Player;

public abstract class Asset extends Square {
	private int purchasePrice;
	private int rentPrice;
	private Participant owner;
	
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
		int currentMoney = player.getMoney() - getRentPrice();;
		player.setMoney(currentMoney);
		System.out.println("you bought something");
	}
	
	public void buyAsset(Player player) {
		int currentMoney = player.getMoney() - getPurchasePrice();
		player.setMoney(currentMoney);
		setOwner(player);
	}

}
