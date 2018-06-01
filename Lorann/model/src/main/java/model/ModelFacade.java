package model;

import java.io.IOException;

import model.element.mobile.IMobile;
import model.element.mobile.Lorann;


public class ModelFacade implements IModel {

    private IMap   map;

    private IMobile lorann;

    public ModelFacade(final int lorannStartX, final int lorannStartY) throws IOException {
        this.setMap(new Map());
        this.setLorann(new Lorann(lorannStartX, lorannStartY, this.getMap()));
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
