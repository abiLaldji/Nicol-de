package model.element;

import java.awt.Image;

import showboard.ISquare;





public interface IElement extends ISquare {
	
	
    public  Sprite getSprite();


    
	public  Penetrability getPenetrability();


	public  Image getImage();
}
