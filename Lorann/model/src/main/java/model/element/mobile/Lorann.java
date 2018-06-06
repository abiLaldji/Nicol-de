package model.element.mobile;

import java.io.IOException;

import model.Collision;
import model.IMap;
import model.element.Sprite;

public class Lorann extends Mobile {

	private static final Sprite SPRITE_U = new Sprite('L', "lorann_u.png");

	private static final Sprite SPRITE_BL = new Sprite('L', "lorann_bl.png");

	private static final Sprite SPRITE_BR = new Sprite('L', "lorann_br.png");

	private static final Sprite SPRITE_L = new Sprite('L', "lorann_l.png");

	private static final Sprite SPRITE_B = new Sprite('L', "lorann_b.png");

	private static final Sprite SPRITE_R = new Sprite('L', "lorann_r.png");

	private static final Sprite SPRITE_UL = new Sprite('L', "lorann_ul.png");

	private static final Sprite SPRITE_UR = new Sprite('L', "lorann_ur.png");

	public Lorann(final int x, final int y, final IMap map) throws IOException {
		super(x, y, SPRITE_U, map, Collision.BLOCKING);
		SPRITE_U.loadImage();
		SPRITE_B.loadImage();
		SPRITE_L.loadImage();
		SPRITE_R.loadImage();
		SPRITE_UR.loadImage();
		SPRITE_UL.loadImage();
		SPRITE_BL.loadImage();
		SPRITE_BR.loadImage();

	}

	public final void moveLeft() throws IOException {
		super.move(-1, 0);
		this.setSprite(SPRITE_L);
	}

	public final void moveRight() throws IOException {
		super.move(1, 0);
		this.setSprite(SPRITE_R);
	}

	public final void moveUp() throws IOException {
		super.move(0, -1);
		this.setSprite(SPRITE_U);
	}

	public final void moveDown() throws IOException {
		super.move(0, 1);
		this.setSprite(SPRITE_B);
	}

	public final void moveUpLeft() throws IOException {
		super.move(-1, -1);
		this.setSprite(SPRITE_UL);
	}

	public final void moveUpRight() throws IOException {
		super.move(1,-1);
		this.setSprite(SPRITE_UR);
	}

	public final void moveDownRight() throws IOException {
		super.move(1,1);
		this.setSprite(SPRITE_BR);
	}

	public final void moveDownLeft() throws IOException {
		super.move(-1,1);
		this.setSprite(SPRITE_BL);
	}

	public final void doNothing() {
		super.doNothing();
		while (isAlive()) {
			this.setSprite(SPRITE_U);

		}
	}


	@Override
	public void collect(int i, int j) throws IOException {		
	}

}
