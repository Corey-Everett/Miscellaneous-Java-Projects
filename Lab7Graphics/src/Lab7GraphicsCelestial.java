

import javafx.application.Application;
		import javafx.stage.Stage;
		import javafx.scene.Scene;
		import javafx.scene.image.ImageView;
		import javafx.scene.layout.GridPane;
		
public class Lab7GraphicsCelestial extends Application {

	
	public void start (Stage primaryStage) {
	
		ImageView star = new ImageView("star.png");
		ImageView star1 = new ImageView("star.png");
		ImageView star2 = new ImageView("star.png");
		ImageView star3 = new ImageView("star.png");
		ImageView star4 = new ImageView("star.png");
		ImageView star5 = new ImageView("star.png");
		ImageView moon = new ImageView("moon.png");
		
		GridPane p = new GridPane();
		
		
		GridPane.setConstraints(star, 0,1);   //Column, row
		GridPane.setConstraints(star1, 0,2);
		GridPane.setConstraints(star2, 1,2);
		GridPane.setConstraints(star3, 2,0);
		GridPane.setConstraints(star4, 2,2);
		GridPane.setConstraints(star5, 2,1);
		GridPane.setConstraints(moon, 1,1);
	
		p.getChildren().addAll(star, star1, star2, star3, star4, star5, moon);
		
		Scene s = new Scene(p);

		primaryStage.setTitle("Galaxy");
        primaryStage.setScene(s);
     	primaryStage.show();
	}
	
	
	public static void main(String[] args) {

		launch(args);

	}

}
