package model.element.nonMobile;

import model.Collision;
import model.element.Sprite;

class HBone extends NonMobile {

    private static final Sprite SPRITE = new Sprite('_', "horizontal_bone.png");

   
    HBone() {
        super(SPRITE, Collision.BLOCKING);
    }
}
