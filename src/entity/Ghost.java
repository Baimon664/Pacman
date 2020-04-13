package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class Ghost extends Entity implements Interactable
{

	@Override
	public boolean interact(Entity e)
	{
		if(GameController.isPowerUp() && e instanceof Pacman) {
			this.remove();
			//spawn new one
		}else if(e instanceof Pacman) {
			e.remove();
		}
		return true;
	}

	@Override
	public int getSymbol()
	{	
		if(GameController.isPowerUp()) {
			return Sprites.FLAG;
		}
		return Sprites.PLAYER;
	}

}
