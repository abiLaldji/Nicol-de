package model.element.nonMobile;

import model.Collision;
import model.element.Sprite;

class Ball extends NonMobile {

    private static final Sprite SPRITE = new Sprite('B', "crystal_ball.png");

   
    Ball() {
        super(SPRITE, Collision.OPENDOOR);
    }
}