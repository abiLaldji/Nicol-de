package model.element.nonMobile;

import model.Collision;
import model.element.Sprite;

class VBone extends NonMobile {

    private static final Sprite SPRITE = new Sprite('|', "vertical_bone.png");

   
    VBone() {
        super(SPRITE, Collision.BLOCKING);
    }
}