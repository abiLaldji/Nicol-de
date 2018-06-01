package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class Bourse extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "images/");

   
    Bourse() {
        super(SPRITE, Penetrability.PENETRABLE);
    }
}