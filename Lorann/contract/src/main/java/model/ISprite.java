package model;

import java.awt.Image;
import java.io.IOException;

public interface ISprite {
	
	public void loadImage() throws IOException;

	public char getConsoleImage();

	public boolean isVisible();

	public Image getImage();

	public String getImageLink();

}
