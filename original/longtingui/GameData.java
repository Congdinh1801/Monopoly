package longtingui;
import java.io.Serializable;

public class GameData implements Serializable 
{
  // Private data fields for the username and password.
  private boolean diceRoll;
  
  // Getters for the username and password.
  public boolean getdiceRoll()
  {
    return diceRoll;
  }
 
  public void setdiceRoll(boolean diceRoll)
  {
    this.diceRoll = diceRoll;
  }
  
  // Constructor that initializes the username and password.
  public GameData(boolean diceRoll)
  {
	  setdiceRoll(diceRoll);
  }
  public GameData()
  {
	  diceRoll = true;
  }
}
