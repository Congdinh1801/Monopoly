package clientGUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuyPropertiesPanel {

	  private JLabel priceLabel;
	  private JLabel errorLabel;
	  private JButton buyBttn;
	  
	  // Setter for price label
	  public void setPrice(String price)
	  {
		  priceLabel.setText(price);
	  }
	  // Setter for the error text.
	  public void setError(String error)
	  {
	    errorLabel.setText(error);
	  }
	  
	  public BuyPropertiesPanel(CreateAccountControl cac)
	  {
	    //controller and set it in the chat client.

	    
	    // Create a panel for the labels at the top of the GUI.
	    JPanel labelPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	    errorLabel = new JLabel("", JLabel.CENTER);
	    errorLabel.setForeground(Color.RED);
	    priceLabel = new JLabel("", JLabel.CENTER);
	    labelPanel.add(errorLabel);
	    labelPanel.add(priceLabel);
	    
	    // Create a panel the button.
	    JPanel buttonPanel = new JPanel();
	    buyBttn = new JButton("Buy");
	    //buyBttn.addActionListener();
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(cac);    
	    buttonPanel.add(buyBttn);
	    buttonPanel.add(cancelButton);

	    // Arrange the three panels in a grid.
	    JPanel grid = new JPanel(new GridLayout(2, 1, 0, 10));
	    grid.add(labelPanel);
	    grid.add(buttonPanel);
	    //this.add(grid);
	  }
}
