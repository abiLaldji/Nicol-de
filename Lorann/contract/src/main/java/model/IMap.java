package model;

import java.util.Observable;;


public interface IMap {

	void semer();
	
	int getWidth();

    int getHeight() ;

    IElement getOnTheMapXY(final int x, final int y);

    Observable getObservable();

	void setMobileHasChanged();
}
