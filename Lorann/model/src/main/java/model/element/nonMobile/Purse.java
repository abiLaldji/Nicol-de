package model.element.nonMobile;

import model.Collision;
import model.element.Sprite;

public class Purse extends NonMobile {

    private static final Sprite SPRITE = new Sprite('P', "purse.png");

   
    Purse() {
        super(SPRITE, Collision.COLLECTABLE);
    }
}