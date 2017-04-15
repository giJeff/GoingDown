package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** Class : GameUI.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Mar 24, 2017
 *
 * This class demonstrates Java FX with the DB Tutorial
 *
 */
public class GameUI extends Application
{

	/** Method: start
	 * Purpose: start of the Game Demo application 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		try
		{
			FXMLLoader root = new FXMLLoader();
			root.setLocation(GameUI.class.getResource("GameUI.fxml"));
			GridPane rootLayout = (GridPane)root.load();
			Scene scene = new Scene(rootLayout, 500, 250);
			scene.getStylesheets().add(getClass().getResource("game.css").toExternalForm());
			primaryStage.setTitle("Game Demo");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch (Exception e)
		{
			System.out.println("Error "  + e.getMessage());
		}
		
	}
	
	/** Method: begin
	 * Purpose: Required to launch from GameStart
	 * @param non
	 * @return void
	 */
	public void begin(String[] args)
	{
		launch(args);
	}
}
