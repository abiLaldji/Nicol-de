package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class Ball extends NonMobile {

    private static final Sprite SPRITE = new Sprite('B', "image/crystal_ball.png");

   
    Ball() {
        super(SPRITE, Penetrability.OPENDOOR);
    }
}