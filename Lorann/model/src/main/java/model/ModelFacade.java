package model;

import java.io.IOException;

import model.element.mobile.Lorann;
import model.element.mobile.Monster;

public class ModelFacade implements IModel {

	private IMap map;

	private IMobile lorann;

	private IMobile monster;

	private static final int startX = 1;

	private static final int startY = 1;

	private static final int startXM = 15;

	private static final int startYM = 2;

	public ModelFacade() throws IOException {
		System.out.println("model");
		this.setMap(new Map());
		this.setLorann(new Lorann(startX, startY, this.getMap()));
		this.setMonster(new Monster(startXM, startYM, this.getMap()));
		this.getLorann().getSprite().loadImage();
		this.getMonster().getSprite().loadImage();
	}

	private void setMonster(Monster monster) {
		this.monster = monster;

	}

	public IMobile getMonster() {
		return this.monster;
	}

	public final IMap getMap() {
		return this.map;
	}

	private void setMap(final IMap map) {
		this.map = map;
	}

	public final IMobile getLorann() {
		return this.lorann;
	}

	private void setLorann(final IMobile lorann) {
		this.lorann = lorann;
	}

}
