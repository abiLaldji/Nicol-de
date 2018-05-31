package model.element.nonMobile;

import model.element.Penetrability;
import model.element.Sprite;

class VBone extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "images/vertical_bone.png");

   
    VBone() {
        super(SPRITE, Penetrability.BLOCKING);
    }
}