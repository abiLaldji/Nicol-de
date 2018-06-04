package model.element;

import java.awt.Image;

import model.Collision;
import model.IElement;
import model.ISprite;
import showboard.ISquare;

public abstract class Element implements ISquare, IElement {

	private ISprite sprite;

	private Collision collision;

	public Element(Sprite sprite, Collision collision) {
		this.setSprite(sprite);
		this.setCollision(collision);
	}

	public final ISprite getSprite() {
		return this.sprite;
	}

	public void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}

	public final Collision getCollision() {
		return this.collision;
	}

	public void setCollision(final Collision collision) {
		this.collision = collision;
	}

	public final Image getImage() {
		return this.getSprite().getImage();
	}
}
