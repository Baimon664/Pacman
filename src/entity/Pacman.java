package entity;

import entity.base.Entity;
import logic.Direction;
import logic.GameController;
import logic.Sprites;

public class Pacman extends Entity {
	private Direction face = Direction.RIGHT;

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
	
}
