package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class HBone extends NonMobile {

    private static final Sprite SPRITE = new Sprite('_', "image/horizontal_bone.png");

   
    HBone() {
        super(SPRITE, Penetrability.BLOCKING);
    }
}
