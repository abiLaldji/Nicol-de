package main;

import java.io.IOException;

import controller.ControllerFacade;
import controller.IController;
import model.ModelFacade;
import view.ViewFacade;


public abstract class Main {

	public static void main(final String[] args) throws InterruptedException, IOException {
		try {
			final ModelFacade model = new ModelFacade();
			final ViewFacade view = new ViewFacade(model);
			final IController controller = new ControllerFacade(view, model);
			view.setOrderPerformer(controller.getOrderPerformer());

			controller.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
