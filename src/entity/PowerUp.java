package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class PowerUp extends Entity implements Interactable
{

	@Override
	public boolean interact(Entity e)
	{
		if(e instanceof Pacman) {
			this.remove();
			GameController.setPowerUp(true);
			GameController.setPowerUpTimeCount(0);
		}
		return true;
	}

	@Override
	public int getSymbol()
	{
		return Sprites.POWERUP;
	}
	
}
