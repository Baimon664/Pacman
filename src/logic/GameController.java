package logic;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import entity.Ghost;
import entity.Pacman;
import javafx.application.Platform;

public class GameController {
	
	private static GameMap gameMap;
	
	private static Pacman pacman;
	
	private static Ghost ghost1;
	
	private static Ghost ghost2;
	
	private static boolean pacmanAlive = true;
	
	private static int life;
	
	private static int coin_count;
	
	private static boolean win;
	
	private static boolean lose;
	
	private static boolean powerUp;
	
	public static final int MAX_COOLDOWN_TIME = 11;
	
	private static Timer timer;
	final private static double FRAMES_PER_SECOND = 5.0;
	
	private static void update(Direction dir) {
		pacman.step(dir);
	}
	
//	private static void startTimer() {
//		 timer = new java.util.Timer();
//	     TimerTask timerTask = new TimerTask() {
//	            public void run() {
//	                Platform.runLater(new Runnable() {
//	                    public void run() {
//	                        update(pacman.getFace());
//	                    }
//	                });
//	            }
//	        };
//
//	        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
//	        timer.schedule(timerTask, 0, frameTimeInMilliseconds);
//	}
	
	public static void IntializeMap(String[][] map,int px,int py,int g1x ,int g1y,int g2x,int g2y) {
		if(GameController.isPacmanAlive()==true) {
			 pacman = new Pacman();
			 ghost1 = new Ghost();
			 ghost2 = new Ghost();
			 life = 3;
			 
			 setCoinCount(0);
			 setGameWin(false);
			 setPowerUp(false);
			 
			 gameMap = new GameMap(map);
			 
			 gameMap.addEntity(pacman, px, py);
			 gameMap.addEntity(ghost1, g1x, g1y);
			 gameMap.addEntity(ghost2, g2x, g2y);
		}else {
			pacman.remove();
			ghost1.remove();
			ghost2.remove();
//			pacman = new Pacman();
//			ghost1 = new Ghost();
//			ghost2 = new Ghost();
			gameMap.addEntity(pacman, px, py);
			gameMap.addEntity(ghost1, g1x, g1y);
			gameMap.addEntity(ghost2, g2x, g2y);
			GameController.setPacmanAlive(true);
		}
		 
		 //startTimer();
	}
	
	public static void printMap() {
		gameMap.printMap();
	}
	
	public static GameMap getCurrentMap() {
		return gameMap;
	}
	
	public static void movePacman(Direction dir) {
		pacman.move(dir);
	}

	public static int getCoinCount() {
		return coin_count;
	}

	public static void setCoinCount(int coin_count) {
		GameController.coin_count = coin_count;
	}
	
	public static void addCoinCount(int coin_count) {
		GameController.coin_count += coin_count;
	}

	public static boolean isGameWin() {
		return win;
	}

	public static void setGameWin(boolean is_win) {
		GameController.win = is_win;
	}
	
	
	public static boolean isGameLose()
	{
		return lose;
	}

	public static void setGameLose(boolean is_lose)
	{
		GameController.lose = is_lose;
	}

	public static boolean isPowerUp() {
		return powerUp;
	}

	public static void setPowerUp(boolean PowerUp) {
		GameController.powerUp = PowerUp;
	}
	
	public static void setPacmanFace(Direction dir) {
		if(pacman.movePossible(dir)) {
			pacman.setFace(dir);
		}
	}
	
	public static Direction getPacmanFace() {
		return pacman.getFace();
	}
	public static Direction getGhost1Direction() {
		return ghost1.getDirection();
	}
	public static Direction getGhost2Direction() {
		return ghost2.getDirection();
	}
	public static void setGhost1Direction(Direction dir) {
		ghost1.setDirection(dir);
	}
	
	public static void setGhost2Direction(Direction dir) {
		ghost2.setDirection(dir);
	}
	
	public static void moveGhost1R() {
		Random r = new Random();
		if (!ghost1.movePossible(getGhost1Direction())) {
			if(r.nextInt(4)==0) {
				ghost1.move(Direction.DOWN);
			}
			else if(r.nextInt(4)==1) {
				ghost1.move(Direction.UP);
			}
			else if(r.nextInt(4)==2) {
				ghost1.move(Direction.LEFT);
			}
			else if(r.nextInt(4)==4) {
				ghost1.move(Direction.RIGHT);
			}
		}
		ghost1.move(getGhost1Direction());
	}
	
	public static void moveGhost1() {
		if (ghost1.getX()==pacman.getX()) {
			if(ghost1.getY()>pacman.getY()) {
				setGhost1Direction(Direction.UP);
			}else {
				setGhost1Direction(Direction.DOWN);
			}
		}else if(ghost1.getY()==pacman.getY()) {
			if(ghost1.getX()>pacman.getX()) {
				setGhost1Direction(Direction.LEFT);
			}else {
				setGhost1Direction(Direction.RIGHT);
			}
		}
		moveGhost1R();
	}
	
	public static void moveGhost2R() {
		Random r = new Random();
		if (!ghost2.movePossible(getGhost2Direction())) {
			if(r.nextInt(4)==0) {
				ghost2.move(Direction.DOWN);
			}
			else if(r.nextInt(4)==1) {
				ghost2.move(Direction.UP);
			}
			else if(r.nextInt(4)==2) {
				ghost2.move(Direction.LEFT);
			}
			else if(r.nextInt(4)==4) {
				ghost2.move(Direction.RIGHT);
			}
		}
		ghost2.move(getGhost2Direction());
	}
	
	public static void moveGhost2() {
		if (ghost2.getX()==pacman.getX()) {
			if(ghost2.getY()>pacman.getY()) {
				setGhost2Direction(Direction.UP);
			}else {
				setGhost2Direction(Direction.DOWN);
			}
		}else if(ghost2.getY()==pacman.getY()) {
			if(ghost2.getX()>pacman.getX()) {
				setGhost2Direction(Direction.LEFT);
			}else {
				setGhost2Direction(Direction.RIGHT);
			}
		}
		moveGhost2R();
	}

	public static boolean isGhost1IsAlive() {
		return ghost1.isAlive();
	}

	public static boolean isGhost2IsAlive() {
		return ghost2.isAlive();
	}

	public static int getLife() {
		return life;
	}

	public static void setLife(int life) {
		GameController.life = life;
	}

	public static boolean isPacmanAlive() {
		return pacmanAlive;
	}

	public static void setPacmanAlive(boolean pacmanAlive) {
		GameController.pacmanAlive = pacmanAlive;
	}
	
}