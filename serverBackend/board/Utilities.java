package serverBackend.board;

import serverBackend.player.Player;

public class Utilities extends Asset{
	private int rentPrice;
	
	public Utilities(int position) {
		super(position);
	}
	public void setRentPrice(int numofUtilites) {
		if(numofUtilites == 1)	{
			rentPrice = 100;
		}
		if(numofUtilites == 2)	{
			rentPrice = 300;
		}
	}
	public int getRentPrice(int diceSum) {
		return rentPrice * diceSum;
	}
	public void payRent(Player player, int diceSum) {
		int currentMoney = player.getMoney() - getRentPrice(diceSum);
		player.setMoney(currentMoney);
		getOwner().setMoney(getOwner().getMoney() + getRentPrice());
	}

}
