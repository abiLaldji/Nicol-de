package main;

import java.sql.SQLException;

import controller.ControllerFacade;
import model.IModel;
import model.ModelFacade;
import view.IView;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
	   private static final int startX = 5;

	    /** The Constant startY. */
	    private static final int startY = 0;
	
	
    public static void main(final String[] args) {
    	final ModelFacade model = new ModelFacade(startX, startY);
        final IView view = new ViewFacade(model.getMap(), model.getLorann());
        final ControllerFacade controller = new ControllerFacade(view, model);

        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
