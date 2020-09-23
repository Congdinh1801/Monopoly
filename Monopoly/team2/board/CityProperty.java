package team2.board;

public class CityProperty extends Asset {
	final private COLOR color;
	
	public CityProperty(int position, COLOR color) {
		super(position);
		this.color = color;
	}
	
	public COLOR getColor() {
		return color;
	}
}
