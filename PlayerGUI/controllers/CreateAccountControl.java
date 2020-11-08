package controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

import data.CreateAccountData;
import panels.CreateAccountPanel;
import playerCommunication.BoardClient;


public class CreateAccountControl implements ActionListener{

	// Private data fields for the container and chat client.
	private JPanel container;
	private BoardClient client;
	//private User user;
	private String username;
	private String password;
	private String password2;
	  
	
	public CreateAccountControl(JPanel container, BoardClient client) {
		this.container = container;
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// Get the name of the button clicked.
	    String command = ae.getActionCommand();

	    // The Cancel button takes the user back to the initial panel.
	    if (command == "Cancel")
	    {
	      CardLayout cardLayout = (CardLayout)container.getLayout();
	      cardLayout.show(container, "1");
	    }
	    
	    //The Submit button submits the login information to the server.
	    else if (command == "Submit")
	    {
	      // Get the username and password the user entered.
	      CreateAccountPanel createAccountPanel = (CreateAccountPanel) container.getComponent(2);
	      username = createAccountPanel.getUsername();
	      password = createAccountPanel.getPassword();
	      password2 = createAccountPanel.getPassword2(); 
	    
	      // Check the validity of the information locally first.
	      if (username.equals("") || password.equals("") || password2.equals(""))
	      {
			   System.out.println("Error. All fields must be completed");
			   createAccountError("All fields must be completed.");	    	  
	      }
	      if (password2.length() < 6 || password.length() < 6) {
	    	  
	    	  System.out.println("Error. Password must be atleast 6 characters.");
			  createAccountError("Error. Password must be atleast 6 characters.");	    	  
	      }
	      if (!password.contentEquals(password2)) {
	    	  
	    	  System.out.println("Error. Passwords do not match.");
			  createAccountError("Error. Passwords do not match.");	    	  
	      }
		  else {
		      CreateAccountData data = new CreateAccountData(username, password);
		      //Submit the information to the server.
		      try {
				client.sendToServer(data);
		      } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		      }
	      }
	    }
	}
	
	// Method that displays a message in the error - could be invoked by ChatClient or by this class (see above)
	public void createAccountError(String error) {
	    
		CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
		createAccountPanel.setError(error);
	}
	
	public void createAccountSuccess() {
	    
		//user = new User(username);
		CardLayout cardLayout = (CardLayout)container.getLayout();
	    cardLayout.show(container, "2");
	  }
	
}