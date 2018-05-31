
Skip to content

    Pull requests
    Issues
    Marketplace
    Explore

    @abiLaldji

0
0

    0

abiLaldji/Nicol-de
Code
Issues 0
Pull requests 0
Projects 0
Wiki
Insights
Settings
Nicol-de/Lorann/view/src/main/java/view/ViewFacade.java
c56c967 5 minutes ago
abi ?
66 lines (50 sloc) 1.66 KB
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
        boardFrame.setSize(new Dimension(sizeFrameWidth, sizeFrameHeight));
        boardFrame.setDimension(new Dimension(width, height));
        boardFrame.setDisplayFrame(gameFrame);
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
