package Lab8Graphics;
//Name: Corey Everett
//Date: April 12th, 2018
//Program: Lab 8 Interface Part 2
//Purpose: Shows a GUI where people can display a team's name..

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
		
public class Lab8TeamLabel extends Application {

	public void start (Stage primaryStage) {
		
		GridPane p = new GridPane();
		
		Text michigan = new Text("Michigan");
		Text kansas = new Text("Kansas");
		Text villanova = new Text("Villanova");
		Text loyola = new Text("Loyola");
		
		ImageView michiganPicture = new ImageView("michigan.png");
		ImageView kansasPicture = new ImageView("kansas.png");
		ImageView villanovaPicture = new ImageView("villanova.png");
		ImageView loyolaPicture = new ImageView("loyola.png");
		
		Text shown = new Text("");
		
		ToggleGroup group = new ToggleGroup();
		RadioButton michiganButton = new RadioButton();
		RadioButton kansasButton = new RadioButton();
		RadioButton villanovaButton = new RadioButton();
		RadioButton loyolaButton = new RadioButton();
		
		michiganButton.setToggleGroup(group);
		kansasButton.setToggleGroup(group);
		villanovaButton.setToggleGroup(group);
		loyolaButton.setToggleGroup(group);
		
		loyolaButton.setOnAction((event) -> {
		shown.setText("Loyola Ramblers");
		});
		
		villanovaButton.setOnAction((event) -> {
		shown.setText("Villanova Villains");	
		});
		
		kansasButton.setOnAction((event) -> {
		shown.setText("Kansas Cowboys");	
		});
		
		michiganButton.setOnAction((event) -> {
		shown.setText("Michigan Manglers");		
		});
		
		p.getChildren().addAll(loyolaButton, michiganButton, villanovaButton, kansasButton, michigan, kansas, shown, villanova, loyola, loyolaPicture, michiganPicture, villanovaPicture, kansasPicture);
		
		GridPane.setConstraints(loyolaButton, 1,1);   //Column, row
		GridPane.setConstraints(michiganButton, 1,2);
		GridPane.setConstraints(villanovaButton, 1,3);
		GridPane.setConstraints(kansasButton, 1,4);
		GridPane.setConstraints(loyolaPicture, 2,1);
		GridPane.setConstraints(michiganPicture, 2,2);
		GridPane.setConstraints(villanovaPicture, 2,3);
		GridPane.setConstraints(kansasPicture, 2,4);
		GridPane.setConstraints(loyola, 3,1);
		GridPane.setConstraints(michigan, 3,2);
		GridPane.setConstraints(villanova, 3,3);
		GridPane.setConstraints(kansas, 3,4);
		GridPane.setConstraints(shown, 4, 4);
		
		Scene s = new Scene(p);
		
		primaryStage.setTitle("Team Label");
        primaryStage.setScene(s);
   	    primaryStage.show();

	
	}
	public static void main(String[] args) {

		launch(args);

	}

}