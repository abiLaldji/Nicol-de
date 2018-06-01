package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class ExampleDAO extends AbstractDAO {


	private String[][] emplacement;
 
    private static String sql  = "{call print_decor}";

public void semer() {
		
	
		
		try {
			Connection cnx = LorannBDDConnector.connecterDB();			
			CallableStatement  cs;
			ResultSet rst;
			
			
			cs = cnx.prepareCall(sql);
	        if (cs.execute()) {
	            rst = cs.getResultSet();
	            
	            while(rst.next()) {
	            	int levelNumber = 0;
	            	int levelNumberBdd = rst.getInt("level_number");
	            	String type = rst.getString("type");
	    			int x = rst.getInt("x");
	    			int y = rst.getInt("y");
	    			
	    			if(levelNumber == levelNumberBdd) {
		    			switch(type) {
		    			case "HWall" :
		    				this.emplacement[x][y] = "_"; 
		    				break;
		    			case "VWall" :
		    				this.emplacement[x][y] = "|"; 
		    				break;
		    			case "CWall" :
		    				this.emplacement[x][y] = "o"; 
		    				break;
		    			case "Lorann" :
		    				this.emplacement[x][y] = "L"; 
		    				break;
		    			case "Door" :
		    				this.emplacement[x][y] = "D"; 
		    				break;
		    			case "Bubble" :
		    				this.emplacement[x][y] = "B"; 
		    				break;
		    			case "Ennemi" :
		    				this.emplacement[x][y] = "E"; 
		    				break;
		    			}
		            }
	            }
	            rst.close();
	        }
			
		
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
    
    
    
    
    
    
}
