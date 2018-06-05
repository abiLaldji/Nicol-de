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
	
	public static boolean up = false;
	public static boolean down = false;
	public static boolean right = false;
	public static boolean left = false;

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

		boardFrame.addPawn(model.getMonster());

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
		
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			right = true;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			left = true;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			 up = true;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			down = true;
			break;
		case KeyEvent.VK_SPACE:
			userOrder = UserOrder.FIRE;
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
			if(right == true && left == false && up == false && down == false) {
				this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
				}
			if(left == true && right == false && up == false && down == false) {
				this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
				}
			if(up == true && down == false && right == false && left == false) {
				this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
				}
			if(down == true && right == false && left == false && up == false) {
				this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
				}
			if(right == true && down == true && left == false && up == false ) {
				userOrder = UserOrder.DOWNRIGHT;
				this.getOrderPerformer().orderPerform(userOrder);
				}
			if(left == true && down == true && right == false && up == false) {
				userOrder = UserOrder.DOWNLEFT;
				this.getOrderPerformer().orderPerform(userOrder);
				}
			if(right == true && up == true && left == false && down == false) {
				userOrder = UserOrder.UPRIGHT;
				this.getOrderPerformer().orderPerform(userOrder);
				}
			if(left == true && up == true && right == false && down == false) {
				userOrder = UserOrder.UPLEFT;
				this.getOrderPerformer().orderPerform(userOrder);
				}
			
		}catch (IOException e) {

			e.printStackTrace();
		}
			
	}

	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
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
	
	public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            up = false;
            
        }

        if (key == KeyEvent.VK_RIGHT) {
        	right= false;
            
        }

        if (key == KeyEvent.VK_DOWN) {
        	down= false;
           
        }

        if (key == KeyEvent.VK_LEFT) {
        	left= false;
            
        }
    }

}
