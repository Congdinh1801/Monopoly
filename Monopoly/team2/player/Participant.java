package team2.player;

public abstract class Participant {
	private String name;
	
	public Participant(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
