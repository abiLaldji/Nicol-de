package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class Empty extends NonMobile {

    private static final Sprite SPRITE = new Sprite(' ', "image/empty.png");

   
    Empty() {
        super(SPRITE, Penetrability.PENETRABLE);
    }
}