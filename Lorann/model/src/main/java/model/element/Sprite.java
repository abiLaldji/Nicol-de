package model.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.ISprite;
import model.Penetrability;

public class Sprite implements ISprite{
	private boolean loaded;
	private String imageLink;
	private Image image;
	private char consoleImage;
	private boolean visible;
	private Penetrability penetrability;
	
	
	public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageLink(imageName);
    }

	public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File(this.getImageLink())));
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
