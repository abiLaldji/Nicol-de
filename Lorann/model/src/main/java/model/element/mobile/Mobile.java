package model.element.mobile;

import java.awt.Point;

import model.IMap;
import model.IMobile;
import model.Penetrability;
import model.element.Element;
import model.element.Sprite;
import showboard.IBoard;

public abstract class Mobile extends Element implements IMobile{

	private boolean alive = true;
	private Point position;
	private IMap map;
	private IBoard board;
	
	Mobile(final Sprite sprite, final IMap map, final Penetrability penetrability) {
        super(sprite, penetrability);
        this.setMap(map);
        this.position = new Point();
    }
	
	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Penetrability penetrability) {
        this(sprite, map, penetrability);
        this.setX(x);
        this.setY(y);
    }
	
	public void moveUp() {
		if (this.getY() != 0) {
			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
					.getPenetrability() == Penetrability.PENETRABLE) {
				this.setY(this.getY() - 1);
				this.setHasMoved();
			}
		}
		System.out.println(this.getY());
	}
	
	public void moveDown() {
		if (this.getY() != this.getMap().getHeight()) {
			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPenetrability() == Penetrability.PENETRABLE) {
				this.setY(this.getY() + 1);
				this.setHasMoved();
			}
		}
		System.out.println(this.getY());
	}
	
	public void moveLeft() {
		if (this.getX() != 0) {
			if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPenetrability() == Penetrability.PENETRABLE) {
				this.setX(this.getX() - 1);
				this.setHasMoved();
			}
		}
		System.out.println(this.getX());
	}
	
	public void moveRight() {
		if (this.getX() != this.getMap().getWidth()) {
			if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPenetrability() == Penetrability.PENETRABLE) {
				this.setX(this.getX() + 1);
				this.setHasMoved();
			}
		}
		System.out.println(this.getX());
	}
	
	public void moveUpRight() {
		this.setX(this.getX() + 1);
		this.setY(this.getY() - 1);
        this.setHasMoved();
	}
	
	public void moveUpLeft() {
		this.setX(this.getX() - 1);
		this.setY(this.getY() - 1);
        this.setHasMoved();

	}
	
	public void moveDownRight() {
		this.setX(this.getX() + 1);
		this.setY(this.getY() + 1);
        this.setHasMoved();

	}
	
	public void moveDownLeft() {
		this.setX(this.getX() - 1);
		this.setY(this.getY() + 1);
        this.setHasMoved();		
	}
	
	
	public void doNothing() {
        this.setHasMoved();
    }
	

	    private void setHasMoved() {
	        this.getMap().setMobileHasChanged();
	    }


	    public final int getX() {
	        return this.getPosition().x;
	    }

	    public final void setX(final int x) {
	        this.getPosition().x = x;
	        //if (this.isCrashed()) {
	        //    this.die();
	        //}
	    }

	    public final int getY() {
	        return this.getPosition().y;
	    }

	    public final void setY(final int y) {
	        this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
	        //if (this.isCrashed()) {
	        //    this.die();
	        //}
	    }

	
	    private void setMap(final IMap map) {
	        this.map = map;
	    }

	   
	    public boolean isAlive() {
	        return this.alive;
	    }


	    protected void die() {
	        this.alive = false;
	        this.setHasMoved();
	    }

	    //public Boolean isCrashed() {
	    //    return this.getRoad().getOnTheRoadXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
	    //}

	    public Point getPosition() {
	        return this.position;
	    }

	    public void setPosition(final Point position) {
	        this.position = position;
	    }

	 
	    public IMap getMap() {
	        return this.map;
	    }

		public IBoard getBoard() {
			return board;
		}

}


