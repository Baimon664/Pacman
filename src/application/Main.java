package application;



import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.GameController;

import application.DrawUtil;
import application.selectLevel;;
//import entity.base.Updatable;

public class Main extends Application
{
	private static Stage window;
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
///////////////////////menu/////////////////
		Sound.playIntroSound();
		Pane menuPane = new Pane();
		BackgroundImage backgroundImage = new BackgroundImage(DrawUtil.getPacman_logo(), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, null, null);
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
		menuPane.getChildren().addAll(start, exit, pacman_gif);

		start.setOnMouseClicked(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				selectLevel.selectLevelScene();
				window.setScene(selectLevel.getSelectLevel());
			}
		});

		start.setOnMouseEntered(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				start.setStyle(
						"-fx-font-size: 50 px; -fx-font-family:\"Candara\";-fx-fill: #ffffff; -fx-font-weight:bold");
			}
		});

		start.setOnMouseExited(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				start.setStyle(
						"-fx-font-size: 50px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
			}
		});

		exit.setOnMouseClicked(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				Platform.exit();
				System.exit(0);
			}
		});

		exit.setOnMouseEntered(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				exit.setStyle(
						"-fx-font-size: 50 px; -fx-font-family:\"Candara\";-fx-fill: #ffffff; -fx-font-weight:bold");
			}
		});

		exit.setOnMouseExited(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				exit.setStyle(
						"-fx-font-size: 50px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
			}
		});

		Scene menu = new Scene(menuPane, 854, 480);

		window.setOnCloseRequest(new EventHandler<WindowEvent>()
		{

			@Override
			public void handle(WindowEvent arg0)
			{
				// TODO Auto-generated method stub
				Platform.exit();
				System.exit(0);
			}
		});

		window.setTitle("Pacman Zaa");
		window.setResizable(false);
		window.setScene(menu);
		window.show();

	}

	public static void main(String[] args)
	{
		launch(args);
	}

	public static Stage getWindow() {
		return window;
	}

	
}
