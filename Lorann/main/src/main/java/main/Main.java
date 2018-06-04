package main;

import java.io.IOException;

import controller.ControllerFacade;
import controller.IController;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

   
	private static final int startX = 1;

	private static final int startY = 1;
	
	private static final int startXM =15;

	private static final int startYM = 2;
	
	
    public static void main(final String[] args) throws InterruptedException, IOException {
    	final ModelFacade model = new ModelFacade(startX, startY, startXM, startYM);
        final ViewFacade view = new ViewFacade(model.getMap(), model.getLorann(), model.getMonster());
        final IController controller = new ControllerFacade(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }

}
