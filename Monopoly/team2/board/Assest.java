package team2.board;

public abstract class Assest extends Square {
	private int purchasePrice;
	private int rentPrice;
	final private COLOR color;
	private Participant owner;
	
	public Assest(int position, COLOR color) {
		super(position);
		this.color = color;
	}
	
	public Assest(int position) {
		this(position, null);
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Participant getOwner() {
		return owner;
	}

	public void setOwner(Participant owner) {
		this.owner = owner;
	}
	
	public COLOR getColor() {
		return color;
	}
}
