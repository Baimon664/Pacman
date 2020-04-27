package logic;

import java.util.Random;

import entity.Ghost;
import entity.Pacman;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameController
{

	private static GameMap gameMap;

	private static Pacman pacman;
	private static Ghost ghost1;
	private static Ghost ghost2;

	private static int score;

	private static boolean win;

	private static boolean lose;

	private static boolean PowerUp;
	private static int powerUpTimeCount;
	private static int powerupCount;

	private static MediaPlayer mediaPlayer;

	public static void IntializeMap(String[][] map, int px, int py, int g1x, int g1y, int g2x, int g2y)
	{
		pacman = new Pacman();
		ghost1 = new Ghost();
		ghost2 = new Ghost();

		setGameWin(false);
		setPowerUp(false);
		setPowerUpTimeCount(0);
		setPowerupCount(0);
		setGameLose(false);

		gameMap = new GameMap(map);
		setScore(gameMap.getAllPoint());

		gameMap.addEntity(pacman, px, py);
		gameMap.addEntity(ghost1, g1x, g1y);
		gameMap.addEntity(ghost2, g2x, g2y);
	}

	public static void printMap()
	{
		gameMap.printMap();
	}

	public static GameMap getCurrentMap()
	{
		return gameMap;
	}

	public static void movePacman()
	{
		if(GameController.getPacmanDirection() != Direction.NONE) {
			GameController.setSound("sound/coin-eat-sound.mp3");
		}
		pacman.move();

	}
	
	public static boolean killcheck() {
		if(powerUpTimeCount==50*getPowerupCount()) {
			setPowerUp(false);
			setPowerUpTimeCount(0);
			setPowerupCount(0);
		}
		if (isPowerUp())
		{
			setPowerUpTimeCount(getPowerUpTimeCount()+1);
			if (getPacmanX() == getGhost1X() && getPacmanY() == getGhost1Y())
			{
				ghost1.dead();
				return true;
			}
			if (getPacmanX() == getGhost2X() && getPacmanY() == getGhost2Y())
			{
				ghost2.dead();
				return true;
			}
			
		}else
		{
			if (getPacmanX() == getGhost1X() && getPacmanY() == getGhost1Y())
			{
				setGameLose(true);
				return true;
			}
			if (getPacmanX() == getGhost2X() && getPacmanY() == getGhost2Y())
			{
				setGameLose(true);
				return true;
			}
		}
		return false;
		
		}
	
	public static void moveGhost1()
	{
		if(isPowerUp() == false) {
			if (ghost1.getX() == pacman.getX())
			{
				if (ghost1.getY() > pacman.getY())
				{
					setGhost1Direction(Direction.UP);
				} else
				{
					setGhost1Direction(Direction.DOWN);
				}
			} else if (ghost1.getY() == pacman.getY())
			{
				if (ghost1.getX() > pacman.getX())
				{
					setGhost1Direction(Direction.LEFT);
				} else
				{
					setGhost1Direction(Direction.RIGHT);
				}
			}
		}else {
			if (ghost1.getX() == pacman.getX())
			{
				if (ghost1.getY() > pacman.getY())
				{
					setGhost1Direction(Direction.DOWN);
				} else
				{
					setGhost1Direction(Direction.UP);
				}
			} else if (ghost1.getY() == pacman.getY())
			{
				if (ghost1.getX() > pacman.getX())
				{
					setGhost1Direction(Direction.RIGHT);
				} else
				{
					setGhost1Direction(Direction.LEFT);
				}
			}
		}
		moveGhost1R();
	}

	public static void moveGhost1R()
	{
		Random r = new Random();
		while (!ghost1.movePossible())
		{
			if (r.nextInt(4) == 0)
			{
				setGhost1Direction(Direction.UP);
			} else if (r.nextInt(4) == 1)
			{
				setGhost1Direction(Direction.DOWN);
			} else if (r.nextInt(4) == 2)
			{
				setGhost1Direction(Direction.LEFT);
			} else if (r.nextInt(4) == 3)
			{
				setGhost1Direction(Direction.RIGHT);
			}
		}
		ghost1.move();

	}

	public static void moveGhost2()
	{
		if(isPowerUp() == false) {
			if (ghost2.getX() == pacman.getX())
			{
				if (ghost2.getY() > pacman.getY())
				{
					setGhost2Direction(Direction.UP);
				} else
				{
					setGhost2Direction(Direction.DOWN);
				}
			} else if (ghost2.getY() == pacman.getY())
			{
				if (ghost2.getX() > pacman.getX())
				{
					setGhost2Direction(Direction.LEFT);
				} else
				{
					setGhost2Direction(Direction.RIGHT);
				}
			}
		}else {
			if (ghost2.getX() == pacman.getX())
			{
				if (ghost2.getY() > pacman.getY())
				{
					setGhost2Direction(Direction.DOWN);
				} else
				{
					setGhost2Direction(Direction.UP);
				}
			} else if (ghost2.getY() == pacman.getY())
			{
				if (ghost2.getX() > pacman.getX())
				{
					setGhost2Direction(Direction.RIGHT);
				} else
				{
					setGhost2Direction(Direction.LEFT);
				}
			}
		}
		moveGhost2R();
	}

	public static void moveGhost2R()
	{
		Random r = new Random();
		while (!ghost2.movePossible())
		{
			if (r.nextInt(4) == 0)
			{
				setGhost2Direction(Direction.DOWN);
			} else if (r.nextInt(4) == 1)
			{
				setGhost2Direction(Direction.UP);
			} else if (r.nextInt(4) == 2)
			{
				setGhost2Direction(Direction.LEFT);
			} else if (r.nextInt(4) == 3)
			{
				setGhost2Direction(Direction.RIGHT);
			}
		}
		ghost2.move();
	}

	public static Direction getPacmanDirection()
	{
		return pacman.getDirection();
	}

	public static void setPacmanDirection(Direction dir)
	{
		pacman.setDirection(dir);
	}

	public static Direction getGhost1Direction()
	{
		return ghost1.getDirection();
	}

	public static void setGhost1Direction(Direction dir)
	{
		ghost1.setDirection(dir);
	}

	public static Direction getGhost2Direction()
	{
		return ghost2.getDirection();
	}

	public static int getGhost1X()
	{
		return ghost1.getX();
	}

	public static int getGhost2X()
	{
		return ghost2.getX();
	}

	public static int getGhost1Y()
	{
		return ghost1.getY();
	}

	public static int getGhost2Y()
	{
		return ghost2.getY();
	}

	public static int getPacmanX()
	{
		return pacman.getX();
	}

	public static int getPacmanY()
	{
		return pacman.getY();
	}

	public static int getGhost1Sprite()
	{
		return ghost1.getSymbol();
	}

	public static int getGhost2Sprite()
	{
		return ghost2.getSymbol2();
	}

	public static void setGhost2Direction(Direction dir)
	{
		ghost2.setDirection(dir);
	}

	public static int getScore()
	{
		return score;
	}

	public static void setScore(int score)
	{
		GameController.score = score;
	}

	public static boolean isGameWin()
	{
		return win;
	}

	public static void setGameWin(boolean is_win)
	{
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

	public static boolean isPowerUp()
	{
		return PowerUp;
	}

	public static void setPowerUp(boolean PowerUp)
	{
		GameController.PowerUp = PowerUp;
	}

	public static int getPowerUpTimeCount()
	{
		return powerUpTimeCount;
	}

	public static void setPowerUpTimeCount(int powerUpTimeCount)
	{
		GameController.powerUpTimeCount = powerUpTimeCount;
	}

	public static int getPowerupCount()
	{
		return powerupCount;
	}

	public static void setPowerupCount(int powerupCount)
	{
		GameController.powerupCount = powerupCount;
	}
	public static void setSound(String name) {
		String sound_path = ClassLoader.getSystemResource(name).toString();
		Media media = new Media(sound_path);
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.1);
		mediaPlayer.setAutoPlay(true);
	}
	public static void stopSound() {
		mediaPlayer.stop();
	}
	

}
