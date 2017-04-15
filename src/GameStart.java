

import java.io.File;
import java.util.IllegalFormatException;
import java.util.Scanner;

import controller.CreateFilesController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ConsoleUI;
import view.GameUI;;

/** Class : GameStart.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Mar 01, 2017
 *
 * This class is the launch point for the DB demo
 */
public class GameStart extends Application
{

	public static void main(String[] args)
	{
		File dbFile = new File("Game.db");
		if (!dbFile.exists())
		{
			CreateFilesController cfc = new CreateFilesController();
			cfc.createFile();
		}

		Scanner input = new Scanner(System.in);
		int choice = 0;
		do
		{
			try
			{
				System.out.println("Please enter 1 to play from the console, 2 to play from the UI.");
				choice = input.nextInt();
			}
			catch (IllegalFormatException ife)
			{
				System.out.println("You must enter an integer.");
			}
			if (!(choice == 1 || choice == 2))
			{
				System.out.println("You must enter 1 or 2");
			}
		} while (!(choice == 1 || choice == 2));
		if (choice == 1)
		{
			ConsoleUI cui = new ConsoleUI();
			cui.startGame();
		}
		else
		{
			GameUI.launch(GameUI.class);
		}
		System.exit(0);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
		
//	/** Method: start
//	 * Purpose: Builds the FX version of the view
//	 * @param primaryStage
//	 * @throws Exception
//	 */
//	@Override
//	public void start(Stage primaryStage) throws Exception
//	{
//		try
//		{
//			FXMLLoader root = new FXMLLoader();
//			root.setLocation(GameStart.class.getResource("view/GameUI.fxml"));
//			GridPane rootLayout = (GridPane)root.load();
//			Scene scene = new Scene(rootLayout, 500, 250);
//			scene.getStylesheets().add(getClass().getResource("view/game.css").toExternalForm());
//			primaryStage.setTitle("Game Demo");
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} 
//		catch (Exception e)
//		{
//			System.out.println("Error "  + e.getMessage());
//		}
//	}
//
}
