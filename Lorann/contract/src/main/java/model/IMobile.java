package model;

import showboard.IPawn;

public interface IMobile extends IPawn, IElement {

	public void moveUp();

	public void moveDown();

	public void moveLeft();

	public void moveRight();

	public void moveUpRight();

	public void moveUpLeft();
	
	public void moveDownRight();
	
	public void moveDownLeft();

	public boolean isAlive();

	public void doNothing();
	
	public int getX();
	
	public int getY();
}
