package view;

import java.awt.Image;

import javax.swing.ImageIcon;

import showboard.ISquare;

public class Obstacle implements ISquare {
	
	Image image;
	
	public Obstacle(String image) {
		ImageIcon ii = new ImageIcon(image);
		this.image = ii.getImage();
	}

	@Override
	public Image getImage() {
			return this.image;
	}               

}
