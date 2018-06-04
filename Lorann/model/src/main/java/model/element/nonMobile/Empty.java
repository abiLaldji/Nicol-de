package model.element.nonMobile;

import model.Collision;
import model.element.Sprite;

class Empty extends NonMobile {

    private static final Sprite SPRITE = new Sprite(' ', "empty.png");

   
    Empty() {
        super(SPRITE, Collision.PENETRABLE);
    }
}