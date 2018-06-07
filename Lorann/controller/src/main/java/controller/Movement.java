package controller;

import java.awt.Point;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Collision;
import model.IMap;
import model.IMobile;

public class Movement {

	int score = 0;

	private boolean hit = false;

	private IController controller;

	public Movement(ControllerFacade cont) {
		this.controller = cont;
	}

	public boolean hitMonster(int x, int y) {
		if (this.controller.getModel().getMonster().getPosition().equals(new Point(
				this.controller.getModel().getLorann().getX(), this.controller.getModel().getLorann().getY()))) {
			this.hit = true;
		}

		else if (this.controller.getModel().getMonster2().getPosition()
				.equals(new Point(this.controller.getModel().getLorann().getX() + x,
						this.controller.getModel().getLorann().getY() + y))) {
			this.hit = true;
		} else if (this.controller.getModel().getMonster3().getPosition()
				.equals(new Point(this.controller.getModel().getLorann().getX() + x,
						this.controller.getModel().getLorann().getY() + y))) {
			this.hit = true;
		} else if (this.controller.getModel().getMonster4().getPosition()
				.equals(new Point(this.controller.getModel().getLorann().getX() + x,
						this.controller.getModel().getLorann().getY() + y))) {
			this.hit = true;
		}
		return this.hit;
	}

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
