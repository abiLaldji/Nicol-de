package model.element.nonMobile;

import model.element.Penetrability;
import model.element.Sprite;

class ClosedDoor extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "images/");

   
    ClosedDoor() {
        super(SPRITE, Penetrability.BLOCKING);
    }
}