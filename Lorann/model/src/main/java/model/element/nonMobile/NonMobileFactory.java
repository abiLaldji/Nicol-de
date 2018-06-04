package model.element.nonMobile;

public abstract class NonMobileFactory {

	private static final HBone H_BONE = new HBone();

	private static final VBone V_BONE = new VBone();

	private static final Bone BONE = new Bone();

	private static final Ball BALL = new Ball();

	private static final Purse PURSE = new Purse();

	private static final OpenDoor OPEN_DOOR = new OpenDoor();

	private static final ClosedDoor CLOSED_DOOR = new ClosedDoor();

	private static final Empty EMPTY = new Empty();

	private static NonMobile[] nonMobile = { H_BONE, V_BONE, BONE, PURSE, BALL, OPEN_DOOR, CLOSED_DOOR, EMPTY };

	public NonMobile createVBone() {
		return V_BONE;
	}

	public NonMobile createHBone() {
		return H_BONE;
	}

	public NonMobile createBone() {
		return BONE;
	}

	public NonMobile createPurse() {
		return PURSE;
	}

	public NonMobile createOpenDoor() {
		return OPEN_DOOR;
	}

	public NonMobile createClosedDoor() {
		return CLOSED_DOOR;
	}

	public NonMobile createBall() {
		return BALL;
	}

	public NonMobile createEmpty() {
		return EMPTY;
	}

	public static NonMobile getFromFileSymbol(final char fileSymbol) {
		for (final NonMobile nonMobile : nonMobile) {
			if (nonMobile.getSprite().getConsoleImage() == fileSymbol) {
				return nonMobile;
			}
		}
		return EMPTY;
	}
}
