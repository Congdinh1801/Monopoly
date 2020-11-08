package controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import playerCommunication.BoardClient;

public class LoginControl implements ActionListener
{
  // Private data fields for the container and chat client.
  private JPanel container;
  private BoardClient client;
  //private User user;
  private String username;
  private String password;

  
  // Constructor for the login controller.
  public LoginControl(JPanel container, BoardClient client)
  {
    this.container = container;
    
    //allows communication with server
    this.client = client;
  }
  
  // Handle button clicks.
  public void actionPerformed(ActionEvent ae)
  {
    // Get the name of the button clicked.
    String command = ae.getActionCommand();

    // The Cancel button takes the user back to the initial panel.
    if (command == "Cancel")
    {
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "1");
    }

    // The Submit button submits the login information to the server.
    else if (command == "Submit")
    {
      // Get the username and password the user entered.
      /*LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
      username = loginPanel.getUsername();
      password = loginPanel.getPassword();
      LoginData data = new LoginData(username, password);*/
      
      // if username/password blank
      /*if (data.getUsername().equals("") || data.getPassword().equals(""))
      {
        displayError("You must enter a username and password.");
      }

      // Submit the login information to the server.
      try {
		client.sendToServer(data);

      } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

      }*/
    }
  }

  // After the login is successful, set the User object and display the contacts screen. - this method would be invoked by 
  //the ChatClient
  public void loginSuccess()
  {
	  //user = new User(username);
	  CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "4");

  }

  // Method that displays a message in the error - could be invoked by ChatClient or by this class (see above)
  public void displayError(String error)
  {
    //LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
    //loginPanel.setError(error);
    
  }
}
