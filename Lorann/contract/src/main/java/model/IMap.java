package model;

import java.util.Observable;;

public interface IMap {

	int getWidth();

	int getHeight();

	IElement getOnTheMapXY(final int x, final int y);

	Observable getObservable();

	void setMobileHasChanged();

	void setEmptyXY(final int x, final int y);

	public int getStartX();

	public int getStartY();

	public int getStartXM();

	public int getStartYM();

	public int getStartXM2();

	public int getStartYM2();

	public int getStartYM3();

	public int getStartXM3();

	public int getStartYM4();

	public int getStartXM4();

	void setOpenDoor(int x, int y);
}
