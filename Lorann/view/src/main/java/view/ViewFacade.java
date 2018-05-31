package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observer;

import showboard.BoardFrame;
import showboard.IPawn;
import showboard.ISquare;

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
	
	private static final Rectangle lorannGame = new Rectangle(0 ,0 ,width ,height);
	
	private final Obstacle bone = new Obstacle("images/bone.png");
	
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
        init();
    	System.out.println("view");
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    /*@Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }*/
    
    public void init(){
    	BoardFrame boardFrame = new BoardFrame("Lorann", false);
        boardFrame.setSize(sizeFrameWidth, sizeFrameHeight);
    	boardFrame.setDimension(new Dimension(width, height));
        boardFrame.setDisplayFrame(lorannGame);
        boardFrame.setLocationRelativeTo(null);
        frameConfigure(boardFrame);
    }
    
    public final void frameConfigure(final BoardFrame frame) {
    
      frame.addSquare(bone, 1, 1);
        
      frame.setVisible(true);
   
    }
}

