package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class OpenDoor extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "image/gate_open.png");

   
    OpenDoor() {
        super(SPRITE, Penetrability.WIN);
    }
}