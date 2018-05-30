package view;

import java.awt.EventQueue;

import showboard.BoardFrame;

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
        
        EventQueue.invokeLater(() -> {
        	BoardFrame board = new BoardFrame();
            board.setVisible(true);
        });
        
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
    
}

