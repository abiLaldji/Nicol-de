package model.element.mobile;

import java.io.IOException;

import model.Collision;
import model.IMap;
import model.Mdirection;
import model.element.Sprite;

public class Monster4 extends Mobile {
	Mdirection dir = Mdirection.MDOWNLEFT;

	private static final Sprite spriteM4 = new Sprite('4', "monster_4.png");

	public Monster4(final int x, final int y, final IMap map) throws IOException {
		super(x, y, spriteM4, map, Collision.KILL);
		spriteM4.loadImage();
	}

	/**
	 * movement of the monster, when it hit a purse, wall or ball, it turn around.
	 * This monster can do up and down
	 */

	public void move() {

		if (dir == Mdirection.MDOWNLEFT) {
			switch (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY() + 1).getCollision()) {
			case FREE:
				this.setXY(this.getX() - 1, this.getY() + 1);
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MUPRIGHT;
				break;
			case COLLECTABLE:
				dir = Mdirection.MUPRIGHT;
				break;
			case OPENDOOR:
				dir = Mdirection.MUPRIGHT;
				break;
			default:
				break;
			}
		}

		if (dir == Mdirection.MUPRIGHT) {
			switch (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY() - 1).getCollision()) {
			case FREE:
				this.setXY(this.getX() + 1, this.getY() - 1);
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MDOWNLEFT;
				break;
			case COLLECTABLE:
				dir = Mdirection.MDOWNLEFT;
				break;
			case OPENDOOR:
				dir = Mdirection.MDOWNLEFT;
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
