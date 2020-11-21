package serverBackend.board;

import serverBackend.player.Player;

public class CityProperty extends Asset {
	private final COLOR color;
	
	public CityProperty(int position, COLOR color) {
		super(position);
		this.color = color;
	}
	
	public COLOR getColor() {
		return color;
	}
	
}
