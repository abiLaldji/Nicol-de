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
    	BoardFrame board = new BoardFrame("Lorann", false);

    }
}

