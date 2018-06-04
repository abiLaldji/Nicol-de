package model.element.mobile;


import java.io.IOException;

import model.Collision;
import model.IMap;
import model.element.Sprite;

public class Spell extends Mobile{
	
    private static final Sprite spriteS = new Sprite('S', "fireball_1");

    public Spell(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteS, map, Collision.BLOCKING);
        spriteS.loadImage();   
    }
}
