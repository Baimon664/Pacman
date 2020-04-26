package entity.base;
import logic.GameController;

public abstract class Entity
{
	private int x;
	private int y;

	public abstract int getSymbol();
	
	public void remove() {
		GameController.getCurrentMap().removeEntity(x,y);
	}
	
   	public Entity() {}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
