package playerCommunication;

import controllers.InitialControl;
import controllers.LoginControl;
//import controllers.CreateAccountControl;
//import controllers.JoinGameControl;
//import controllers.NewGameControl;
//import controllers.WaitingRoomControl;
//import controllers.InitialGameControl;
//import controllers.GameControl;

public class BoardClient {

	private InitialControl ic;
	private LoginControl lc;
	//private CreateAccountControl cac;
	//private JoinGameControl jgc;
	//private NewGameControl ngc;
	//private WaitingRoomControl wrc;
	//private InitialGameControl igc;
	//private GameControl gc;
	
	// Constructor
	public BoardClient()
	{
		super("localhost", 8300);
	}
	
	// Setters for GUI controllers.
	public void setInitialControl(InitialControl ic) 
	{
		this.ic = ic;
	}	
  
    public void setLoginControl(LoginControl lc) 
    {

	  this.lc = lc;
	}

	/*public void setCreateAccountControl(CreateAccountControl cac) 
	 * {
		this.cac = cac;
	}*/
    
    /*public void setJoinGameControl(JoinGameControl jgc) 
	 * {
		this.jgc = jgc;
	}*/
    
    /*public void setNewGameControl(NewGameControl ngc) 
	 * {
		this.ngc = ngc;
	}*/
    
    /*public void setWaitingRoomControl(WaitingRoomControl wrc) 
	 * {
		this.wrc = wrc;
	}*/
    
    /*public void setInitialGameControl(InitialGameControl igc) 
	 * {
		this.igc = igc;
	}*/
    
    /*public void setGameControl(GameControl gc) 
	 * {
		this.gc = gc;
	}*/
    
    // Method that handles messages from server.
    public void handleMessageFromServer(Object arg0)
    {
      if (arg0 instanceof String)
      {
        String message = (String)arg0;
        
        if (message.equals("LoginSuccessful"))
        {
          LoginControl.loginSuccess();
        }
        else if (message.equals("CreateAccountSuccessful"))
        {
          CreateAccountControl.createAccountSuccess();
        }
        else if (message.equals("JoinGameSuccessful"))
        {
          JoinGameControl.joinGameSuccess();
        }
        else if (message.equals("NewGameSuccessful"))
        {
          NewGameControl.newGameSuccess();
        }
      }
      else if (arg0 instanceof Error)
      {
        Error error = (Error)arg0;
        
        if (error.getType().equals("Login"))
        {
          LoginControl.displayError(error.getMessage());
        }
        else if (error.getType().equals("CreateAccount"))
        {
          CreateAccountControl.displayError(error.getMessage());
        }
        else if (error.getType().equals("JoinGame"))
        {
          JoinGameControl.displayError(error.getMessage());
        }
        else if (error.getType().equals("NewGame"))
        {
          NewGameControl.displayError(error.getMessage());
        }
      }
    }
}
