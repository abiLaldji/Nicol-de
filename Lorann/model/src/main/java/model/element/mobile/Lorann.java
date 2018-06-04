package model.element.mobile;

import java.io.IOException;

import model.IMap;
import model.Penetrability;
import model.element.Sprite;

public class Lorann extends Mobile {

	private static final Sprite SPRITE_U = new Sprite('L', "image/lorann_u.png");

	private static final Sprite SPRITE_BL = new Sprite('L', "image/lorann_bl.png");

	private static final Sprite SPRITE_BR = new Sprite('L', "image/lorann_br.png");

	private static final Sprite SPRITE_L = new Sprite('L', "image/lorann_l.png");

	private static final Sprite SPRITE_B = new Sprite('L', "image/lorann_b.png");

	private static final Sprite SPRITE_R = new Sprite('L', "image/lorann_br.png");

	private static final Sprite SPRITE_UL = new Sprite('L', "image/lorann_ul.png");

	private static final Sprite SPRITE_UR = new Sprite('L', "image/lorann_up.png");

	public Lorann(final int x, final int y, final IMap map) throws IOException {
		super(x, y, SPRITE_U, map, Penetrability.BLOCKING);
		SPRITE_U.loadImage();
		SPRITE_B.loadImage();
		SPRITE_L.loadImage();
		SPRITE_R.loadImage();
		SPRITE_UR.loadImage();
		SPRITE_UL.loadImage();
		SPRITE_BL.loadImage();
		SPRITE_BR.loadImage();

	}

	public final void moveLeft() {
		super.moveLeft();
		this.setSprite(SPRITE_L);
	}

	public final void moveRight() {
		super.moveRight();
		this.setSprite(SPRITE_R);
	}

	public final void moveUp() {
		super.moveUp();
		this.setSprite(SPRITE_U);
	}

	public final void moveDown() {
		super.moveDown();
		this.setSprite(SPRITE_B);
	}

	public final void moveUpLeft() {
		super.moveUpLeft();
		this.setSprite(SPRITE_UL);
	}

	public final void moveUpRight() {
		super.moveUpRight();
		this.setSprite(SPRITE_UR);
	}

	public final void moveDownRight() {
		super.moveDownRight();
		this.setSprite(SPRITE_BR);
	}

	public final void moveDownLeft() {
		super.moveDownLeft();
		this.setSprite(SPRITE_BL);
	}

	public final void doNothing() {
		super.doNothing();
		this.setSprite(SPRITE_U);
	}

}
