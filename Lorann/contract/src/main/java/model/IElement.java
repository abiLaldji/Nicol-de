package model;

import java.awt.Image;

import showboard.ISquare;


public interface IElement extends ISquare {
	
	
    public  ISprite getSprite();

    
	public  Penetrability getPenetrability();


	public  Image getImage();
}


