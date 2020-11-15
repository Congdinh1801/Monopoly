package clientGUI;


public class RollDiceData {
	
	public int diceMoves = 0;

	public RollDiceData(int dice){
		setDiceMoves(dice);
	}
	
	public int getDiceMoves() {
		
		return diceMoves;
	}
	
	public void setDiceMoves(int dice) {
		this.diceMoves = dice;
	}
}
