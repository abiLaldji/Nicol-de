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

	private static final Sprite SPRITE_UR = new Sprite('L', "lorann_up.png");

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
		super.moveLeft();
		this.setSprite(SPRITE_L);
	}

	public final void moveRight() throws IOException {
		super.moveRight();
		this.setSprite(SPRITE_R);
	}

	public final void moveUp() throws IOException {
		super.moveUp();
		this.setSprite(SPRITE_U);
	}

	public final void moveDown() throws IOException {
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
