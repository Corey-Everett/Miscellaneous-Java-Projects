//Name: Corey Everett
//Date: March 27th, 2018
//Program: Stoplight Program
//Purpose: To display a stoplight using Java.

		

		import javafx.application.Application;
		import javafx.stage.Stage;
		import javafx.scene.Scene;
		import javafx.scene.layout.VBox;
		import javafx.geometry.Pos;
		import javafx.scene.shape.Circle;
		import javafx.scene.paint.*;
		
public class Lab7GraphicsStoplight extends Application {

	public void start(Stage primaryStage) 
	{
		Circle red = new Circle(40.0, Paint.valueOf("Red"));
		Circle yellow = new Circle(40.0, Paint.valueOf("Yellow"));
		Circle green = new Circle(40.0, Paint.valueOf("Green"));
		
	    
		 		 
		VBox p = new VBox(12.0); p.setAlignment(Pos.CENTER);

		p.getChildren().add(red);
		p.getChildren().add(yellow);
		p.getChildren().add(green);

		Scene s = new Scene(p);

		primaryStage.setTitle("WIT logo");
        primaryStage.setScene(s);
     	primaryStage.show();
	}
	
	public static void main (String [] args)   {
				
		launch(args);
				
	}
		
}


