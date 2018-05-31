package view;

import java.awt.Dimension;
import java.awt.Rectangle;

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
			
	/**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
        run();
    	System.out.println("view");
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
    	boardFrame.addPawn(this.getLorran());

    	//this.getRoad().getObservable().addObserver(boardFrame.getObserver());
    	//this.followMyVehicle();
    }
    
    private IMobile getLorann() {
        return this.Lorann;
    }

  
    private void setMyVehicle(final IMobile myVehicle) {
        this.myVehicle = myVehicle;
    }
}
