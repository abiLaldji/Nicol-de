package model.element.nonMobile;

import model.element.Penetrability;
import model.element.Sprite;

class OpenDoor extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "images/");

   
    OpenDoor() {
        super(SPRITE, Penetrability.BLOCKING);
    }
}