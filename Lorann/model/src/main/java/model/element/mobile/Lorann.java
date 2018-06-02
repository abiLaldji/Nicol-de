package model.element.mobile;

import java.io.IOException;

import model.IMap;
import model.Penetrability;
import model.element.Sprite;

public class Lorann extends Mobile{
	
    private static final Sprite spriteU = new Sprite('L', "image/lorann_u.png");
    
    private static final Sprite spriteBL = new Sprite('L', "image/lorann_bl.png");
    
    private static final Sprite spriteBR = new Sprite('L', "image/lorann_br.png");
    
    private static final Sprite spriteL = new Sprite('L', "image/lorann_l.png");
    
    private static final Sprite spriteB = new Sprite('L', "image/lorann_b.png");
    
    private static final Sprite spriteR = new Sprite('L', "image/lorann_br.png");
    
    private static final Sprite spriteUL = new Sprite('L', "image/lorann_ul.png");
    
    private static final Sprite spriteUR = new Sprite('L', "image/lorann_up.png");
     
   
    public Lorann(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteU, map, Penetrability.BLOCKING);
        spriteU.loadImage();
        spriteB.loadImage();
        spriteL.loadImage();
        spriteR.loadImage();
        spriteUR.loadImage();
        spriteUL.loadImage();
        spriteBL.loadImage();
        spriteBR.loadImage();

        
    }

    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteL);
    }
    
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteR);
    }
    
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteU);
    }
    
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteB);
    }
    
    public final void moveUpLeft() {
        super.moveUpLeft();
        this.setSprite(spriteUL);
    }
    
    public final void moveUpRight() {
        super.moveUpRight();
        this.setSprite(spriteUR);
    }
    
    public final void moveDownRight() {
        super.moveDownRight();
        this.setSprite(spriteBR);
    }
    
    public final void moveDownLeft() {
        super.moveDownLeft();
        this.setSprite(spriteBL);
    }
    
    public final void doNothing() {
        super.doNothing();
        this.setSprite(spriteU);
    }
    
}
