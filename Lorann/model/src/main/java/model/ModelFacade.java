package model;

import java.io.IOException;
import java.util.ArrayList;

import model.element.mobile.Lorann;
import model.element.mobile.Monster;


public class ModelFacade implements IModel {

    private IMap   map;

    private IMobile lorann;
    
    private ArrayList<Monster> monster = new ArrayList<Monster>();

    public ModelFacade(final int lorannStartX, final int lorannStartY, final int monsterX, final int monsterY) throws IOException {
    	System.out.println("model");
        this.setMap(new Map());
        this.setLorann(new Lorann(lorannStartX, lorannStartY, this.getMap()));
        this.getMonster();
        
        this.getMonster().add(new Monster(monsterX, monsterY, this.getMap()));
    }

    public ArrayList<Monster> getMonster() {
    	return monster;
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
