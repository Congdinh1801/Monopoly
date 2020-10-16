package testingpkg;

import java.util.ArrayList;
import java.util.List;

import team2.board.*;
import team2.player.Player;

public class Testing {

	public static void main(String[] args) {
		Player player = new Player("Longtin");
		MonopolyBoard myBoard = new MonopolyBoard();
		int position = 0;
		
		position = 0;
		
		if(position == 5) {
			Airport airport = myBoard.getAirport(5);
			if(airport.getOwner() == null) {
				airport.setOwner(player);
			} else {
				airport.action(player);
			}
		} else if(position == 4) {
			Tax tax = myBoard.getTax(4);
			tax.action(player);
		} else if(position == 0) {
			Start start = myBoard.getStart(0);
			start.action(player);
		}
		
		System.out.println(player.getMoney());
		
		System.out.println("Welcome developer! You made it through github");
		System.out.println("Success!");
	}
}
