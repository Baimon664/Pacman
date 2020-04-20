package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.Direction;
import logic.GameController;
import logic.Sprites;

public class Ghost extends Entity implements Interactable
{
	private boolean isAlive = true;
	public Ghost() {
		this.setDirection(Direction.UP);
		
	}
	@Override
	public boolean interact(Entity e)
	{
		if(GameController.isPowerUp() && e instanceof Pacman) {
			this.remove();
			//this.isAlive = false;
			this.setX(8);
			this.setY(8);
			this.setDirection(Direction.UP);
			//spawn new one
		}else if(e instanceof Pacman) {
			e.remove();
			GameController.setLife(GameController.getLife()-1);
			GameController.setPacmanAlive(false);
		}else if(e instanceof Ghost) {
			return false;
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
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
