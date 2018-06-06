package model.element;

import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

import model.Collision;
import model.ISprite;

public class Sprite implements ISprite {

	/** A sprite is composed of an Image, a Collision type, and a console image */
	
	private boolean loaded;
	private String imageLink;
	private Image image;
	private char consoleImage;
	private boolean visible;
	private Collision collision;
	/** Yes I know it is horrible */
	private String chemin = "/home/abi/git/Nicol-de/Lorann/image/";

	public Sprite(final char character, final String imageName) {
		this.setConsoleImage(character);
		this.setImageLink(imageName);
	}

	/** Just load the image of the sprite */

	public final void loadImage() throws IOException {
		ImageIcon ii = new ImageIcon(chemin + this.getImageLink());
		setImage(ii.getImage());
		this.setLoaded(true);
		this.setVisible(true);
	}

	public Collision getCollision() {
		return this.collision;
	}

	public void setCollision(Collision collision) {
		this.collision = collision;
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

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

}
