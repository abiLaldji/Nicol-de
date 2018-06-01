package model.element;

import java.awt.Image;

import model.IElement;
import model.ISprite;
import model.Penetrability;
import showboard.ISquare;



public abstract class Element implements ISquare, IElement{
	
	private Sprite sprite;
	
	private Penetrability penetrability;
	
	public Element(Sprite sprite, Penetrability penetrability) {
		this.setSprite(sprite);
        this.setPenetrability(penetrability);
	}
	
    public final ISprite getSprite() {
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
