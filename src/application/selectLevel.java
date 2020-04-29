package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import logic.GameController;

public class selectLevel {
	private static Scene selectLevel;
	
	public static void selectLevelScene() {
		Pane root = new Pane();
		root.setStyle("-fx-background-color:black");
		ImageView level1 = DrawUtil.drawLevel1();
		level1.setFitHeight(200);
		level1.setFitWidth(190.94);
		level1.setX(150);
		level1.setY(100);
		Text level1Text = new Text("Level1");
		level1Text.setStyle(
				"-fx-font-size: 30 px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
		level1Text.setX(210);
		level1Text.setY(350);
		level1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Sound.stopIntroSound();
				Level1.level1Scene();
				Main.getWindow().setScene(Level1.getScene());
				Level1.startUpdate();
			}
		});
		level1Text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Sound.stopIntroSound();
				Level1.level1Scene();
				Main.getWindow().setScene(Level1.getScene());
				Level1.startUpdate();
			}
		});
		level1Text.setOnMouseEntered(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				level1Text.setStyle(
						"-fx-font-size: 30 px; -fx-font-family:\"Candara\";-fx-fill: #ffffff; -fx-font-weight:bold");
			}
		});

		level1Text.setOnMouseExited(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				level1Text.setStyle(
						"-fx-font-size: 30px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
			}
		});
		ImageView level2 = DrawUtil.drawLevel2();
		level2.setFitHeight(200);
		level2.setFitWidth(292.86);
		level2.setX(450);
		level2.setY(100);
		Text level2Text = new Text("Level2");
		level2Text.setStyle(
				"-fx-font-size: 30 px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
		level2Text.setX(561);
		level2Text.setY(350);
		level2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Sound.stopIntroSound();
				Level2.level2Scene();
				Main.getWindow().setScene(Level2.getScene());
				Level2.startUpdate();
			}
		});
		level2Text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Sound.stopIntroSound();
				Level2.level2Scene();
				Main.getWindow().setScene(Level2.getScene());
				Level2.startUpdate();
			}
		});
		level2Text.setOnMouseEntered(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				level2Text.setStyle(
						"-fx-font-size: 30 px; -fx-font-family:\"Candara\";-fx-fill: #ffffff; -fx-font-weight:bold");
			}
		});

		level2Text.setOnMouseExited(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				level2Text.setStyle(
						"-fx-font-size: 30px; -fx-font-family:\"Candara\";-fx-fill: #ffd300; -fx-font-weight:bold");
			}
		});
		
		root.getChildren().addAll(level1,level2,level1Text,level2Text);
		
		selectLevel = new Scene(root, 854, 480);
	}

	public static Scene getSelectLevel() {
		return selectLevel;
	}
	
}
