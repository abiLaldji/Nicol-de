package model.element.nonMobile;

import model.element.Sprite;
import model.element.Dimension;
import model.element.Direction;
import model.element.Penetrability;
import model.element.Position;


public class EnergieBubble extends Sprite {
	public EnergieBubble(Direction direction, Position position, Penetrability penetrability, Dimension dimension,
			String imageLink) {
		super(direction, position, penetrability, dimension, imageLink);
		// TODO Auto-generated constructor stub
	}

	private static String IMAGE="crystal_ball.png";
}
