package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import logic.Direction;

public class DrawUtil {

	private static String image_path = ClassLoader.getSystemResource("images/sprites_sheet1.png").toString();
	private static Image mainsprites = new Image(image_path);
	private static String pacman_gif_path = ClassLoader.getSystemResource("images/pacman-gif-20.gif").toString();
	private static Image pacman_gif = new Image(pacman_gif_path);
	private static String pacman_logo_path = ClassLoader.getSystemResource("images/logo2.png").toString();
	private static Image pacman_logo = new Image(pacman_logo_path);
	private static String pacman_level1_path = ClassLoader.getSystemResource("images/level1.jpg").toString();
	private static Image pacman_level1 = new Image(pacman_level1_path);
	private static String pacman_level2_path = ClassLoader.getSystemResource("images/level2.jpg").toString();
	private static Image pacman_level2 = new Image(pacman_level2_path);
	
	private static String congrat_path = ClassLoader.getSystemResource("images/congratulations.png").toString();
	private static Image congratsprites = new Image(congrat_path);
	private static String over_path = ClassLoader.getSystemResource("images/gameover.png").toString();
	private static Image oversprites = new Image(over_path);
	
	private static String pacmanR_path = ClassLoader.getSystemResource("images/pacmanRight.gif").toString();
	private static Image pacmanRsprites = new Image(pacmanR_path);
	private static String pacmanL_path = ClassLoader.getSystemResource("images/pacmanLeft.gif").toString();
	private static Image pacmanLsprites = new Image(pacmanL_path);
	private static String pacmanU_path = ClassLoader.getSystemResource("images/pacmanUp.gif").toString();
	private static Image pacmanUsprites = new Image(pacmanU_path);
	private static String pacmanD_path = ClassLoader.getSystemResource("images/pacmanDown.gif").toString();
	private static Image pacmanDsprites = new Image(pacmanD_path);
	
	private static String bluewall_path = ClassLoader.getSystemResource("images/bluewall.png").toString();
	private static Image bluewallsprites = new Image(bluewall_path);
	private static String point_path = ClassLoader.getSystemResource("images/point.png").toString();
	private static Image pointsprites = new Image(point_path);
	private static String powerUp_path = ClassLoader.getSystemResource("images/powerUp.png").toString();
	private static Image powerUpsprites = new Image(powerUp_path);
	
	private static String ghost1_path = ClassLoader.getSystemResource("images/ghost1.gif").toString();
	private static Image ghost1sprites = new Image(ghost1_path);
	private static String ghost2_path = ClassLoader.getSystemResource("images/ghost2.gif").toString();
	private static Image ghost2sprites = new Image(ghost2_path);
	private static String blueghost_path = ClassLoader.getSystemResource("images/blueghost.gif").toString();
	private static Image blueghostsprites = new Image(blueghost_path);
	private static String blinkghost_path = ClassLoader.getSystemResource("images/blinkghost.gif").toString();
	private static Image blinkghostsprites = new Image(blinkghost_path);
	
	public static void drawSprite(GraphicsContext gc,int x,int y,int index) {
		if(index==0) {
			gc.drawImage(pointsprites, x, y);
		}else if(index==1) {
			gc.drawImage(powerUpsprites, x, y);
		}else if(index==2) {
			gc.drawImage(blueghostsprites, x, y);
		}else if(index==3) {
			gc.drawImage(blinkghostsprites, x, y);
		}else if(index==4) {
			gc.drawImage(ghost1sprites, x, y);
		}else if(index==5) {
			gc.drawImage(ghost2sprites, x, y);
		}else if(index==6) {
			gc.drawImage(bluewallsprites, x, y);
		}
	}
	
	public static void drawCongrats(GraphicsContext gc,int x,int y) {
		//System.out.println(image_path);
		gc.drawImage(congratsprites, x-200, y-80);
	}
	
	public static void drawGameOver(GraphicsContext gc,int x,int y) {
		//System.out.println(image_path);
		gc.drawImage(oversprites, x-200, y-80);
	}
	public static void drawPacman(GraphicsContext gc,int x,int y,Direction dir) {
		if(dir==Direction.LEFT) {
			gc.drawImage(pacmanLsprites, x, y);
		}else if(dir==Direction.UP) {
			gc.drawImage(pacmanUsprites, x, y);
		}else if(dir==Direction.DOWN) {
			gc.drawImage(pacmanDsprites, x, y);
		}else{
			gc.drawImage(pacmanRsprites, x, y);
		}
	}
	
	public static ImageView drawPacmanGif() {
		ImageView image = new ImageView(pacman_gif);
		return image;
	}
	
	public static ImageView drawLevel1() {
		ImageView image = new ImageView(pacman_level1);
		return image;
	}
	
	public static ImageView drawLevel2() {
		ImageView image = new ImageView(pacman_level2);
		return image;
	}

	public static Image getPacman_logo() {
		return pacman_logo;
	}
}
