package Lab9FiremakingCalculator;
//Name: Corey Everett
//Date: April 23th, 2018
//Program: Lab 9 Interface.
//Purpose: This program shows three doors. You're supposed to choose the right door and this is random, if you do, you get it!

	import javafx.application.Application;
		import javafx.stage.Stage;
		import javafx.scene.Scene;
		import javafx.scene.control.Button;
		import javafx.scene.control.RadioButton;
		import javafx.scene.control.TextField;
		import javafx.scene.control.ToggleGroup;
		import javafx.scene.image.ImageView;
		import javafx.scene.layout.GridPane;
		import javafx.scene.text.Text;
		import java.util.Random;
		
public class Lab9FiremakingCalculator extends Application {

	public void start (Stage primaryStage) {
		
		//Initialize Variables
		
		GridPane p = new GridPane();
		
		Random rand = new Random();
		
		ImageView door1 = new ImageView("door.jpg");
		ImageView door2 = new ImageView("door.jpg");
		ImageView door3 = new ImageView("door.jpg");
		
		int doorNumber = rand.nextInt()*3;
		
		ToggleGroup group = new ToggleGroup();
		Button button = new Button("guess!");
		Text text1 = new Text("Did you get it right?");
		Text text2 = new Text("Door Guessing Game! Guess the door the thing is behind.");
		RadioButton button1 = new RadioButton();
		RadioButton button2 = new RadioButton();
		RadioButton button3 = new RadioButton();
		
		button1.setToggleGroup(group);
		button2.setToggleGroup(group);
		button3.setToggleGroup(group);
		
		System.out.print(doorNumber);
		
		p.getChildren().addAll(button, door1, door2, door3, text1, text2, button1, button2, button3);
		
		GridPane.setConstraints(button, 1,2);   //Column, row
		GridPane.setConstraints(door1, 1,2); 
		GridPane.setConstraints(door2, 1,2); 
		GridPane.setConstraints(door3, 1,2); 
		GridPane.setConstraints(text1, 1,3); 
		GridPane.setConstraints(text2, 1,1); 
		GridPane.setConstraints(button1, 1,2); 
		GridPane.setConstraints(button2, 1,2); 
		GridPane.setConstraints(button3, 1,2); 
		
		Scene s = new Scene(p);
		
		primaryStage.setTitle("Door game");
        primaryStage.setScene(s);
     	primaryStage.show();
	}
	public static void main(String[] args) {
		// Starts the graphics part of program
		launch(args);
	}
}