package model;

import java.io.IOException;

import model.element.mobile.Lorann;
import model.element.mobile.Monster;
import model.element.mobile.Monster2;
import model.element.mobile.Monster3;
import model.element.mobile.Monster4;

public class ModelFacade implements IModel {

	private IMap map;

	private IMobile lorann;

	private IMobile monster;

	private IMobile monster2;
	
	private IMobile monster3;
	
	private IMobile monster4;

	private IMobile spell;

	public ModelFacade() throws IOException {
		System.out.println("model");
		this.setMap(new Map());
		this.setLorann(new Lorann(this.getMap().getStartX(), this.getMap().getStartY(), this.getMap()));
		this.setMonster(new Monster(this.getMap().getStartXM(), this.getMap().getStartYM(), this.getMap()));
		this.getLorann().getSprite().loadImage();
		this.getMonster().getSprite().loadImage();
		this.setMonster2(new Monster2(this.getMap().getStartXM2(), this.getMap().getStartYM2(), this.getMap()));
		this.getMonster2().getSprite().loadImage();
		this.setMonster3(new Monster3(this.getMap().getStartXM3(), this.getMap().getStartYM3(), this.getMap()));
		this.getMonster3().getSprite().loadImage();
		this.setMonster4(new Monster4(this.getMap().getStartXM4(), this.getMap().getStartYM4(), this.getMap()));
		this.getMonster4().getSprite().loadImage();

	}

	public IMobile getMonster2() {
		return this.monster2;
	}

	private void setMonster2(Monster2 monster22) {
		this.monster2 = monster22;
	}
	
	public IMobile getMonster3() {
		return this.monster3;
	}

	private void setMonster3(Monster3 monster32) {
		this.monster3 = monster32;
	}
	
	public IMobile getMonster4() {
		return this.monster4;
	}

	private void setMonster4(Monster4 monster42) {
		this.monster4 = monster42;
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

}
