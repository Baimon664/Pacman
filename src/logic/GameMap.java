package logic;

import java.util.ArrayList;



import entity.Ghost;
import entity.Pacman;
import entity.Point;
import entity.PowerUp;
import entity.Wall;
import entity.base.Entity;
import entity.base.Interactable;
import entity.base.MovingEntity;

public class GameMap {

	private Cell[][] cellmap;
	private int width;
	private int height;
	private int allPoint;
	
	private ArrayList<Entity> allEntity;

	public GameMap(int column,int row) {
		
		allEntity = new ArrayList<Entity>();
		
		setWidth(column);
		setHeight(row);
		
		cellmap = new Cell[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				cellmap[i][j] = new Cell();
			}
		}
	}
	
	public GameMap(String[][] map) {
		
		allEntity = new ArrayList<Entity>();
		allPoint = 0;
		
		int column = map[0].length;
		int row = map.length;
		
		setWidth(column);
		setHeight(row);
		
		cellmap = new Cell[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				cellmap[i][j] = new Cell();
				switch(map[i][j]) {
				case "0":
					break;
				case "W":
					addEntity(new Wall(),j,i);
					break;
				case "P":
					addEntity(new Pacman(),j,i);
					break;
				case "G":
					addEntity(new Ghost(), j, i);
					break;
				case "U":
					addEntity(new PowerUp(), j, i);
					break;
				case "O":
					addEntity(new Point(), j, i);
					setAllPoint(getAllPoint()+1);
					break;
				default:
					System.out.println("Error parsing at position x = "+j+" y = "+i+".\nUnknown Object with Symbol "+map[i][j]);
					break;
				
				}
				
				
			}
		}
		
	}
	
	
	public void printMap() {
		for(Cell[] row: cellmap) {
			String rowstring = "";
			for(Cell c:row) {
				rowstring+=c.getSymbol()+" ";
			}
			System.out.println(rowstring);
		}
	}
	
	public Cell[][] getMap(){
		return cellmap;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean addEntity(Entity e,int x, int y) {
		allEntity.add(e);
		
		e.setX(x);
		e.setY(y);
		
		if(e instanceof MovingEntity) {
			System.out.println("stop thread duay");
			return true;
		}

		boolean b = cellmap[y][x].setEntity(e);
		
		return b;
	}
	
	public Entity getEntity(int x,int y) {
		return cellmap[y][x].getEntity();
	}
	
	public void removeEntity(int x, int y) {
		allEntity.remove(cellmap[y][x].getEntity());
		if(!(cellmap[y][x].getEntity() instanceof Ghost)) {
			cellmap[y][x].removeEntity();
		}
	}
	
	public boolean isMovePossible(int targetx,int targety,Entity e) {
		if(targetx<0||targetx>=width||targety<0||targety>=height) {
			 //If Out of bound, cannot move
			return false;
		}
		if(cellmap[targety][targetx].IsEmpty()) { 
			//If the target cell is empty
			return true;
		}else {
			Entity target = cellmap[targety][targetx].getEntity();
			//If target is Interactable, check the result of the interaction
			if(target instanceof Interactable) {
				Interactable t = (Interactable) target;
				return t.interact(e);
			}else {
				return false;
			}
		}
	}
	
	public ArrayList<Entity> getAllEntity() {
		return allEntity;
	}

	public int getAllPoint()
	{
		return allPoint;
	}

	public void setAllPoint(int allPoint)
	{
		this.allPoint = allPoint;
	}
	
	
}
