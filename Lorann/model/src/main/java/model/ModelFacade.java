package model;

import java.io.IOException;

import model.element.mobile.Lorann;
import model.element.mobile.Monster;
import model.element.mobile.Spell;

public class ModelFacade implements IModel {

	private IMap map;

	private IMobile lorann;

	private IMobile monster;

	private IMobile spell;

	public ModelFacade() throws IOException {
		System.out.println("model");
		this.setMap(new Map());
		this.setLorann(new Lorann(this.getMap().getStartX(), this.getMap().getStartY(), this.getMap()));
		this.setMonster(new Monster(this.getMap().getStartXM(), this.getMap().getStartYM(), this.getMap()));
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

	public IMobile getSpell() {
		return spell;
	}

	public void setSpell(IMobile spell) {
		this.spell = spell;
	}
	
	public void initSpell(int x, int y) throws IOException {
		System.out.println("spell");
		this.spell = new Spell(this.getLorann().getX() + x, this.getLorann().getY() + y, this.getMap());
		this.getSpell().getSprite().loadImage();
	}

}
