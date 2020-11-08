package playerCommunication;

import ocsf.client.AbstractClient;
import controllers.CreateAccountControl;
import controllers.InitialControl;
import controllers.LoginControl;
//import controllers.CreateAccountControl;
//import controllers.JoinGameControl;
//import controllers.NewGameControl;
//import controllers.WaitingRoomControl;
//import controllers.InitialGameControl;
//import controllers.GameControl;

public class BoardClient extends AbstractClient{

	private InitialControl initialControl;
	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
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
		this.initialControl = ic;
	}	
  
    public void setLoginControl(LoginControl lc) 
    {

	  this.loginControl = lc;
	}

	public void setCreateAccountControl(CreateAccountControl cac) 
	{
		this.createAccountControl = cac;
	}
    
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
          loginControl.loginSuccess();
        }
        else if (message.equals("CreateAccountSuccessful"))
        {
          createAccountControl.createAccountSuccess();
        }
        else if (message.equals("JoinGameSuccessful"))
        {
          //JoinGameControl.joinGameSuccess();
        }
        else if (message.equals("NewGameSuccessful"))
        {
          //NewGameControl.newGameSuccess();
        }
      }
      else if (arg0 instanceof Error)
      {
        /*Error error = (Error)arg0;
        
        if (error.getType().equals("Login"))
        {
          loginControl.displayError(error.getMessage());
        }
        else if (error.getType().equals("CreateAccount"))
        {
          createAccountControl.displayError(error.getMessage());
        }
        else if (error.getType().equals("JoinGame"))
        {
          JoinGameControl.displayError(error.getMessage());
        }
        else if (error.getType().equals("NewGame"))
        {
          NewGameControl.displayError(error.getMessage());
        }*/
      }
    }
}
