package model.element.nonMobile;

import model.Collision;
import model.element.Sprite;

class Bone extends NonMobile {

//    private static final Sprite SPRITE = new Sprite('o', "image/bone.png");
    private static final Sprite SPRITE = new Sprite('o', "bone.png");
 
   
    Bone() {
        super(SPRITE, Collision.BLOCKING);
    }
}