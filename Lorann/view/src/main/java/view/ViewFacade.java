package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.SwingUtilities;

import model.IMap;
import model.element.mobile.IMobile;
import showboard.BoardFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable {

	private static final int width = 20;
	
	private static final int height = 12;
		
	private static final int sizeFrameWidth = 1280;
	
	private static final int sizeFrameHeight = 768;
	
	private static final Rectangle gameFrame = new Rectangle(0 ,0 ,sizeFrameWidth ,sizeFrameHeight);
	
	private Obstacle bone = new Obstacle("images/bone.png");
	
	private IMap map;
	
	private IMobile lorann;
			
	/**
     * Instantiates a new view facade.
	 * @throws IOException 
     */
    public ViewFacade(final IMap map, final IMobile lorann) throws IOException {
        super();
        run();
    	System.out.println("view");
    	this.setMap(map);
    	this.setLorann(lorann);
    	this.getLorann().getSprite().loadImage();
    	SwingUtilities.invokeLater(this);
    	   
    }

    public void run(){
    	final BoardFrame boardFrame = new BoardFrame("Lorann Game");
    	boardFrame.setDimension(new Dimension(height, width));
    	boardFrame.setDisplayFrame(gameFrame);
    	boardFrame.setSize(sizeFrameHeight, sizeFrameWidth);
    	boardFrame.setHeightLooped(true);
    	boardFrame.setFocusable(true);
    	boardFrame.setFocusTraversalKeysEnabled(false);

    	for (int x = 0; x < width; x++) {
    	    for (int y = 0; y < height; y++) {
    	        boardFrame.addSquare(bone, x, y);
    	    }
    	}
    	
    	boardFrame.addPawn(this.getLorann());

    	//this.getRoad().getObservable().addObserver(boardFrame.getObserver());
    	//this.followMyVehicle();
    }
    
    private IMobile getLorann() {
        return this.lorann;
    }

  
    private void setLorann(final IMobile lorann) {
        this.lorann = lorann;
    }
    
    private IMap getMap() {
        return this.map;
    }

    private void setMap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
            }
        }
    }
}
