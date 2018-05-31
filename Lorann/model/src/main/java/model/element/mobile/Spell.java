package model.element.mobile;


import java.io.IOException;

import model.IMap;
import model.element.Penetrability;
import model.element.Sprite;

public class Spell extends Mobile{
	
    private static final Sprite spriteS = new Sprite('S', "images/monster_1.png");

    public Spell(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteS, map, Penetrability.BLOCKING);
        spriteS.loadImage();   
    }
}
