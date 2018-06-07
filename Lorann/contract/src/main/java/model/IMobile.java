package model;

import java.io.IOException;

import showboard.IPawn;

public interface IMobile extends IPawn, IElement {

	public void moveUp() throws IOException;

	public void moveDown() throws IOException;

	public void moveLeft() throws IOException;

	public void moveRight() throws IOException;

	public void moveUpRight() throws IOException;

	public void moveUpLeft() throws IOException;
	
	public void moveDownRight() throws IOException;
	
	public void moveDownLeft() throws IOException;

	public boolean isAlive();

	public void doNothing();
	
	public int getX();
	
	public int getY();
	
	public void fire() throws IOException;

	public void move(int i, int j) throws IOException;
	
	public void move() throws IOException;

	public void setXY(int i, int j);

	void collect(int i, int j) throws IOException;

	public void setAlive(boolean alive);
}
