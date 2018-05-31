package view;

import java.awt.Image;

import javax.swing.ImageIcon;

import showboard.ISquare;

public class Obstacle implements ISquare {
	
	Image image;

	
	public Obstacle(String image) {
		loadImage(image);
	}
	
	private void loadImage(String image) {
		ImageIcon ii = new ImageIcon(image);
		this.image = ii.getImage();
		//resizeImage(this.image, 64 , 64);
	}
	
	  protected void resizeImage(Image image, int h ,int l) {
	    	this.image = image.getScaledInstance(h, l, Image.SCALE_DEFAULT);
	    }

	@Override
	public Image getImage() {
			return this.image;
	}               

}
