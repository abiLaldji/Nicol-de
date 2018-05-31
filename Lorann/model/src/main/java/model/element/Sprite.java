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
	
	
	public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageName(imageName);
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
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

}
