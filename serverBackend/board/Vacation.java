package serverBackend.board;

import serverBackend.player.Player;

public class Vacation extends Square{

	public Vacation(int position) {
		super(position);
	}
	
	public void action(Player player) {
		System.out.println("Enjoy your Martini");
	}

}
