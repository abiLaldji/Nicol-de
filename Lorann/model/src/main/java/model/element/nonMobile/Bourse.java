package model.element.nonMobile;

import model.element.Dimension;
import model.element.Direction;
import model.element.Penetrability;
import model.element.Position;
import model.element.Sprite;


public class Bourse extends Sprite{
	public Bourse(Direction direction, Position position, Penetrability penetrability, Dimension dimension,
			String imageLink) {
		super(direction, position, penetrability, dimension, imageLink);
		// TODO Auto-generated constructor stub
	}

	private static String IMAGE = "purse.png";

}
