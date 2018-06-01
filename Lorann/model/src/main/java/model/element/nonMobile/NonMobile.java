package model.element.nonMobile;

import model.Penetrability;
import model.element.Element;
import model.element.Sprite;

public abstract class NonMobile extends Element{
	
	NonMobile(final Sprite sprite, final Penetrability penetrability) {
        super(sprite, penetrability);
    }

}
