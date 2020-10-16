package team2.board;

import team2.player.Player;

public class GoToJail extends Square{

	public GoToJail(int position) {
		super(position);
	}
	
	public void action(Player player) {
		player.setJail(true);
		player.setPosition(12);
	}
}
