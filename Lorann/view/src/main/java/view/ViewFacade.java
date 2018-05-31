package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import showboard.BoardFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {

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
        init();
    	System.out.println("view");
    }

    public void init(){
    	BoardFrame boardFrame = new BoardFrame("Lorann", false);
        boardFrame.setSize(new Dimension(sizeFrameWidth, sizeFrameHeight));
        boardFrame.setDimension(new Dimension(width, height));
        boardFrame.setDisplayFrame(gameFrame);
        boardFrame.setHeightLooped(true);
        boardFrame.setLocationRelativeTo(null);
        frameAddSquare(boardFrame);
    }
    
    public final void frameAddSquare(final BoardFrame frame) {
    	
    	for (int x = 0; x < width; x +=1) {
    		for (int y = 0; y < height; y +=1) {
    			frame.addSquare(bone, x, y);
    	    	frame.setVisible(true);
    		}
    	}
    }
}
