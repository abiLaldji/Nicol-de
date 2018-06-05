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
			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getCollision() == Collision.PENETRABLE) {
				this.setY(this.getY() - 1);
				this.setHasMoved();
			}

			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getCollision() == Collision.OPENDOOR) {
				// gate change
			}
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getCollision() == Collision.COLLECTABLE) {
			System.out.println("collect");
			collect(this.getX(), this.getY() - 1);
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getCollision() == Collision.WIN) {
			win();

		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getCollision() == Collision.KILL) {
			die();

		}
	}

	public void moveDown() throws IOException {
		if (this.getY() != this.getMap().getHeight()) {
			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getCollision() == Collision.PENETRABLE) {
				this.setY(this.getY() + 1);
				this.setHasMoved();
			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getCollision() == Collision.OPENDOOR) {
				// gate change

			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getCollision() == Collision.COLLECTABLE) {
				System.out.println("collect");
				collect(this.getX(), this.getY() + 1);
			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getCollision() == Collision.WIN) {
				win();
			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getCollision() == Collision.KILL) {
				die();

			}
		}

	}

	public void moveLeft() throws IOException {
		if (this.getX() != 0) {
			if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getCollision() == Collision.PENETRABLE) {
				this.setX(this.getX() - 1);
				this.setHasMoved();
			}
				else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getCollision() == Collision.OPENDOOR) {
				System.out.println("opendoor");
				// gate change
			
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getCollision() == Collision.COLLECTABLE) {
			System.out.println("collect");
			collect(this.getX() - 1, this.getY());
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getCollision() == Collision.WIN) {
			win();
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getCollision() == Collision.KILL) {
			die();
		}
		}
	}

	public void moveRight() throws IOException {
		if (this.getX() != this.getMap().getWidth()) {
			if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getCollision() == Collision.PENETRABLE) {
				this.setX(this.getX() + 1);
				this.setHasMoved();
			}
			if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getCollision() == Collision.OPENDOOR) {
				// gate change
			}
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getCollision() == Collision.COLLECTABLE) {
			System.out.println("collect");
			this.collect(this.getX() + 1, this.getY());
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getCollision() == Collision.WIN) {
			win();
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getCollision() == Collision.KILL) {
			die();
		}
	}

	public void moveUpRight() {
		this.setX(this.getX() + 1);
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	public void moveUpLeft() {
		this.setX(this.getX() - 1);
		this.setY(this.getY() - 1);
		this.setHasMoved();

	}

	public void moveDownRight() {
		this.setX(this.getX() + 1);
		this.setY(this.getY() + 1);
		this.setHasMoved();

	}

	public void moveDownLeft() {
		this.setX(this.getX() - 1);
		this.setY(this.getY() + 1);
		this.setHasMoved();
	}

	public void doNothing() {
		this.setHasMoved();
	}

	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	public void win() {
		JOptionPane.showMessageDialog(null, "You Win, your score is");
		JOptionPane.showMessageDialog(null, getScore());
		System.exit(0);
	}

	private void collect(int x, int y) throws IOException {
		System.out.println("collect");
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "empty.png"));
		this.getMap().getOnTheMapXY(x, y).setCollision(Collision.PENETRABLE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
		score = score + 1;
		System.out.print("Your score : ");
		System.out.println(score);

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

	protected void die() {
		this.alive = false;
		this.setHasMoved();
		JOptionPane.showMessageDialog(null, "You loose");
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
