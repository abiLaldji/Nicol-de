package model;

import java.util.Observable;

import model.element.Element;;


public interface IMap {

	void semer();
	
	int getWidth();

    int getHeight() ;

    Element getOnTheMapXY(final int x, final int y);

    Observable getObservable();

	void setMobileHasChanged();
}
