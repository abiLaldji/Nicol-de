package model.element.nonMobile;

import model.Penetrability;
import model.element.Sprite;

class Ball extends NonMobile {

    private static final Sprite SPRITE = new Sprite('[', "images/crystal_ball.png");

   
    Ball() {
        super(SPRITE, Penetrability.PENETRABLE);
    }
}