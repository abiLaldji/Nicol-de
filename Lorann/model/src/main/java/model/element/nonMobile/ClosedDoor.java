package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class ClosedDoor extends NonMobile {

    private static final Sprite SPRITE = new Sprite(']', "image/gate_closed");

   
    ClosedDoor() {
        super(SPRITE, Penetrability.BLOCKING);
    }
}