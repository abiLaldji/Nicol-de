package model.element.mobile;

import java.io.IOException;

import model.Collision;
import model.IMap;
import model.Mdirection;
import model.element.Sprite;

public class Monster3 extends Mobile {
	Mdirection dir = Mdirection.MUPLEFT;

	private static final Sprite spriteM3 = new Sprite('3', "monster_3.png");

	public Monster3(final int x, final int y, final IMap map) throws IOException {
		super(x, y, spriteM3, map, Collision.KILL);
		spriteM3.loadImage();
	}

	/**
	 * movement of the monster, when it hit a purse, wall or ball, it turn around.
	 * This monster can do up and down
	 */

	public void move() {

		if (dir == Mdirection.MUPLEFT) {
			switch (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY() - 1).getCollision()) {
			case FREE:
				this.setXY(this.getX() - 1, this.getY() - 1);
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MDOWNRIGHT;
				break;
			case COLLECTABLE:
				dir = Mdirection.MDOWNRIGHT;
				break;
			case OPENDOOR:
				dir = Mdirection.MDOWNRIGHT;
				break;
			default:
				break;
			}
		}

		if (dir == Mdirection.MDOWNRIGHT) {
			switch (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY() + 1).getCollision()) {
			case FREE:
				this.setXY(this.getX() + 1, this.getY() + 1);
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MUPLEFT;
				break;
			case COLLECTABLE:
				dir = Mdirection.MUPLEFT;
				break;
			case OPENDOOR:
				dir = Mdirection.MUPLEFT;
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void moveUp() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDown() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft() throws IOException {
		super.move(-1, 0);

	}

	@Override
	public void moveRight() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveUpRight() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveUpLeft() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDownRight() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDownLeft() throws IOException {
		// TODO Auto-generated method stub

	}
}
