package model.element.mobile;

public interface IMobile {

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
}
