package model.element.nonMobile;

public abstract class NonMobileFactory {
	
    private static final HBone hBone = new HBone();
    
    private static final VBone vBone = new VBone();

    private static final Bone bone = new Bone();

    private static final Ball ball = new Ball();

    private static final Purse purse = new Purse();
    
    private static final OpenDoor openDoor = new OpenDoor();
    
    private static final ClosedDoor closedDoor = new ClosedDoor();
    
    private static final Empty empty = new Empty();
    
    private static NonMobile[] nonMobile  = {
            hBone,
            vBone,
            bone,
            purse,
            ball,
            openDoor,
            closedDoor, 
            empty
            }; 

    public NonMobile createVBone() {
        return vBone;
    }
    
    public NonMobile createHBone() {
        return hBone;
    }
    
    public NonMobile createBone() {
        return bone;
    }
    
    public NonMobile createPurse() {
        return purse;
    }
    
    public NonMobile createOpenDoor() {
        return openDoor;
    }
    
    public NonMobile createClosedDoor() {
        return closedDoor;
    }
    
    public NonMobile createBall() {
        return ball;
    }
    
    public NonMobile createEmpty() {
        return empty;
    }
    
    public static NonMobile getFromFileSymbol(final char fileSymbol) {
        for (final NonMobile nonMobile : nonMobile) {
            if (nonMobile.getSprite().getConsoleImage() == fileSymbol) {
                return nonMobile;
            }
        }
        return empty;
    }
}
