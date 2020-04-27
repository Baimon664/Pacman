package entity;

import entity.base.MovingEntity;
import logic.Direction;


public class Pacman extends MovingEntity
{
	public Pacman() {
		setDirection(Direction.NONE);
	}
	@Override
	public int getSymbol()
	{
		return 0;
	}
	

}
