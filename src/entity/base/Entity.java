package entity.base;

import logic.Direction;
import logic.GameController;

public abstract class Entity {
	
	private int x;
	private int y;
	private Direction direction;
	
	public abstract int getSymbol();
	
	public void remove() {
		GameController.getCurrentMap().removeEntity(x,y);
	}
	
	public boolean move(Direction dir) {
		int targetx = x;
		int targety = y;
		
		direction = dir; //Update move position

		switch(dir) {
		case LEFT:
			targetx -= 1;
			break;
		case UP:
			targety -= 1;
			break;
		case RIGHT:
			targetx += 1;
			break;
		case DOWN:
			targety += 1;
			break;
		default:
			break;
		}
		
		if(GameController.getCurrentMap().isMovePossible(targetx, targety,this)) {
			GameController.getCurrentMap().removeEntity(x,y);
			GameController.getCurrentMap().addEntity(this, targetx, targety);
			return true;
		}else {
			return false;
		}
	}
	
	public Entity() {
		direction = Direction.NONE;
	}
	
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public boolean movePossible(Direction dir) {
		int targetx = x;
		int targety = y;
		
		direction = dir; //Update move position

		switch(dir) {
		case LEFT:
			targetx -= 1;
			break;
		case UP:
			targety -= 1;
			break;
		case RIGHT:
			targetx += 1;
			break;
		case DOWN:
			targety += 1;
			break;
		default:
			break;
		}
		if(GameController.getCurrentMap().isMovePossible(targetx, targety, this)) {
			return true;
		}return false;
	}
}

