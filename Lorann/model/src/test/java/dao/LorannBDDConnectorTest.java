package model.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LorannBDDConnectorTest {
	String url = "jdbc:mysql://localhost/testdecor?serverTimezone=Europe/Paris&autoReconnect=true&useSSL=false";
	String user ="root";
	String password ="";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConnecterDB() {
		try {
			Connection cnx = DriverManager.getConnection(url, user, password);
			assertEquals(true, cnx.isValid(1000));
		} catch (Exception e) {
			fail("nique ta mere bdd de merde");
		}
		
		
	}

}
