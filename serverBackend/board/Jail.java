package serverBackend.board;

import serverBackend.player.Player;

public class Jail extends Square{

	public Jail(int position) {
		super(position);
	}
	
	public void action(Player player) {
		if(player.isJail()) {
			player.setJail(false);
		} else {
			player.setJail(true);
		}
	}
}
