package serverBackend.player;

public abstract class Participant {
	private String name;
	
	public Participant(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
