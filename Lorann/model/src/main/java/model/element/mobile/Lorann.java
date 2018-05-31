package model.element.mobile;

import model.element.Penetrability;
import model.element.Sprite;

public class Lorann extends Mobile{
Lorann(Sprite sprite, Penetrability penetrability) {
		super(sprite, penetrability);
		// TODO Auto-generated constructor stub
	}

private int point =0;

public int getPoint() {
	return point;
}

public void setPoint(int point) {
	this.point = point;
}

}
