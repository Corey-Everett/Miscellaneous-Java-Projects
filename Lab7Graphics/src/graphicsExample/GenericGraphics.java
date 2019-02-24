package graphicsExample;
//Name: Corey Everett
//Date: April 12th, 2018
//Program: Lab 8 Interface Part 1
//Purpose: Shows a GUI you can determine the length and width of a rectangle..

	import javafx.application.Application;
		import javafx.stage.Stage;
		import javafx.scene.Scene;
		import javafx.scene.control.Button;
		import javafx.scene.control.TextField;
		import javafx.scene.image.ImageView;
		import javafx.scene.layout.GridPane;
		import javafx.scene.text.Text;
		
public class GenericGraphics extends Application {

	public void start (Stage primaryStage) {
		
		GridPane p = new GridPane();
		
		Button button = new Button("Generic Thing");
		
		p.getChildren().addAll(button);
		
		GridPane.setConstraints(button, 1,1);   //Column, row
		
		Scene s = new Scene(p);
		
		primaryStage.setTitle("Generic Thing");
        primaryStage.setScene(s);
     	primaryStage.show();
	}
	public static void main(String[] args) {
		// Starts the graphics part of program
		launch(args);
	}
}