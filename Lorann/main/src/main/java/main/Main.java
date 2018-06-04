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

	public static void main(final String[] args) throws InterruptedException, IOException {
		final ModelFacade model = new ModelFacade();
		final ViewFacade view = new ViewFacade(model);
		final IController controller = new ControllerFacade(view, model);
		view.setOrderPerformer(controller.getOrderPeformer());

		controller.play();
	}

}
