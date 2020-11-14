package clientGUI;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Database {
	private Connection conn;
	private ResultSet rs;
	// private ResultSetMetaData rmd;
	private Statement stmt;
	private String url;
	private String user;
	private String pass;
	// Private data field for storing a HashMap of usernames and passwords.
	private HashMap<String, String> database;

	public Database() {
		database = new HashMap<String, String>();
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("original/clientGUI/db.properties"); // "./original/clientGUI/db.properties" or "original/clientGUI/db.properties"
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		;
		try {
			prop.load(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		pass = prop.getProperty("password");
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// read the database
		try {
			String query = "select username, aes_decrypt(password,'key') from user";
			readDatabase(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method for verifying a username and password.
	public boolean verifyAccount(String username, String password) {
		if (database.get(username) == null)
			return false;

		// Check the username and password.
		if (database.get(username).equals(password))
			return true;
		else
			return false;
	}

	// Method for creating a new account.
	public boolean createNewAccount(String username, String password) {
		// Stop if this account already exists.
		if (database.get(username) != null)
			return false;
		// Write to the database
		String dml = "Insert Into user values('" + username + "', AES_ENCRYPT('" + password + "', 'key'))";   //Insert Into user values('" + username + "', AES_ENCRYPT('" + password + "', 'key'))
		try {
			executeDML(dml);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// Add the new account to the hashmap
		database.put(username, password);

		return true;
	}

	public void readDatabase(String query) throws SQLException {
		// Create a statement
		stmt = conn.createStatement();
		// Execute a query
		rs = stmt.executeQuery(query);
		// place them in the hashmap
		while (rs.next()) {
			String username = rs.getString(1);// 1 is the column 1,
			String password = rs.getString(2);// 2 is the column 2
			database.put(username, password);
		}

	}

	public void executeDML(String dml) throws SQLException {
		// Add your code here
		// 1. Use the Conn object to create a Statement object
		stmt = conn.createStatement();
		// 2. Run dml on the execute method of Statement
		stmt.execute(dml);
		System.out.println("SUCCESS");
	}

}
