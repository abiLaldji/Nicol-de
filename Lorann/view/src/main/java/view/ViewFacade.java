package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import model.IMap;
import model.IMobile;
import model.element.mobile.Monster;
import showboard.BoardFrame;
import showboard.IPawn;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable, KeyListener, IPawn {
	
	private static final int squareSize = 90;
			
	private IMap map;
	
	private IMobile lorann;
	
	private ArrayList<Monster> monster;
	
    private IOrderPerformer  orderPerformer;
			

    public ViewFacade(final IMap map, final IMobile lorann, ArrayList<Monster> monster) throws IOException {
    	System.out.println("view");
    	this.setMap(map);
    	this.setLorann(lorann);
    	this.getLorann().getSprite().loadImage();
    	this.setMonster(monster);
    	for (Monster monster1 : monster) {
        	monster1.getSprite().loadImage();
    	}
    	SwingUtilities.invokeLater(this);
    	   
    }

    public void run(){
    	final BoardFrame boardFrame = new BoardFrame("Lorann Game");
    	boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
    	boardFrame.setDisplayFrame(new Rectangle(0 ,0 , this.getMap().getWidth(), this.getMap().getHeight()));
    	boardFrame.setSize(this.map.getWidth() * squareSize, this.map.getHeight() * squareSize);
    	boardFrame.setHeightLooped(true);
    	boardFrame.setFocusable(true);
    	boardFrame.setFocusTraversalKeysEnabled(false);
    	boardFrame.setLocationRelativeTo(null);
    	boardFrame.addKeyListener(this);

    	for (int x = 0; x < this.getMap().getWidth(); x++) {
    	    for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
    	    }
    	}
    	
    	boardFrame.addPawn(this.getLorann());
    	
    	for (Monster monster1 : monster) {
			boardFrame.addPawn(monster1);
		}
    	
    	boardFrame.setVisible(true);

    	this.getMap().getObservable().addObserver(boardFrame.getObserver());
    	show();
    }
    
    public final void show() {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
            	for(int y = 0; y < this.getMap().getHeight(); y++) {
                if (x == this.getLorann().getX()) {
                    System.out.print(this.getLorann().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
                }
            }
            //y = (y + 1) % this.getMap().getHeight();
            System.out.print("\n");
            }
        
    }
    
    private IMobile getLorann() {
        return this.lorann;
    }

  
    private void setLorann(final IMobile lorann) {
        this.lorann = lorann;
    }
    
    private IMap getMap() {
        return this.map;
    }

    private void setMap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
            	if (this.getMap().getOnTheMapXY(x, y) == null) {
            		this.getMap().setEmptyXY(x, y);
            	}
            	else {
                	this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
            	}
            }
        }
    }
    
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
            	System.out.println("droite");
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            case KeyEvent.VK_UP:
                userOrder = UserOrder.UP;
                break;
            case KeyEvent.VK_DOWN:
                userOrder = UserOrder.DOWN;
                break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }
    
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
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
    
	public ArrayList<Monster> getMonster() {
		return monster;
	}

	public void setMonster(ArrayList<Monster> monster) {
		this.monster = monster;
	}
}
