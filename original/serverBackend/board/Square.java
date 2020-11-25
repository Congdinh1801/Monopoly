package serverBackend.board;

import java.io.Serializable;

public abstract class Square implements Serializable{
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
