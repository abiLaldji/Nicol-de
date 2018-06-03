package main;

import java.io.IOException;

import controller.ControllerFacade;
import controller.IController;
import model.IModel;
import model.ModelFacade;
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
	private static final int startX = 2;

	    /** The Constant startY. */
	private static final int startY = 2;
	
    public static void main(final String[] args) throws InterruptedException, IOException {
    	final IModel model = new ModelFacade(startX, startY);
        final ViewFacade view = new ViewFacade(model.getMap(), model.getLorann());
        final IController controller = new ControllerFacade(view, model);

        controller.start();
    }

}
