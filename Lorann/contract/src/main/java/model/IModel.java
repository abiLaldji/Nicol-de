package model;

import java.io.IOException;

public interface IModel {

	public IMap getMap();

	public IMobile getLorann();

	public IMobile getMonster();
	
	public IMobile getSpell();

	public IMobile getMonster2();
	
	public IMobile getMonster3();
	
	public IMobile getMonster4();

	public void initSpell(int i, int j) throws IOException;
	
}
