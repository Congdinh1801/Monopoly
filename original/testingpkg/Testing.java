package testingpkg;

import java.util.ArrayList;
import java.util.List;

import serverBackend.game.PlayGame;
import serverBackend.player.Player;


public class Testing {

	public static void main(String[] args) {
		PlayGame game = new PlayGame();
		
		game.play();
		
		System.out.println("Welcome developer! You made it through github");
		System.out.println("Success!");
	}
}
