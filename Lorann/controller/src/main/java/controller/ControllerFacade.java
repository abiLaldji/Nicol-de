package controller;

import java.io.IOException;

import model.IModel;
import view.IView;

public class ControllerFacade implements IController, IOrderPerformer {

	private IView view;

	private IModel model;

	private Movement mov = new Movement(this);

	private UserOrder stackOrder;

	public ControllerFacade(final IView view, final IModel model) {
		setModel(model);
		setView(view);
		this.clearStackOrder();
		System.out.println("controller");
	}

	boolean spell = true;

	/**
	 * Main loop of the game, does different action depending on UserOrder (enum).
	 * Check if Lorann hits a monster.
	 */

	public void play() throws InterruptedException, IOException {
		while (this.getModel().getLorann().isAlive()) {
			Thread.sleep(200);
			if (spell == true) {
				this.getModel().initSpell(-1, 0);
				// this.getModel().getSpell().move();
				spell = false;
			}
			this.getModel().getMonster().move();

			this.getModel().getMonster2().move();
			this.getModel().getMonster3().move();
			this.getModel().getMonster4().move();
			switch (this.getStackOrder()) {
			case RIGHT:
				if ((this.mov.hitMonster(1, 0) == true)) {

					hitMonstre();
				}
				this.getModel().getLorann().moveRight();
				break;
			case LEFT:
				if (this.mov.hitMonster(-1, 0) == true) {

					hitMonstre();
				}
				this.getModel().getLorann().moveLeft();
				break;
			case UP:
				if (this.mov.hitMonster(0, -1) == true) {
					hitMonstre();
				}
				this.getModel().getLorann().moveUp();
				break;
			case DOWN:
				if (this.mov.hitMonster(0, 1) == true) {
					hitMonstre();
				}
				this.getModel().getLorann().moveDown();
				break;
			case UPLEFT:

				if ((this.mov.hitMonster(-1, -1) == true)) {

					hitMonstre();
				}
				this.getModel().getLorann().moveUpLeft();
				break;
			case UPRIGHT:

				if (this.mov.hitMonster(1, -1) == true) {

					hitMonstre();
				}
				this.getModel().getLorann().moveUpRight();
				break;
			case DOWNLEFT:

				if (this.mov.hitMonster(-1, 1) == true) {

					hitMonstre();
				}
				this.getModel().getLorann().moveDownLeft();
				break;
			case DOWNRIGHT:
				if (this.mov.hitMonster(1, 1) == true) {

					hitMonstre();
				}
				this.getModel().getLorann().moveDownRight();
				break;
			case FIRE:
				this.getModel().initSpell(-1, 0);
				this.getModel().getSpell().move();
				break;
			default:
				// this.getModel().getLorann().doNothing();
				break;
			}
			this.clearStackOrder();
		}
	}

	/**
	 * set StackOrder on User Order's
	 */

	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	private IView getView() {
		return this.view;
	}

	private void setView(final IView view) {
		this.view = view;
	}

	public IModel getModel() {
		return this.model;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	protected UserOrder getStackOrder() {
		return this.stackOrder;
	}

	protected void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	protected void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	/**
	 * When Lorann hit a monster, end of the game. Death message.
	 */

	private void hitMonstre() {
		this.getModel().getLorann().setAlive(false);
		this.getView().loosingScreen();
	}

}
