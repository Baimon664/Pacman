package entity.base;

import logic.Direction;
import logic.GameController;

public abstract class MovingEntity extends Entity
{
	private Direction direction;
	
	public MovingEntity() {}
	
	public boolean move() {
		int targetx = getX();
		int targety = getY();

		switch(getDirection()) {
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
			GameController.getCurrentMap().addEntity(this, targetx, targety);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean movePossible() {
		int targetx = getX();
		int targety = getY();

		switch(getDirection()) {
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
			return true;}
		return false;
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public boolean movePossible(Direction dir) {
		int targetx = getX();
		int targety = getY();
		
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
