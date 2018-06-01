package model.element.nonMobile;

import model.element.Penetrability;
import model.element.Sprite;

class HBone extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "images/horizontal_bone.png");

   
    HBone() {
        super(SPRITE, Penetrability.BLOCKING);
    }
}
