package view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**Class: @GoingDownUI.java
 * @author Brendon Serrano
 * @version 1.0
 * Course : ITEC 3150 Fall 2016
 * Written: @Apr 29, 2017
 *
 * This class is the view component for the GUI
 * 
 */ 
public class GoingDownUI extends Application
{
	//Contains class objects
	private TextField tField = new TextField();
	private TextArea tBox = new TextArea();

	private Rectangle rec9;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage)
	{	
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(getStartWindow(primaryStage));
		primaryStage.setTitle("GOING DOWN"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}


	public BorderPane getStartWindow(Stage startStage)
	{
		//Create BorderPane purchaseBorder, design layout and set properties 
		BorderPane border = new BorderPane();
		//Label title = new Label("START GOING DOWN");
	//	title.setTextFill(Color.CRIMSON);
	//	title.setFont(Font.font ("Verdana", 30));
	//	border.setTop(title);
	//	BorderPane.setAlignment(title, Pos.CENTER);
		border.setStyle("-fx-font: 20px Tahoma; "
				+ "-fx-border-color: black; "
				+ "-fx-background-color:wheat; ");

		Image image9 = new Image("GoingDownPic.png");
		rec9 = new Rectangle(640, 400);
		ImagePattern imagePattern9 = new ImagePattern(image9);
		rec9.setFill(imagePattern9);


		//Create Exit button
		Button btContinue = new Button ("CONTINUE");
		Button btExit = new Button ("Exit Game");

		btExit.setStyle("-fx-background-color: darkslategray;" + "-fx-text-fill: lightgray;");

		// Create a FlowPane flow and set properties
		HBox hb = new HBox(200);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setAlignment(Pos.CENTER);
		hb.setStyle("-fx-background-color: black");
		HBox.setHgrow(btContinue, Priority.ALWAYS);
		HBox.setHgrow(btExit, Priority.ALWAYS);

		
		//Add Buttons btCalc, btClear, and btExit to flow.
		hb.getChildren().addAll(btContinue, btExit);

		


		//Add purchaseGrid and purchaseFlow to purchaseBorder
		border.setCenter(rec9);
		border.setBottom(hb);

		btContinue.setOnAction(e -> {
			getGameWindow(startStage);
		});
		
		//exit button
		btExit.setOnAction(e ->{
			startStage.close();
		});

		return border;				
	}

	public void getGameWindow(Stage primaryStage)
	{
		
		//Create BorderPane border and set properties
		BorderPane border = new BorderPane();
		border.setStyle("-fx-font: 20px Tahoma; "
				+ "-fx-border-color: crimson; "
				+ "-fx-background-color:wheat; ");

		Label title = new Label("GOING DOWN");
		title.setFont(Font.font ("Verdana", 30));
		title.setTextFill(Color.CRIMSON);

		BorderPane.setAlignment(title, Pos.CENTER);

		//Add methods to border
		border.setTop(title);
		border.setLeft(getNavigationButtons());
		border.setCenter(getRoomDescription());
		border.setRight(getCommandButtons(primaryStage));
		border.setBottom(getTextField());

		
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(border);
		primaryStage.setTitle("GOING DOWN"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
	}


	/** Method: @getRbCoffee
	 * Consists of a VBox containing the RadioButtons for decaff and regular coffee.
	 * @return - returns a VBox.
	 **/
	private VBox getNavigationButtons() {

		//Create and initialize Buttons
		Button btNorth = new Button("North");
		Button btEast = new Button("East");
		Button btSouth = new Button("South");
		Button btWest = new Button("West");


		// Create a GridPane pane and set properties
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(85);
		grid.setVgap(15);

		// Place nodes in the pane
		grid.add(btWest,0, 0);				
		grid.add(btEast, 1, 0);

		//Create VBox and set properties
		VBox vBox = new VBox(35);
		vBox.setPadding(new Insets(10, 10, 60, 10)); 
		vBox.setAlignment(Pos.CENTER);
		vBox.setStyle("-fx-border-color: crimson");
		vBox.getChildren().addAll(new Label("Navigation"), btNorth, grid, btSouth);

		//Opens method purchaseOrder
		btNorth.setOnAction(e-> {

		});

		btEast.setOnAction(e-> {

		});

		btSouth.setOnAction(e-> {

		});

		btWest.setOnAction(e-> {

		});

		return vBox;
	}

	/** Method: @getCbOptions
	 * Consists of a VBox containing the CheckBoxes for all Coffee Add-ins.
	 * @return - returns a VBox.
	 **/
	private VBox getRoomDescription() {
		//Create VBox and set properties
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(10, 10, 10, 10)); 
		vBox.setStyle("-fx-border-color: crimson");
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(new Label("Room Description"), tBox);

		return vBox;
	}

	/** Method: @getMuffins
	 * Consists of a GridPane containing the TextFields for all Muffins.
	 * @return - returns a VBox.
	 **/
	public VBox getCommandButtons(Stage primaryStage)
	{
		//Create VBox and set properties
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(20, 10, 20, 10)); 
		vBox.setStyle("-fx-border-color: crimson");
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(new Label("Command"), getCombatButtons(), getInventoryButton(), getAnswerButtons(), getMenuButtons(primaryStage));

		return vBox;
	}

	/** Method: @getButtonOptions
	 * Consists of a FlowPane containing the Buttons for calculating cost, clearing input, and exiting window.
	 * @param Stage primaryStage
	 * 			– passes a Stage argument
	 * @return - returns a FlowPane
	 **/
	public HBox getTextField()
	{		
		// Create a FlowPane flow and set properties
		HBox hb = new HBox();
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setAlignment(Pos.CENTER);
		hb.setStyle("-fx-background-color: crimson");
		HBox.setHgrow(tField, Priority.ALWAYS);

		Button btSubmit = new Button("Submit");

		//Add Buttons btCalc, btClear, and btExit to flow.
		hb.getChildren().addAll(tField, btSubmit);

		btSubmit.setOnAction(e -> {

		});

		return hb;
	}

	/** Method: @getButtonOptions
	 * Consists of a FlowPane containing the Buttons for calculating cost, clearing input, and exiting window.
	 * @param Stage primaryStage
	 * 			– passes a Stage argument
	 * @return - returns a FlowPane
	 **/
	public HBox getCombatButtons()
	{		
		HBox hb = new HBox(150);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setAlignment(Pos.CENTER);
		hb.setStyle("-fx-background-color: crimson");

		Button btAttack = new Button("Attack!");
		Button btRun = new Button("Run!");

		btAttack.setMinWidth(150);
		btRun.setMinWidth(150);

		hb.getChildren().addAll(btAttack, btRun);

		btAttack.setOnAction(e -> {

		});

		btRun.setOnAction(e -> {

		});

		return hb;
	}


	public HBox getInventoryButton()
	{		
		HBox hb = new HBox(10);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setAlignment(Pos.CENTER);
		hb.setStyle("-fx-background-color: crimson");

		Button btInventory = new Button("Inventory");

		btInventory.setMinWidth(150);

		hb.getChildren().add(btInventory);

		btInventory.setOnAction(e -> {

		});

		return hb;
	}

	/** Method: @getButtonOptions
	 * Consists of a FlowPane containing the Buttons for calculating cost, clearing input, and exiting window.
	 * @param Stage primaryStage
	 * 			– passes a Stage argument
	 * @return - returns a FlowPane
	 **/
	public HBox getAnswerButtons()
	{		
		HBox hb = new HBox(10);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setAlignment(Pos.CENTER);
		hb.setStyle("-fx-background-color: crimson");

		Button btA = new Button("Option A");
		Button btB = new Button("Option B");
		Button btC = new Button("Option C");
		Button btD = new Button("Option D");

		//Add Buttons btCalc, btClear, and btExit to HBox.
		hb.getChildren().addAll(btA,btB, btC, btD);

		btA.setOnAction(e -> {

		});

		btB.setOnAction(e -> {

		});

		btC.setOnAction(e -> {

		});

		btD.setOnAction(e -> {

		});

		return hb;
	}

	/** Method: @getButtonOptions
	 * Consists of a FlowPane containing the Buttons for calculating cost, clearing input, and exiting window.
	 * @param Stage primaryStage
	 * 			– passes a Stage argument
	 * @return - returns a FlowPane
	 **/
	public HBox getMenuButtons(Stage primaryStage)
	{		
		HBox hb = new HBox(10);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setAlignment(Pos.CENTER);
		hb.setStyle("-fx-background-color: crimson");

		Button btClear = new Button("Clear");
		Button btSave = new Button("Save");
		Button btExit = new Button("Exit");

		btClear.setMinWidth(143);
		btSave.setMinWidth(143);
		btExit.setMinWidth(143);

		//Add Buttons btCalc, btClear, and btExit to HBox.
		hb.getChildren().addAll(btClear, btSave, btExit);

		btClear.setOnAction(e-> {
			//Resets all TextFields 
			this.tField.setText("");
			this.tBox.setText("");
		});

		//Closes Stage
		btExit.setOnAction(e->{
			primaryStage.close();
		});

		return hb;
	}



	public static void main(String[] args)
	{
		launch(args);
	}
}
