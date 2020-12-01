package serverBackend.board;

import serverBackend.player.Player;

public class Start extends Square{
	
	private final int value;

	public Start(int position) {
		super(position);
		value = 1000;
	}
	
	public void action(Player player) {
		int currentMoney = player.getMoney() + value;
		player.setMoney(currentMoney);
	}
}
