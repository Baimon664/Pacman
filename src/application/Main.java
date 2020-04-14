package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Cell;
import logic.Direction;
import logic.GameController;

import java.util.ArrayList;

import application.DrawUtil;
import entity.base.Entity;
//import entity.base.Updatable;

public class Main extends Application{

	private int board_width;
	private int board_height;
	
	private int draw_originx;
	private int draw_originy;
	
	private String[][] gameMap;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		gameMap = CSVParser.readCSV("level.csv");
		
		GameController.IntializeMap(gameMap,9,15,8,8,10,8);
		board_width = GameController.getCurrentMap().getWidth()*24;
		board_height = GameController.getCurrentMap().getHeight()*24;
		
		draw_originx = 427-board_width/2;
		draw_originy = 240-board_height/2;

		
		StackPane root = new StackPane();
		
		Scene scene = new Scene(root, 854,480);
		
		Canvas canvas = new Canvas(854,480);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawGameBoard(gc);
		root.getChildren().add(canvas);
		
		addEventListener(scene,gc);
		
		//Register Event
		AnimationTimer timer = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				GameController.movePacman(GameController.getPacmanFace());
				GameController.moveGhost1();
				GameController.moveGhost2();
				ArrayList<Entity> allEntity = GameController.getCurrentMap().getAllEntity();
				drawGameBoard(gc);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		timer.start();
		
		primaryStage.setTitle("Fucking Pacman");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	private void drawGameBoard(GraphicsContext gc) {
		
		//Draw Background
		gc.setFill(Color.rgb(21,24,31));
		gc.fillRect(0, 0, 854, 480);
		
		//Draw Playable Field Background
		gc.setFill(Color.BLACK);
		gc.fillRect(draw_originx, draw_originy, board_width, board_height);
		
		Cell[][] gameBoard = GameController.getCurrentMap().getMap();
		
		int x = 0;
		int y = 0;
		
		for(Cell[] row:gameBoard) {
			x = 0;
			for(Cell c:row) {
				if(!c.IsEmpty()) {
					DrawUtil.drawSprite(gc,draw_originx+x*24,draw_originy+y*24,c.getSymbol());
				}
				x+=1;
			}
			y+=1;
		}
		
		//If win, draw Congrats
		if(GameController.isGameWin()) {
			//Darken the Screen
			gc.setGlobalAlpha(0.8);
			gc.setFill(Color.BLACK);
			gc.fillRect(draw_originx, draw_originy, board_width, board_height);
			//Revert the Alpha
			gc.setGlobalAlpha(1);
			//Draw Congratulations
			DrawUtil.drawCongrats(gc, 427, 240);
		}
	}
	
	private void addEventListener(Scene s,GraphicsContext gc) {
		s.setOnKeyPressed((event) -> {
			//System.out.println("KeyPressed : " + event.getCode().toString());
			KeyCode keycode = event.getCode();
			if(!GameController.isGameWin()) {
			switch(keycode) {
			case A:
				GameController.setPacmanFace(Direction.LEFT);
				break;
			case D:
				GameController.setPacmanFace(Direction.RIGHT);
				break;
			case W:
				GameController.setPacmanFace(Direction.UP);
				break;
			case S:
				GameController.setPacmanFace(Direction.DOWN);
				break;
			case R:
				GameController.IntializeMap(gameMap,9,15,8,8,10,8); //Reset Map
				break;
			default:
				System.out.println("Invalid Key.");
				break;
			}
			}else {
				Platform.exit();
		        System.exit(0);
			}
						
			ArrayList<Entity> allEntity = GameController.getCurrentMap().getAllEntity();
			
//			for(Entity e:allEntity) {
//				if(e instanceof Updatable) {
//					((Updatable) e).update();
//				}
//			}
			
			drawGameBoard(gc);
		});
	}
	
}
