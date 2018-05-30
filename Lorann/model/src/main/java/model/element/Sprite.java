package model.element;

import java.awt.Image;

import showboard.BoardFrame;

public class Sprite {
	private boolean loaded;
	private String imageLink;
	private Image image;
	private char consoleImage;
	private boolean visible;
	private Direction direction;
	private Position position;
	private Dimension dimension;
	private Penetrability penetrability;
	private int imageHeight = 90;
	private int imageWidth = 96;
	
	
	public Sprite(Direction direction, Position position, Penetrability penetrability, Dimension dimension, String imageLink) {
		
	}
	
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Dimension getDimension() {
		return dimension;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public Penetrability getPenetrability() {
		return penetrability;
	}

	public void setPenetrability(Penetrability penetrability) {
		this.penetrability = penetrability;
	}
	
	public char getConsoleImage() {
		return consoleImage;
	}
	
	public void setConsoleImage(char consoleImage) {
		this.consoleImage = consoleImage;
	}
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	

}
