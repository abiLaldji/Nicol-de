package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

public class Purse extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "image/purse.png");

   
    Purse() {
        super(SPRITE, Penetrability.PENETRABLE);
    }
}