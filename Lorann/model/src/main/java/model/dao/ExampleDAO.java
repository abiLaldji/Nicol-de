package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*import decorBDD.Bubble;
import decorBDD.CWall;
import decorBDD.Connexion;
import decorBDD.Door;
import decorBDD.Emplacement;
import decorBDD.Ennemi;
import decorBDD.HWall;
import decorBDD.Lorann;
import decorBDD.VWall;*/
import model.Example;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class ExampleDAO extends AbstractDAO {



 
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
		    				//this.emplacement[x][y] = new Emplacement(new HWall()); 
		    				break;
		    			case "VWall" :
		    				//this.emplacement[x][y] = new Emplacement(new VWall()); 
		    				break;
		    			case "CWall" :
		    				//this.emplacement[x][y] = new Emplacement(new CWall()); 
		    				break;
		    			case "Lorann" :
		    				//this.emplacement[x][y] = new Emplacement(new Lorann()); 
		    				break;
		    			case "Door" :
		    				//this.emplacement[x][y] = new Emplacement(new Door()); 
		    				break;
		    			case "Bubble" :
		    				//this.emplacement[x][y] = new Emplacement(new Bubble()); 
		    				break;
		    			case "Ennemi" :
		    				//this.emplacement[x][y] = new Emplacement(new Ennemi()); 
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
