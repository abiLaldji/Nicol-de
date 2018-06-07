package model.element.mobile;

import java.io.IOException;

import controller.UserOrder;
import model.Collision;
import model.IMap;
import model.Mdirection;
import model.element.Sprite;

public class Spell extends Mobile {

	private static final Sprite spriteS = new Sprite('S', "fireball_1.png");

	public Spell(final int x, final int y, final IMap map) throws IOException {
		super(x, y, spriteS, map, Collision.POWER);
		spriteS.loadImage();
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
		// TODO Auto-generated method stub

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

	public void move() throws IOException {
		Mdirection dir = null;
		UserOrder ord = UserOrder.DOWN;

		switch (ord) {
		case DOWN:
			dir = Mdirection.MUP;
			break;
		case UP:
			dir = Mdirection.MDOWN;
			break;
		case LEFT:
			dir = Mdirection.MRIGHT;
			break;
		case RIGHT:
			dir = Mdirection.MLEFT;
			break;
		case UPRIGHT:
			dir = Mdirection.MDOWNLEFT;
			break;
		case UPLEFT:
			dir = Mdirection.MDOWNRIGHT;
			break;
		case DOWNRIGHT:
			dir = Mdirection.MUPLEFT;
			break;
		case DOWNLEFT:
			dir = Mdirection.MUPRIGHT;
			break;
		default:
			break;
		}
		switch (dir) {
		case MUP:
			switch (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getCollision()) {
			case FREE:
				this.setXY(this.getX(), this.getY() - 1);
				this.setHasMoved();
				break;
			case LORANN:
				this.collectSpell(this.getX(), this.getY() - 1);
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MDOWN;
				break;
			default:
				break;
			}
			break;
		case MDOWN:
			switch (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getCollision()) {
			case FREE:
				this.setXY(this.getX(), this.getY() + 1);
				this.setHasMoved();
				break;
			case LORANN:
				this.collectSpell(this.getX(), this.getY() + 1);
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MUP;
				break;
			default:
				break;
			}
			break;
		case MRIGHT:
			switch (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getCollision()) {
			case FREE:
				this.setXY(this.getX() + 1, this.getY());
				this.setHasMoved();
				break;
			case LORANN:
				this.collectSpell(this.getX(), this.getY());
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MLEFT;
				break;
			default:
				break;
			}
			break;
		case MLEFT:
			switch (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getCollision()) {
			case FREE:
				this.setXY(this.getX() - 1, this.getY());
				this.setHasMoved();
				break;
			case LORANN:
				this.collectSpell(this.getX(), this.getY());
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MRIGHT;
				break;
			default:
				break;
			}
			break;
		case MDOWNLEFT:
			switch (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY() + 1).getCollision()) {
			case FREE:
				this.setXY(this.getX() - 1, this.getY() + 1);
				this.setHasMoved();
				break;
			case LORANN:
				this.collectSpell(this.getX(), this.getY());
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MUPRIGHT;
				break;
			default:
				break;
			}
			break;
		case MDOWNRIGHT:
			switch (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY() + 1).getCollision()) {
			case FREE:
				this.setXY(this.getX() + 1, this.getY() + 1);
				this.setHasMoved();
				break;
			case LORANN:
				this.collectSpell(this.getX(), this.getY());
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MUPLEFT;
				break;
			default:
				break;
			}
			break;
		case MUPLEFT:
			switch (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY() - 1).getCollision()) {
			case FREE:
				this.setXY(this.getX() - 1, this.getY() - 1);
				this.setHasMoved();
				break;
			case LORANN:
				this.collectSpell(this.getX(), this.getY());
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MDOWNRIGHT;
				break;
			default:
				break;
			}
			break;
		case MUPRIGHT:
			switch (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY() - 1).getCollision()) {
			case FREE:
				this.setXY(this.getX() + 1, this.getY() - 1);
				this.setHasMoved();
				break;
			case LORANN:
				this.collectSpell(this.getX(), this.getY());
				this.setHasMoved();
				break;
			case BLOCKING:
				dir = Mdirection.MDOWNLEFT;
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}


	private void collectSpell(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "empty.png"));
		this.getMap().getOnTheMapXY(x, y).setCollision(Collision.FREE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
	}

}
