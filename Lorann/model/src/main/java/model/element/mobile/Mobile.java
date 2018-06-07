package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Collision;
import model.IMap;
import model.IMobile;
import model.element.Element;
import model.element.Sprite;
import showboard.IBoard;

public abstract class Mobile extends Element implements IMobile {

	private boolean alive = true;
	private Point position;
	private IMap map;
	private IBoard board;

	private int score = 0;

	Mobile(final Sprite sprite, final IMap map, final Collision collision) {
		super(sprite, collision);
		this.setMap(map);
		this.position = new Point();
	}

	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Collision collision) {
		this(sprite, map, collision);
		this.setXY(x, y);
	}

	/**
	 * Main move method. Check for the square the pawn want to go in. If it's free,
	 * the pawn move dependending on the moveX and moveY parameters. Execute action
	 * of collecting Purse, die, and open the door with the energy ball.
	 */

	public void move(int moveX, int moveY) throws IOException {
		if (this.getY() != 0) {
			switch (this.getMap().getOnTheMapXY(this.getX() + moveX, this.getY() + moveY).getCollision()) {
			case FREE:
				this.setXY(this.getX() + moveX, this.getY() + moveY);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				System.out.println("collect");
				this.collect(this.getX() + moveX, this.getY() + moveY);
				this.setXY(this.getX() + moveX, this.getY() + moveY);
				this.setHasMoved();
				break;
			case KILL:
				die();
				break;
			case WIN:
				this.setXY(this.getX() + moveX, this.getY() + moveY);
				this.setHasMoved();
				win();
				break;
			case OPENDOOR:
				openTheDoor(this.getX() + moveX, this.getY() + moveY);
				this.setXY(this.getX() + moveX, this.getY() + moveY);
				this.setHasMoved();
				break;
			default:
				break;
			}
		}
	}

	public void doNothing() {
		this.setHasMoved();
	}

	/**
	 * Tell the map that something has changed so that the map can notify the
	 * showboard
	 */

	protected void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	/**
	 * Call wining message
	 */

	public void win() {
		JOptionPane.showMessageDialog(null, "YOU WIN");
		System.exit(0);
	}
	
	protected void die() throws IOException {
		this.setAlive(false);
		JOptionPane.showMessageDialog(null, "YOU DIED");
		System.exit(0);
	}

	/**
	 * Method called when Lorann hit the Purse. When it does, the Purse square is
	 * replace with an empty square with FREE collision
	 */

	public void collect(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "empty.png"));
		this.getMap().getOnTheMapXY(x, y).setCollision(Collision.FREE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
		score = score + 100;
		System.out.print("Your score : ");
		System.out.println(score);
	}

	/**
	 * Method called when Lorann hit the energy ball. Look for every square in the
	 * map that has ']' console image, when it has found it, it's replaced by an
	 * open door with WIN collision
	 */

	private void openTheDoor(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "empty.png"));
		this.getMap().getOnTheMapXY(x, y).setCollision(Collision.FREE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();

		for (int a = 0; a < this.getMap().getWidth(); a++) {
			for (int b = 0; b < this.getMap().getHeight(); b++) {

				if (this.getMap().getOnTheMapXY(a, b).getSprite().getConsoleImage() == ']') {

					this.getMap().getOnTheMapXY(a, b).setSprite(new Sprite('[', "gate_open.png"));
					this.getMap().getOnTheMapXY(a, b).getSprite().loadImage();
					this.getMap().getOnTheMapXY(a, b).setCollision(Collision.WIN);
				}
			}
		}
	}

	public void fire() throws IOException {

	}

	public final void setXY(final int x, final int y) {
		this.getPosition().x = x;
		this.getPosition().y = y;
	}

	public final int getX() {
		return this.getPosition().x;
	}

	public final int getY() {
		return this.getPosition().y;
	}

	private void setMap(final IMap map) {
		this.map = map;
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	

	public Point getPosition() {
		return this.position;
	}

	public void setPosition(final Point position) {
		this.position = position;
	}

	public IMap getMap() {
		return this.map;
	}

	public IBoard getBoard() {
		return board;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
