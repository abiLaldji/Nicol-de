package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class Bone extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "images/Bone.png");

   
    Bone() {
        super(SPRITE, Penetrability.BLOCKING);
    }
}