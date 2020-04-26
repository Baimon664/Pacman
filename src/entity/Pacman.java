package entity;

import entity.base.MovingEntity;
import logic.Direction;
import logic.GameController;
import logic.Sprites;

public class Pacman extends MovingEntity
{
	private boolean animation = true;
	public Pacman() {
		setDirection(Direction.NONE);
	}
	@Override
	public int getSymbol()
	{
//		if(GameController.isPowerUp()) {
//			return Sprites.COMPACTOR_ON;
//		}
//		return Sprites.COMPACTOR_OFF;
		if(animation == true) {
			return Sprites.PLAYER;
		}else if(getDirection()==Direction.UP) {
			return Sprites.PLAYERUP;
		}else if(getDirection()==Direction.DOWN) {
			return Sprites.PLAYERDOWN;
		}else if(getDirection()==Direction.RIGHT) {
			return Sprites.PLAYERRIGHT;
		}else {
			return Sprites.PLAYERLEFT;
		}
		
	}
	public boolean isAnimation() {
		return animation;
	}
	public void setAnimation(boolean animation) {
		this.animation = animation;
	}
	

}
