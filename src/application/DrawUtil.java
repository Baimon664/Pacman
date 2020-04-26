package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class DrawUtil {

	private static String image_path = ClassLoader.getSystemResource("images/sprites_sheet1.png").toString();
	private static Image mainsprites = new Image(image_path);
	
	private static String congrat_path = ClassLoader.getSystemResource("images/congratulations.png").toString();
	private static Image congratsprites = new Image(congrat_path);
	
	private static String over_path = ClassLoader.getSystemResource("images/gameover.png").toString();
	private static Image oversprites = new Image(over_path);
	
	private static String pacman_logo_path = ClassLoader.getSystemResource("images/logo2.png").toString();
	private static Image pacman_logo = new Image(pacman_logo_path);
	
	private static String pacman_gif_path = ClassLoader.getSystemResource("images/pacman-gif-20.gif").toString();
	private static Image pacman_gif = new Image(pacman_gif_path);
	
	
	public static void drawSprite(GraphicsContext gc,int x,int y,int index) {
		WritableImage img = new WritableImage(mainsprites.getPixelReader(),index*24,0,24,24);
		gc.drawImage(img, x, y);
	}
	
	public static void drawCongrats(GraphicsContext gc,int x,int y) {
		//System.out.println(image_path);
		gc.drawImage(congratsprites, x-200, y-80);
	}
	public static void drawGameOver(GraphicsContext gc,int x,int y) {
		//System.out.println(image_path);
		gc.drawImage(oversprites, x-200, y-80);
	}
	
	public static ImageView drawPacmanGif() {
		ImageView a = new ImageView(pacman_gif);
		return a;
	}

	public static Image getPacman_logo() {
		return pacman_logo;
	}
	
}
