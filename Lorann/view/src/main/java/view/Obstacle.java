package view;

import java.awt.Image;

import javax.swing.ImageIcon;

import showboard.ISquare;

public class Obstacle implements ISquare {
	
	private Image image; 
	
	public Obstacle(String fileName) {
		ImageIcon ii = new ImageIcon("images/bone.png");
		this.image = ii.getImage();
		
	}

	@Override
	public Image getImage() {
		return this.image;
	}

}
