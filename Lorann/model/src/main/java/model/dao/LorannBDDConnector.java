package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>The Class BoulderDashBDDConnector.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class LorannBDDConnector {

public static Connection connecterDB() {
		
		try {
			
			String url = "jdbc:mysql://localhost/testdecor?serverTimezone=Europe/Paris&autoReconnect=true&useSSL=false";
			String user ="root";
			String password ="";
			Connection cnx = DriverManager.getConnection(url, user, password);
			
			return cnx;
			
		} catch (Exception e) {
			e.printStackTrace();
		return null;
		}
		
		
		
	}
}


