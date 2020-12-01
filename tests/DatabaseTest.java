package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import database.Database;



public class DatabaseTest {

	private Database db; 	

	
	@Before
	public void setUpTestDatabase() throws Exception //this method tests readDatabase as well
	{
		db = new Database(); 
	}

	@Test
	public void testCreateNewAccount() {	//this method tests executeDML as well
		
		String username = "test";
		String password = "passww";
		db.createNewAccount(username, password);
		fail("Account already exists");
	}

	@Test
	public void testVerifyAccount() {
		String username = "test"; 
		String password = "passww";
		
		boolean actual = db.verifyAccount(username, password);
		
		if(!actual) {
			fail("Account does not exist");
		}
	}
}
