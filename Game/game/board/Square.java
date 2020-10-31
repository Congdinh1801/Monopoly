package game.board;

public abstract class Square {
	private String name;
	final private int position;
	
	public Square(int position){
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}
}
