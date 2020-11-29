package serverBackend.board;

import serverBackend.player.Player;

public abstract class Asset extends Square {
	private int purchasePrice;
	private int rentPrice;
	private Player owner;
	
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
		this.rentPrice = rentPrice + 1000;
	}
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public void action(Player player) {
		int currentMoney = player.getMoney() - getRentPrice();;
		player.setMoney(currentMoney);
		getOwner().setMoney(getOwner().getMoney() + getRentPrice());
	}
	
	public void buyAsset(Player player) {
		int currentMoney = player.getMoney() - getPurchasePrice();
		player.setMoney(currentMoney);
		setOwner(player);
	}

}
