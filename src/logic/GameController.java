package logic;

import java.util.Timer;
import java.util.TimerTask;

import entity.Pacman;
import javafx.application.Platform;

public class GameController {
	
	private static GameMap gameMap;
	
	private static Pacman pacman;
	
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
	
	public static void IntializeMap(String[][] map,int px,int py) {
		 pacman = new Pacman();
		 
		 setCoinCount(0);
		 setGameWin(false);
		 setPowerUp(false);
		 
		 gameMap = new GameMap(map);
		 
		 gameMap.addEntity(pacman, px, py);
		 
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
		pacman.setFace(dir);
	}
	
	public static Direction getPacmanFace() {
		return pacman.getFace();
		
	}
}