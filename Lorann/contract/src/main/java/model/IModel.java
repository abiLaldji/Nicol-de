package model;

import java.io.IOException;

public interface IModel {

	public IMap getMap();

	public IMobile getLorann();

	public IMobile getMonster();
	
	public IMobile getSpell();

	public void initSpell(int i, int j) throws IOException;
	
}
