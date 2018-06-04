package model.element.mobile;

import java.io.IOException;

import model.IMap;
import model.Penetrability;
import model.element.Sprite;

public class Monster extends Mobile{
	
    private static final Sprite spriteM = new Sprite('#', "images/monster_1.png");
    
   
    public Monster(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteM, map, Penetrability.KILL);
        spriteM.loadImage();   
        
    }
}
