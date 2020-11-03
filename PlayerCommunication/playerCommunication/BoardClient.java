package playerCommunication;

//import controllers.CreateAccountControl;
import controllers.InitialControl;
import controllers.LoginControl;

public class BoardClient {

	private InitialControl ic;
	private LoginControl lc;
	//private CreateAccountControl cac;
	
	
	//Set Controllers
	public void setIc(InitialControl ic) {
		this.ic = ic;
	}	
  
    public void setLoginControl(LoginControl lc) {

	  this.lc = lc;
	}

	/*public void setCac(CreateAccountControl cac) {
		this.cac = cac;
	}*/
}
