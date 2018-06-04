package model.element.nonMobile;

import model.Collision;
import model.element.Sprite;

class ClosedDoor extends NonMobile {

    private static final Sprite SPRITE = new Sprite(']', "gate_closed.png");

   
    ClosedDoor() {
        super(SPRITE, Collision.KILL);
    }
}