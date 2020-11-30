package serverBackend.board;

import serverBackend.player.Player;

public class Tax extends Square{
	private int tax;
	
	public Tax(int position) {
		super(position);
		setTax(0);
	}

	public void setTax(int tax) {
		this.tax = tax;
	}
	
	public int getTax() {
		return tax;
	}
	
	public void action(Player player) {
		int currentMoney = player.getMoney() - tax;
		player.setMoney(currentMoney);
	}
}
