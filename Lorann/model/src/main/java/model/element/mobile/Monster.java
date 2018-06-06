package model.element.mobile;

import java.io.IOException;

import model.Collision;
import model.IMap;
import model.Mdirection;
import model.element.Sprite;

public class Monster extends Mobile {
	Mdirection dir = Mdirection.MUP;


	private static final Sprite spriteM = new Sprite('#', "monster_1.png");

	public Monster(final int x, final int y, final IMap map) throws IOException {
		super(x, y, spriteM, map, Collision.KILL);
		spriteM.loadImage();
	}

	public void move() {

		if (dir == Mdirection.MUP) {
			switch (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getCollision()) {
			case FREE:
				this.setXY(this.getX(), this.getY() - 1);
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MDOWN;
				break;
			case COLLECTABLE:
				dir = Mdirection.MDOWN;
				break;
			case OPENDOOR:
				dir = Mdirection.MDOWN;
				break;
			default:
				break;
			}
		}

		if (dir == Mdirection.MDOWN) {
			switch (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getCollision()) {
			case FREE:
				this.setXY(this.getX(), this.getY() + 1);
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MUP;
				break;
			case COLLECTABLE:
				dir = Mdirection.MUP;
				break;
			case OPENDOOR:
				dir = Mdirection.MUP;
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
