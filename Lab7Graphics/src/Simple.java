import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView; 

public class Simple extends Application 
{
	public void start(Stage primaryStage) 
	{
		ImageView image1 = new ImageView("WIT.jpg");
		 		 
		HBox p = new HBox(); 
		p.getChildren().add(image1);

		Scene s = new Scene(p);

		primaryStage.setTitle("WIT logo");
        primaryStage.setScene(s);
     	primaryStage.show();
	}

	public static void main (String [] args)
	{
		launch(args);
	}
}