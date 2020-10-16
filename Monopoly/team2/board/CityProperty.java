package team2.board;

import team2.player.Player;

public class CityProperty extends Asset {
	private final COLOR color;
	private int value = 0;
	
	public CityProperty(int position, COLOR color) {
		super(position);
		this.color = color;
	}
	
	public COLOR getColor() {
		return color;
	}
	
	public void buyAsset(Player player) {
		setOwner(player);
	}
	
	public void action(Player player) {
		value = getRentPrice();
		
		int currentMoney = player.getMoney() - value;
		player.setMoney(currentMoney);
	}
}
