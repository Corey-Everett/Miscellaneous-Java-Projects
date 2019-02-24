package Lab8Graphics;
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
		
public class Lab8Interface extends Application {

	public void start (Stage primaryStage) {
		
		GridPane p = new GridPane();
		
		Text length = new Text("length");
		Text width = new Text("width");
		Text area = new Text("area");
		TextField lengthOf = new TextField();
		TextField widthOf = new TextField();
		TextField areaOf = new TextField();
		Button button = new Button("Compute Area");
		
		p.getChildren().addAll(length, width, area, lengthOf, widthOf, areaOf, button);
		
		GridPane.setConstraints(length, 1,1);   //Column, row
		GridPane.setConstraints(width, 1,2);
		GridPane.setConstraints(area, 1,3);
		GridPane.setConstraints(lengthOf, 2,1);
		GridPane.setConstraints(widthOf, 2,2);
		GridPane.setConstraints(areaOf, 2,3);
		GridPane.setConstraints(button, 2,4);
		
		
		
		button.setOnAction((event)-> {
			double l = Double.parseDouble(lengthOf.getText());
			double w = Double.parseDouble(widthOf.getText());
			String a = Double.toString(l*w);
			areaOf.setText(a);
		});
		
		Scene s = new Scene(p);
		
		primaryStage.setTitle("Rectangle");
        primaryStage.setScene(s);
        
     	primaryStage.show();
 
	
	}
	public static void main(String[] args) {

		launch(args);

	}

}