package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.Direction;
import logic.GameController;
import logic.Sprites;

public class Pacman extends Entity implements Interactable {
	private Direction face = Direction.NONE;

	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		if(GameController.isPowerUp()) {
			return Sprites.COMPACTOR_ON;
		}
		return Sprites.COMPACTOR_OFF;
	}
	
	public boolean step(Direction dir) {
		this.move(dir);
		return true;
	}

	public Direction getFace() {
		return face;
	}

	public void setFace(Direction face) {
		this.face = face;
	}

	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if(e instanceof Ghost && GameController.isPowerUp() == false) {
			this.remove();
			GameController.setLife(GameController.getLife()-1);
			GameController.setPacmanAlive(false);
		}else if(e instanceof Ghost && GameController.isPowerUp() == true) {
			e.remove();
			e.setX(8);
			e.setY(8);
		}
		return true;
	}
	
}
