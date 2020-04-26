package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.Cell;
import logic.Direction;
import logic.GameController;
import logic.Sprites;

import java.util.ArrayList;

import application.DrawUtil;
import entity.base.Entity;
//import entity.base.Updatable;

public class Main extends Application
{

	private int board_width;
	private int board_height;

	private int draw_originx;
	private int draw_originy;

	private String[][] gameMap;
	
	private Thread t1;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		gameMap = CSVParser.readCSV("level.csv");

		GameController.IntializeMap(gameMap, 9, 15, 8, 9, 10, 9);
		board_width = GameController.getCurrentMap().getWidth() * 24;
		board_height = GameController.getCurrentMap().getHeight() * 24;

		draw_originx = 427 - board_width / 2;
		draw_originy = 240 - board_height / 2;

		StackPane root = new StackPane();

		Scene scene = new Scene(root, 854, 480);

		Canvas canvas = new Canvas(854, 480);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawGameBoard(gc);
		root.getChildren().add(canvas);

		// Register Event
		addEventListener(scene, gc);
		
		
		t1 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				while (true)
				{
					GameController.movePacman();
					GameController.moveGhost1();
					GameController.moveGhost2();
					ArrayList<Entity> allEntity = GameController.getCurrentMap().getAllEntity();
					Platform.runLater(new Runnable()
					{
						@Override
						public void run()
						{
							drawGameBoard(gc);
						}
					});
					try
					{
						Thread.sleep(200);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
        
        Thread t2 = new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                // TODO Auto-generated method stub
            	GameController.setSound("sound/pacman-die-sound.mp3");
            }
        });
        t2.start();
		
		///////////////////////menu/////////////////
		

		Pane menuPane = new Pane();
		BackgroundImage backgroundImage = new BackgroundImage(DrawUtil.getPacman_logo(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null);
		Background background = new Background(backgroundImage);
		menuPane.setBackground(background);
		Text start = new Text("Start");
		start.setStyle("-fx-font-size: 50px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
		start.setX(370);
		start.setY(250);
		Text exit = new Text("Exit");
		exit.setX(380);
		exit.setY(320);
		exit.setStyle("-fx-font-size: 50px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
		ImageView pacman_gif = DrawUtil.drawPacmanGif();
		pacman_gif.setScaleX(0.5);
		pacman_gif.setScaleY(0.5);
		pacman_gif.setX(200);
		pacman_gif.setY(300);
		menuPane.getChildren().addAll(start,exit,pacman_gif);
		
		start.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				primaryStage.setScene(scene);
				t1.start();
			}
		});
		
		start.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				start.setStyle("-fx-font-size: 50 px; -fx-font-family:\"Candara\";-fx-fill: #ffffff; -fx-font-weight:bold");
			}
		});
		
		start.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				start.setStyle("-fx-font-size: 50px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
			}
		});
		
		exit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Platform.exit();
				System.exit(0);
			}
		});
		
		exit.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				exit.setStyle("-fx-font-size: 50 px; -fx-font-family:\"Candara\";-fx-fill: #ffffff; -fx-font-weight:bold");
			}
		});
		
		exit.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				exit.setStyle("-fx-font-size: 50px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
			}
		});
		
		
		
		Scene menu = new Scene(menuPane,854,480);
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				Platform.exit();
				System.exit(0);
			}
		});
		primaryStage.setTitle("Pacman Za");
		primaryStage.setResizable(false);
		primaryStage.setScene(menu);
		primaryStage.show();

	}

	public static void main(String[] args)
	{
		launch(args);
	}

	private void drawGameBoard(GraphicsContext gc)
	{

		// Draw Background
		gc.setFill(Color.rgb(21, 24, 31));
		gc.fillRect(0, 0, 854, 480);

		// Draw Playable Field Background
		gc.setFill(Color.BLACK);
		gc.fillRect(draw_originx, draw_originy, board_width, board_height);

		Cell[][] gameBoard = GameController.getCurrentMap().getMap();

		int x = 0;
		int y = 0;

		for (Cell[] row : gameBoard)
		{
			x = 0;
			for (Cell c : row)
			{
				if (!c.IsEmpty())
				{
					DrawUtil.drawSprite(gc, draw_originx + x * 24, draw_originy + y * 24, c.getSymbol());
				}
				x += 1;
			}
			y += 1;
		}
		DrawUtil.drawSprite(gc, draw_originx + GameController.getGhost1X() * 24,
				draw_originy + GameController.getGhost1Y() * 24, GameController.getGhost1Sprite());
		DrawUtil.drawSprite(gc, draw_originx + GameController.getGhost2X() * 24,
				draw_originy + GameController.getGhost2Y() * 24, GameController.getGhost2Sprite());
		DrawUtil.drawSprite(gc, draw_originx + GameController.getPacmanX() * 24,
				draw_originy + GameController.getPacmanY() * 24, GameController.getPacmanSprite());
		// If lose, draw Congrats
		if (GameController.isGameLose())
		{
			// Darken the Screen
			GameController.setSound("sound/winning-sound.mp3");
			gc.setGlobalAlpha(0.8);
			gc.setFill(Color.BLACK);
			gc.fillRect(draw_originx, draw_originy, board_width, board_height);
			// Revert the Alpha
			gc.setGlobalAlpha(1);
			// Draw Congratulations
			DrawUtil.drawGameOver(gc, 427, 240);
			GameController.setPacmanDirection(Direction.NONE);
			GameController.setGhost1Direction(Direction.NONE);
			GameController.setGhost2Direction(Direction.NONE);
			t1.suspend();
		}
		// If win, draw Congrats
		if (GameController.getScore()==0)
		{
			// Darken the Screen
			GameController.setSound("sound/coin-eat-sound.mp3");
			gc.setGlobalAlpha(0.8);
			gc.setFill(Color.BLACK);
			gc.fillRect(draw_originx, draw_originy, board_width, board_height);
			// Revert the Alpha
			gc.setGlobalAlpha(1);
			// Draw Congratulations
			DrawUtil.drawCongrats(gc, 427, 240);
			GameController.setPacmanDirection(Direction.NONE);
			GameController.setGhost1Direction(Direction.NONE);
			GameController.setGhost2Direction(Direction.NONE);
		}
	}

	private void addEventListener(Scene s, GraphicsContext gc)
	{
		s.setOnKeyPressed((event) ->
		{
			// System.out.println("KeyPressed : " + event.getCode().toString());
			KeyCode keycode = event.getCode();
			if (!GameController.isGameWin())
			{
				switch (keycode)
				{
				case A:
					GameController.setPacmanDirection(Direction.LEFT);
					break;
				case D:
					GameController.setPacmanDirection(Direction.RIGHT);
					break;
				case W:
					GameController.setPacmanDirection(Direction.UP);
					break;
				case S:
					GameController.setPacmanDirection(Direction.DOWN);
					break;
				case R:
					GameController.IntializeMap(gameMap, 9, 15, 8, 9, 10, 9); // Reset Map
					t1.resume();
					break;
				default:
					System.out.println("Invalid Key.");
					break;
				}
			} else
			{
				Platform.exit();
				System.exit(0);
			}

			// ArrayList<Entity> allEntity = GameController.getCurrentMap().getAllEntity();
			// update here
			// drawGameBoard(gc);

		});
	}

}
