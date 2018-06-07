package model.element.mobile;

import java.io.IOException;

import model.Collision;
import model.IMap;
import model.element.Sprite;

public class Spell extends Mobile {

	private static final Sprite spriteS = new Sprite('S', "fireball_1.png");

	public Spell(final int x, final int y, final IMap map) throws IOException {
		super(x, y, spriteS, map, Collision.POWER);
		spriteS.loadImage();
	}

	public void move() throws IOException {
		System.out.println("move");
		this.setXY(this.getX() - 1, this.getY());
		this.setHasMoved();
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

}
