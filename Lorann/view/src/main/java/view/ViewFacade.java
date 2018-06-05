package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import model.IModel;
import showboard.BoardFrame;
import showboard.IPawn;

public class ViewFacade implements IView, Runnable, KeyListener, IPawn {

	private static final int SQUARE_SIZE = 70;
	
	public static int up = 0;
	public static int down = 0;
	public static int right = 0;
	public static int left = 0;

	private IModel model;

	private IOrderPerformer orderPerformer;

	public ViewFacade(IModel model) throws IOException {
		System.out.println("view");
		this.model = model;
		SwingUtilities.invokeLater(this);
	}

	public void run() {
		final BoardFrame boardFrame = new BoardFrame("Lorann Game");
		boardFrame.setDimension(new Dimension(model.getMap().getWidth(), model.getMap().getHeight()));
		boardFrame.setDisplayFrame(new Rectangle(0, 0, model.getMap().getWidth(), model.getMap().getHeight()));
		boardFrame.setSize(model.getMap().getWidth() * SQUARE_SIZE, model.getMap().getHeight() * SQUARE_SIZE);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);
		boardFrame.setLocationRelativeTo(null);
		boardFrame.addKeyListener(this);

		for (int x = 0; x < model.getMap().getWidth(); x++) {
			for (int y = 0; y < model.getMap().getHeight(); y++) {
				boardFrame.addSquare(model.getMap().getOnTheMapXY(x, y), x, y);
			}
		}

		boardFrame.addPawn(model.getLorann());

		boardFrame.addPawn(model.getLorann());

		boardFrame.setVisible(true);

		model.getMap().getObservable().addObserver(boardFrame.getObserver());
		show();
	}

	public final void show() {
		for (int x = 0; x < model.getMap().getWidth(); x++) {
			for (int y = 0; y < model.getMap().getHeight(); y++) {
				if (x == model.getLorann().getX() && y == model.getLorann().getY()) {
					System.out.print(model.getLorann().getSprite().getConsoleImage());
				}
				if (x == model.getMonster().getX() && y == model.getMonster().getY()) {
					System.out.print(model.getMonster().getSprite().getConsoleImage());
				} else {
					System.out.print(model.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
				}
			}
			System.out.print("\n");
		}

	}

	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		up = 0;
		right = 0;
		down = 0;
		left = 0;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			right = 1;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			left = 1;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			 up = 1;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			down = 1;
			break;		
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	public final void keyPressed(final KeyEvent keyEvent) {
		UserOrder userOrder;
		try {
			if((up== 1 && down == 0 && left == 0 && right == 0) || (up== 0 && down == 1 && left == 0 && right == 0) || (up== 0 && down == 0 && left == 1 && right == 0) || (up== 0 && down == 0 && left == 0 && right == 1)) {
				this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
			}
			if(up == 1 && left == 1) {
				userOrder = UserOrder.UPLEFT;
				this.getOrderPerformer().orderPerform(userOrder);
			}
			
			if(up == 1 && right == 1) {
				userOrder = UserOrder.UPRIGHT;
				this.getOrderPerformer().orderPerform(userOrder);
			}
			
			if(down == 1 && right == 1) {
				userOrder = UserOrder.DOWNLEFT;
				this.getOrderPerformer().orderPerform(userOrder);
			}

			if(down == 1 && left == 1) {
				userOrder = UserOrder.DOWNRIGHT;
				this.getOrderPerformer().orderPerform(userOrder);
			}


		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
