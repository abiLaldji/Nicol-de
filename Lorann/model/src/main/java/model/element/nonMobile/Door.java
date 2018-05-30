package model.element.nonMobile;

import model.element.Sprite;
import model.element.Dimension;
import model.element.Direction;
import model.element.Penetrability;
import model.element.Position;


public class Door extends Sprite {
	private State state;
	
	public Door(Direction direction, Position position, Penetrability penetrability, Dimension dimension,
			String imageLink) {
		super(direction, position, penetrability, dimension, imageLink);
		// TODO Auto-generated constructor stub
	}

	public void setState(State state) {
	}
	
	public State getState() {
		return state;
}
	
	
}

