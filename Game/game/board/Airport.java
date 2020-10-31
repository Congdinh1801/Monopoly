package game.board;

import game.player.Player;

public class Airport extends Asset{
	private int value = 0;
	
	public Airport(int position) {
		super(position);
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
