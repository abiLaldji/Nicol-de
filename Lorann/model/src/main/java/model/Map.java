package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Observable;

import model.element.Element;
import model.element.nonMobile.NonMobileFactory;;


class Map extends Observable {


	private final int WIDTH = 20;
	private final int HEIGHT = 12;
	private Element[][] onTheMap = new Element[WIDTH][HEIGHT];
 
    private static String sql  = "{call print_decor}";

   


    Map() {
        super();      
    }




    public void semer() {
    		
    	
    		
    		try {
    			Connection cnx = model.dao.LorannBDDConnector.connecterDB();			
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
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('H'), x, y);  
    		    				break;
    		    			case "VWall" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('V'), x, y);  
    		    				break;
    		    			case "CWall" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('C'), x, y);   
    		    				break;
    		    			case "Lorann" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('L'), x, y);  
    		    				break;
    		    			case "Door" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('D'), x, y);  
    		    				break;
    		    			case "Bubble" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('B'), x, y);  
    		    				break;
    		    			case "Monster_1" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('Y'), x, y);  
    		    				break;
    		    			case "Monster_2" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('U'), x, y);   
    		    				break;
    		    			case "Monster_3" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('I'), x, y);  
    		    				break;
    		    			case "Monster_4" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('O'), x, y);    
    		    				break;
    		    			case "Purse" :
    		    				this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('P'), x, y);   
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
        
        
        
    	public final int getWidth() {
    	    return this.WIDTH;
    	}
    	
    	/*private void setWidth(final int width) {
    	    this.WIDTH = width;
    	}*/
    	
    	
    	public final int getHeight() {
    	    return this.HEIGHT;
    	}
    	
    	
    	/*private void setHeight(final int height) {
    	    this.HEIGHT = height;
    	}*/
    	
    	
    	
    	public final Element getOnTheMapXY(final int x, final int y) {
    	    return this.onTheMap[x][y];
    	}
    	
    	
    	private void setOnTheMapXY(final Element element, final int x, final int y) {
    	    this.onTheMap[x][y] = element;
    	}
    	
    	
    	/*public final void setMobileHasChanged() {
    	    this.setChanged();
    	    this.notifyObservers();
    	}
    	
    	public Observable getObservable() {
    	    return this;
    	}*/
    }
