package model.element.nonMobile;

import model.Collision;
import model.element.Sprite;

class OpenDoor extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "gate_open.png");

   
    OpenDoor() {
        super(SPRITE, Collision.WIN);
    }
}