package model.element.mobile;

import model.element.Penetrability;
import model.element.Sprite;

public class Monster extends Mobile{

	Monster(Sprite sprite, Penetrability penetrability) {
		super(sprite, penetrability);
		// TODO Auto-generated constructor stub
	}

	private MonsterType type;

	public MonsterType getType() {
		return type;
	}

	public void setType(MonsterType type) {
		this.type = type;
	}
}
