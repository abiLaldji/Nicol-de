package controller;

import java.awt.Point;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.IModel;
import view.IView;

public class ControllerFacade implements IController, IOrderPerformer {

	private IView view;

	private IModel model;

	private UserOrder stackOrder;

	public ControllerFacade(final IView view, final IModel model) {
		setModel(model);
		setView(view);
		this.clearStackOrder();
		System.out.println("controller");
	}

	public void play() throws InterruptedException, IOException {
		// Thread.sleep(100);
		while (this.getModel().getLorann().isAlive()) {
			switch (this.getStackOrder()) {
			case RIGHT:
				if ((model.getMonster().getPosition()
						.equals(new Point(model.getLorann().getX() + 1, model.getLorann().getY())))) {
					hitMonstre();
				}
				this.getModel().getLorann().moveRight();
				break;
			case LEFT:
				if ((model.getMonster().getPosition()
						.equals(new Point(model.getLorann().getX() - 1, model.getLorann().getY())))) {
					hitMonstre();
				}
				this.getModel().getLorann().moveLeft();
				break;
			case UP:
				if ((model.getMonster().getPosition()
						.equals(new Point(model.getLorann().getX(), model.getLorann().getY() - 1)))) {
					hitMonstre();
				}
				this.getModel().getLorann().moveUp();
				break;
			case DOWN:
				if ((model.getMonster().getPosition()
						.equals(new Point(model.getLorann().getX(), model.getLorann().getY() + 1)))) {
					hitMonstre();
				}
				this.getModel().getLorann().moveDown();
				break;
			case UPLEFT:
				this.getModel().getLorann().moveUpLeft();
				break;
			case UPRIGHT:
				this.getModel().getLorann().moveUpRight();
				break;
			case DOWNLEFT:
				this.getModel().getLorann().moveDownLeft();
				break;
			case DOWNRIGHT:
				this.getModel().getLorann().moveDownRight();
				break;
			case FIRE:
				this.getModel().getLorann().fire();
				break;
			default:
				// this.getModel().getLorann().doNothing();
				break;
			}
			this.clearStackOrder();

		}
	}

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

	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	private void hitMonstre() {
		this.getModel().getLorann().setAlive(false);
		JOptionPane.showMessageDialog(null, "YOU DIED");
		System.exit(0);
	}

}
