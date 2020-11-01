package testingpkg;

import java.util.ArrayList;
import java.util.List;

import game.game.PlayGame;
import game.player.Player;


public class Testing {

	public static void main(String[] args) {
		PlayGame game = new PlayGame();
		game.getPlayer().add(new Player("Longtin"));
		game.getPlayer().add(new Player("Dinh"));
		game.run();
		
		System.out.println("Welcome developer! You made it through github");
		System.out.println("Success!");
	}
}
