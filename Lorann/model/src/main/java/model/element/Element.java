package model.element;

import java.awt.Image;



public abstract class Element {
	
	private Sprite sprite;
	
	private Penetrability penetrability;
	
	public Element(Sprite sprite, Penetrability penetrability) {
		this.setSprite(sprite);
        this.setPenetrability(penetrability);
	}
	
    public final Sprite getSprite() {
        return this.sprite;
    }

    protected final void setSprite(final Sprite sprite) {
    	this.sprite = sprite;
    }
	public final Penetrability getPenetrability() {
        return this.penetrability;
    }
	private void setPenetrability(final Penetrability penetrability) {
        this.penetrability = penetrability;
    }

	public final Image getImage() {
		return this.getSprite().getImage();
    }
}
