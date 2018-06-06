package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.Collision;
import model.IMap;
import model.IMobile;

public abstract class Movement {

	IController controller;

	int score = 0;

	public void move(int moveX, int moveY) throws IOException {
		if (this.getLorann().getY() != 0) {
			switch (this.getMap().getOnTheMapXY(this.getLorann().getX() + moveX, this.getLorann().getY() + moveY)
					.getCollision()) {
			case FREE:
				this.getLorann().setXY(this.getLorann().getX() + moveX, this.getLorann().getY() + moveY);
				this.setHasMoved();
				break;
			case COLLECTABLE:
				this.getLorann().collect(this.getLorann().getX() + moveX, this.getLorann().getY() + moveY);
				this.getLorann().setXY(this.getLorann().getX() + moveX, this.getLorann().getY() + moveY);
				this.setHasMoved();
				break;
			case KILL:
				die();
				break;
			case WIN:
				this.getLorann().setXY(this.getLorann().getX() + moveX, this.getLorann().getY() + moveY);
				this.setHasMoved();
				win();
				break;
			case OPENDOOR:
				openTheDoor(this.getLorann().getX() + moveX, this.getLorann().getY() + moveY);
				this.getLorann().setXY(this.getLorann().getX() + moveX, this.getLorann().getY() + moveY);
				this.setHasMoved();
				break;
			default:
				break;
			}
		}
	}

	public void doNothing() {
		this.setHasMoved();
	}

	private void setHasMoved() {
		this.controller.getModel().getMap().setMobileHasChanged();
	}

	public void win() {
		JOptionPane.showMessageDialog(null, "YOU WIN");
		JOptionPane.showMessageDialog(null, getScore());
		System.exit(0);
	}

	private void openTheDoor(int x, int y) throws IOException {
		this.getMap().setEmptyXY(x, y);
		this.getMap().getOnTheMapXY(x, y).setCollision(Collision.FREE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();

		for (int a = 0; a < this.getMap().getWidth(); a++) {
			for (int b = 0; b < this.getMap().getHeight(); b++) {

				if (this.getMap().getOnTheMapXY(a, b).getSprite().getConsoleImage() == ']') {

					this.getMap().setOpenDoor(x, y);
					this.getMap().getOnTheMapXY(a, b).getSprite().loadImage();
					this.getMap().getOnTheMapXY(a, b).setCollision(Collision.WIN);
				}
			}
		}
	}

	//public void fire() throws IOException {
	//	System.out.println("fire");
	//	this.controller.getModel().setSpell(new Spell(this.getX() + 1, this.getY(), this.getMap()));
	//	// this.getMap().getOnTheMapXY(this.getX() + x, this.getY() + y).move();
	//}




	protected void die() throws IOException {
		this.getLorann().setAlive(false);
		JOptionPane.showMessageDialog(null, "YOU DIED");
		System.exit(0);
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	private IMobile getLorann() {
		return this.controller.getModel().getLorann();
	}
	
	private IMap getMap() {
		return this.controller.getModel().getMap();
	}

}
