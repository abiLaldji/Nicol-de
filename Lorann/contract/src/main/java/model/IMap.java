package model;

import java.util.Observable;;

public interface IMap {

	int getWidth();

	int getHeight();

	IElement getOnTheMapXY(final int x, final int y);

	Observable getObservable();

	void setMobileHasChanged();

	void setEmptyXY(final int x, final int y);
}
