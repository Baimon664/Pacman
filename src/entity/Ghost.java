package entity;

import entity.base.MovingEntity;
import logic.Direction;
import logic.GameController;
import logic.Sprites;

public class Ghost extends MovingEntity
{
	public boolean dead() {
		this.setX(8);
		this.setY(10);
		setDirection(Direction.UP);
		return true;
	}
	
	public Ghost() {
		setDirection(Direction.UP);
	}
	
	@Override
	public int getSymbol()
	{	
		if(GameController.isPowerUp()) {
			return Sprites.GHOSTEAT;
		}
		return Sprites.GHOST;
	}

}
