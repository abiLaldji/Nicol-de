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

	private IMobile spell;

	private int score;

	Mobile(final Sprite sprite, final IMap map, final Collision collision) {
		super(sprite, collision);
		this.setMap(map);
		this.position = new Point();
	}

	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Collision collision) {
		this(sprite, map, collision);
		this.setX(x);
		this.setY(y);
	}

	public void moveUp() throws IOException {
		if (this.getY() != 0) {
			switch (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getCollision()) {
			case PENETRABLE:
				this.setY(this.getY() - 1);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				this.collect(this.getX(), this.getY() - 1);
				this.setY(this.getY() - 1);
				this.setHasMoved();
				break;
			case KILL:
				die();
				break;
			case WIN:
				win();
				break;
			case OPENDOOR:
				openTheDoor(this.getX(), this.getY() - 1);
				break;
			default:
				break;
			}
		}
	}

	public void moveDown() throws IOException {
		if (this.getY() != this.getMap().getHeight()) {
			switch (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getCollision()) {
			case PENETRABLE:
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				this.collect(this.getX(), this.getY() + 1);
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case KILL:
				die();
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case WIN:
				win();
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case OPENDOOR:
				openTheDoor(this.getX(), this.getY() + 1);
				break;
			default:
				break;
			}
		}
	}

	public void moveLeft() throws IOException {
		if (this.getX() != 0) {
			switch (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getCollision()) {
			case PENETRABLE:
				this.setX(this.getX() - 1);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				this.collect(this.getX() - 1, this.getY());
				this.setX(this.getX() - 1);
				this.setHasMoved();
				break;
			case KILL:
				die();
				break;
			case WIN:
				win();
				this.setX(this.getX() - 1);
				this.setHasMoved();
				break;
			case OPENDOOR:
				openTheDoor(this.getX() - 1, this.getY());
				this.setX(this.getX() - 1);
				this.setHasMoved();
				break;
			default:
				break;
			}
		}
	}

	public void moveRight() throws IOException {
		if (this.getX() != this.getMap().getWidth()) {
			switch (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getCollision()) {
			case PENETRABLE:
				this.setX(this.getX() + 1);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				this.collect(this.getX() + 1, this.getY());
				this.setX(this.getX() + 1);
				this.setHasMoved();
				break;
			case KILL:
				die();
				break;
			case WIN:
				win();
				this.setX(this.getX() + 1);
				this.setHasMoved();
				break;
			case OPENDOOR:
				openTheDoor(this.getX() + 1, this.getY());
				this.setX(this.getX() + 1);
				this.setHasMoved();
				break;
			default:
				break;
			}
		}
	}

<<<<<<< HEAD
	public void moveUpRight() {

		this.setX(this.getX() + 1);
		this.setY(this.getY() - 1);
		this.setHasMoved();
=======
	public void moveUpRight() throws IOException {
		
			if (this.getX() != this.getMap().getWidth()) {
				switch (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY() - 1).getCollision()) {
				case PENETRABLE:
					this.setX(this.getX() + 1);
					this.setY(this.getY() - 1);
					this.setHasMoved();
					break;
				case COLLECTABLE:
					this.collect(this.getX() + 1, this.getY() - 1);
					this.setX(this.getX() + 1);
					this.setY(this.getY() - 1);
					this.setHasMoved();
					break;
				case KILL:
					die();

					break;
				case WIN:
					win();
					this.setX(this.getX() + 1);
					this.setY(this.getY() - 1);
					this.setHasMoved();
					break;
				case OPENDOOR:
					openTheDoor(this.getX() + 1, this.getY() - 1);
					this.setX(this.getX() + 1);
					this.setY(this.getY() - 1);
					this.setHasMoved();
					break;
				default:
					break;
				}
			}
		}

	public void moveUpLeft() throws IOException {
		
		if (this.getX() != this.getMap().getWidth()) {
			switch (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY() - 1).getCollision()) {
			case PENETRABLE:
				this.setX(this.getX() - 1);
				this.setY(this.getY() - 1);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				this.collect(this.getX() - 1, this.getY() - 1);
				this.setX(this.getX() - 1);
				this.setY(this.getY() - 1);
				this.setHasMoved();
				break;
			case KILL:
				die();

				break;
			case WIN:
				win();
				this.setX(this.getX() - 1);
				this.setY(this.getY() - 1);
				this.setHasMoved();
				break;
			case OPENDOOR:
				openTheDoor(this.getX() - 1, this.getY() - 1);
				this.setX(this.getX() - 1);
				this.setY(this.getY() - 1);
				this.setHasMoved();
				break;
			default:
				break;
			}
		}
>>>>>>> branch 'master' of https://github.com/abiLaldji/Nicol-de.git
	}

	public void moveDownRight() throws IOException {
		
		if (this.getX() != this.getMap().getWidth()) {
			switch (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY() + 1).getCollision()) {
			case PENETRABLE:
				this.setX(this.getX() + 1);
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				this.collect(this.getX() + 1, this.getY() + 1);
				this.setX(this.getX() + 1);
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case KILL:
				die();

				break;
			case WIN:
				win();
				this.setX(this.getX() + 1);
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case OPENDOOR:
				openTheDoor(this.getX() + 1, this.getY() + 1);
				this.setX(this.getX() + 1);
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			default:
				break;
			}
		}
	}

	public void moveDownLeft() throws IOException {
		
		if (this.getX() != this.getMap().getWidth()) {
			switch (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY() + 1).getCollision()) {
			case PENETRABLE:
				this.setX(this.getX() - 1);
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				this.collect(this.getX() - 1, this.getY() + 1);
				this.setX(this.getX() - 1);
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case KILL:
				die();

				break;
			case WIN:
				win();
				this.setX(this.getX() - 1);
				this.setY(this.getY() + 1);
				this.setHasMoved();
				break;
			case OPENDOOR:
				openTheDoor(this.getX() - 1, this.getY() + 1);
				this.setX(this.getX() - 1);
				this.setY(this.getY() + 1);
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

	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	public void win() {
		JOptionPane.showMessageDialog(null, "YOU WIN");
		JOptionPane.showMessageDialog(null, getScore());
		System.exit(0);
	}

	private void collect(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "empty.png"));
		this.getMap().getOnTheMapXY(x, y).setCollision(Collision.PENETRABLE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
		score = score + 1;
		System.out.print("Your score : ");
		System.out.println(score);
	}

	private void openTheDoor(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "empty.png"));
		this.getMap().getOnTheMapXY(x, y).setCollision(Collision.PENETRABLE);
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
		this.setSpell(new Spell(this.getX() + 1, this.getY(), this.getMap()));
		// this.getMap().getOnTheMapXY(this.getX() + x, this.getY() + y).move();
	}

	private void setSpell(Spell spell) {
		this.spell = spell;
	}

	public final int getX() {
		return this.getPosition().x;
	}

	public final void setX(final int x) {
		this.getPosition().x = x;
	}

	public final int getY() {
		return this.getPosition().y;
	}

	public final void setY(final int y) {
		this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
	}

	private void setMap(final IMap map) {
		this.map = map;
	}

	public boolean isAlive() {
		return this.alive;
	}

	protected void die() throws IOException {
		this.alive = false;
		JOptionPane.showMessageDialog(null, "YOU DIED");
		System.exit(0);
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
