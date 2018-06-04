package model.element.nonMobile;

import model.Collision;
import model.element.Element;
import model.element.Sprite;

public abstract class NonMobile extends Element{
	
	NonMobile(final Sprite sprite, final Collision collision) {
        super(sprite, collision);
    }

}
