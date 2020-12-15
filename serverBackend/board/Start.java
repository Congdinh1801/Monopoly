package serverBackend.board;

import serverBackend.player.Player;

public class Start extends Square{
	
	private final int freeMoney;

	public Start(int position) {
		super(position);

		freeMoney = 5000;
	}
	
	public void action(Player player) {
		int currentMoney = player.getMoney() + freeMoney;
		player.setMoney(currentMoney);
	}

	public int getFreeMoney() {
		return freeMoney;
	}
}
