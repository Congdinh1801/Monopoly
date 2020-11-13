package game.board;

import game.player.Player;

public class Start extends Square{
	
	private final int value;

	public Start(int position) {
		super(position);
		value = 5000;
	}
	
	public void action(Player player) {
		int currentMoney = player.getMoney() + value;
		player.setMoney(currentMoney);
	}
}
