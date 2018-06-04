package model;

import java.awt.Image;

import showboard.ISquare;


public interface IElement extends ISquare {
	
	
    public  ISprite getSprite();

    
	public  Collision getCollision();


	public  Image getImage();


	public void setSprite(ISprite sprite);


	public void setCollision(Collision collision);
}


