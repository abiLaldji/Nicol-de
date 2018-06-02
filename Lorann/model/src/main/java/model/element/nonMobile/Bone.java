package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class Bone extends NonMobile {

    private static final Sprite SPRITE = new Sprite('o', "image/bone.png");

   
    Bone() {
        super(SPRITE, Penetrability.BLOCKING);
    }
}