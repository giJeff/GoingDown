package view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**Class: @GoingDownUI.java
 * @author Brendon Serrano
 * @version 1.0
 * Course : ITEC 3860
 * Written: April 28, 2017
 *
 *
 * This class is the view component for the GUI
 * 			
 */ 
public class GoingDownUI extends Application
{
	//Contains class objects
	private ToggleGroup group;
	private RadioButton rbRegular;
	private RadioButton rbDecaff;

	private CheckBox cbCream;
	private CheckBox cbSugar;
	private CheckBox cbArt;
	private CheckBox cbCin;
	private CheckBox cbCar;

	private TextField tField = new TextField();
	private TextField textChoc = new TextField();
	private TextField textBNB = new TextField();


	private TextArea tBox = new TextArea();


	@Override // Override the start method in the Application class
	public void start(Stage primaryStage)
	{	
		//Create BorderPane border and set properties
		BorderPane border = new BorderPane();
		Label title = new Label("GOING DOWN");
		title.setFont(Font.font ("Verdana", 30));
		title.setTextFill(Color.CRIMSON);
		border.setTop(title);
		BorderPane.setAlignment(title, Pos.CENTER);
		border.setStyle("-fx-font: 20px Tahoma; "
				+ "-fx-border-color: crimson; "
				+ "-fx-background-color:wheat; ");

		//Add methods to border
		border.setLeft(getRbCoffee());
		border.setCenter(getCbOptions());
		border.setRight(getButtons(primaryStage));
		border.setBottom(getTextField());

		// Create a scene and place it in the stage
		Scene scene = new Scene(border);
		primaryStage.setTitle("GOING DOWN"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Method: @purchaseOrder
	 * All calculations for each order are completed here.
	 * New window is created in order to display purchase.
	 * Window consists of a BorderPane using the Top, Center, and Bottom positions.
	 * 		Top: Consists of the title.
	 * 		Center: Consists of the GridPane which contains the purchase information.
	 * 		Bottom: Consists of the FlowPane which contains the "Exit" button to close the window.
	 **/
	private void purchaseOrder()
	{
		//Muffins variables
		int blue = 0;
		int choc = 0;
		int bNB = 0;

		//Constant variables
		final double MUFFIN_COST = 4.25;
		final double COFFEE_COST = 1.00;
		final double ADD_IN_COST = 0.25;
		final double TAX = .07;

		//Tax and Total variables
		double subTotal = 0;
		double totalTax = 0;
		double total = 0;

		//If statements for any radio button for coffee or CheckBox for add-in is selected.
		if(this.rbDecaff.isSelected() || this.rbRegular.isSelected())
		{
			subTotal += COFFEE_COST;
		}
		if(this.cbCream.isSelected())
		{
			subTotal += ADD_IN_COST;
		}
		if(this.cbSugar.isSelected())
		{
			subTotal += ADD_IN_COST;
		}
		if(this.cbArt.isSelected())
		{
			subTotal += ADD_IN_COST;
		}
		if(this.cbCin.isSelected())
		{
			subTotal += ADD_IN_COST;
		}
		if(this.cbCar.isSelected())
		{
			subTotal += ADD_IN_COST;
		}

		//If statements for any number of muffins written in with a try-catch to catch NumberFormatExceptions.
		if(this.tField.getText() != null)
		{
			try
			{
				blue = Integer.parseInt(this.tField.getText());
				subTotal += (blue * MUFFIN_COST);
			} catch (NumberFormatException nfe){}
		}
		if(this.textChoc.getText() != null)
		{
			try
			{
				choc = Integer.parseInt(this.textChoc.getText());
				subTotal += (choc * MUFFIN_COST);
			} catch (NumberFormatException nfe){}
		}
		if(this.textBNB.getText() != null)
		{
			try
			{
				bNB = Integer.parseInt(this.textBNB.getText());
				subTotal += (bNB * MUFFIN_COST);
			} catch (NumberFormatException nfe){}
		}

		//Taxes for each order are calculated then rounded. 
		totalTax = Math.round(subTotal * TAX * 100.0) / 100.0;

		//total is calculated to include subtotal plus tax.
		total = subTotal + totalTax;

		//Create new Stage purchaseWindow
		Stage purchaseWindow = new Stage();

		//Create BorderPane purchaseBorder, design layout and set properties 
		BorderPane purchaseBorder = new BorderPane();
		Label purchaseTitle = new Label("Purchase Order");
		purchaseTitle.setTextFill(Color.CRIMSON);
		purchaseTitle.setFont(Font.font ("Verdana", 30));
		purchaseBorder.setTop(purchaseTitle);
		BorderPane.setAlignment(purchaseTitle, Pos.CENTER);
		purchaseBorder.setStyle("-fx-font: 20px Tahoma; "
				+ "-fx-border-color: crimson; "
				+ "-fx-background-color:wheat; ");

		//Create GridPane purchaseGrid, design layout and set properties
		GridPane purchaseGrid = new GridPane();
		purchaseGrid.setAlignment(Pos.CENTER);
		purchaseGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		purchaseGrid.setHgap(5.5);
		purchaseGrid.setVgap(5.5);
		purchaseGrid.setStyle("-fx-font: 20px Tahoma; "
				+ "-fx-border-color: crimson; "
				+ "-fx-background-color:wheat; ");

		//Place nodes into GridPane purchaseGrid
		purchaseGrid.add(new Label("Subtotal:"), 0, 1);
		purchaseGrid.add(new Label("$" + subTotal), 1, 1);
		purchaseGrid.add(new Label("Tax:"), 0, 2);
		purchaseGrid.add(new Label("$" + totalTax), 1, 2);
		purchaseGrid.add(new Label("Total:"), 0, 3);
		purchaseGrid.add(new Label("$" + total), 1, 3);

		//Create Exit button
		Button btExit = new Button ("Exit");

		//Create FlowPane purchaseFlow, design layout and set properties
		FlowPane purchaseFlow = new FlowPane(500,10);
		purchaseFlow.setPadding(new Insets(10, 10, 10, 10));
		purchaseFlow.setAlignment(Pos.CENTER);
		purchaseFlow.setStyle("-fx-background-color: crimson");
		purchaseFlow.setHgap(20);

		//Add btExit button to purchaseFLow
		purchaseFlow.getChildren().add(btExit);

		//Add purchaseGrid and purchaseFlow to purchaseBorder
		purchaseBorder.setCenter(purchaseGrid);
		purchaseBorder.setBottom(purchaseFlow);

		//Create a Scene scene2 and place it in the stage
		Scene scene2 = new Scene(purchaseBorder);
		purchaseWindow.setTitle("Purchase Order Display"); // Set the stage title
		purchaseWindow.setScene(scene2); // Place the scene in the stage
		purchaseWindow.show(); // Display the stage

		//exit button
		btExit.setOnAction(e ->{
			purchaseWindow.close();
		});
	}

	/** Method: @getRbCoffee
	 * Consists of a VBox containing the RadioButtons for decaff and regular coffee.
	 * @return - returns a VBox.
	 **/
	private VBox getRbCoffee() {
		//Create and initialize Buttons
				Button btCalc = new Button("Calculate");

				Button btAttack = new Button("Attack");
				Button btFlee = new Button("Flee");
				
				Button btNorth = new Button("North");
				Button btEast = new Button("East");
				Button btSouth = new Button("South");
				Button btWest = new Button("West");
				
				Button btStart = new Button("Start");
				Button btClear = new Button("Clear");
				Button btSave = new Button("Save");
				Button btExit = new Button("Exit");

				btCalc.setMinWidth(150);

				btAttack.setMinWidth(150);
				btFlee.setMaxWidth(150);

				btStart.setMinWidth(150);
				btClear.setMinWidth(150);
				btSave.setMinWidth(150);
				btExit.setMinWidth(150);

				// Create a GridPane pane and set properties
				GridPane grid = new GridPane();
				grid.setAlignment(Pos.CENTER);
				grid.setPadding(new Insets(5, 20, 20, 20));
				grid.setStyle("-fx-border-color: crimson");
				grid.setHgap(15);
				grid.setVgap(28);

				// Place nodes in the pane
				//grid.add(new Label("Command:"), 0, 0);		
				grid.add(btWest,0, 1);
				
				grid.add(btEast, 1, 1);

				//Create VBox and set properties
				VBox vBox = new VBox(10);
				vBox.setPadding(new Insets(10, 10, 50, 10)); 
				vBox.setStyle("-fx-border-color: crimson");
				vBox.setAlignment(Pos.CENTER);
				vBox.getChildren().addAll(new Label("Navigation:"), btNorth, grid, btSouth);

				//Opens method purchaseOrder
				btCalc.setOnAction(e-> purchaseOrder());

				return vBox;
	}

	/** Method: @getCbOptions
	 * Consists of a VBox containing the CheckBoxes for all Coffee Add-ins.
	 * @return - returns a VBox.
	 **/
	private VBox getCbOptions() {
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
	public VBox getButtons(Stage primaryStage)
	{
		//Create and initialize Buttons
		Button btCalc = new Button("Calculate");

		Button btAttack = new Button("Attack");
		Button btFlee = new Button("Flee");
		
		Button btNorth = new Button("North");
		Button btEast = new Button("East");
		Button btSouth = new Button("South");
		Button btWest = new Button("West");
		
		Button btStart = new Button("Start");
		Button btClear = new Button("Clear");
		Button btSave = new Button("Save");
		Button btExit = new Button("Exit");

		btCalc.setMinWidth(150);

		btAttack.setMinWidth(150);
		btFlee.setMaxWidth(150);

		btStart.setMinWidth(150);
		btClear.setMinWidth(150);
		btSave.setMinWidth(150);
		btExit.setMinWidth(150);

		// Create a GridPane pane and set properties
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(5, 20, 20, 20));
		grid.setStyle("-fx-border-color: crimson");
		grid.setHgap(15);
		grid.setVgap(28);

		// Place nodes in the pane
		//grid.add(new Label("Command:"), 0, 0);		
		grid.add(btAttack,0, 1);
		grid.add(btFlee, 0, 2);
		grid.add(btCalc, 0, 3); 

		//grid.add(new Label("Basic Command:"), 1, 0);
		grid.add(btClear, 1, 1);
		grid.add(btSave, 1, 2);
		grid.add(btExit, 1, 3);

		//Create VBox and set properties
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(10, 10, 50, 10)); 
		vBox.setStyle("-fx-border-color: crimson");
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(new Label("Command:"), grid);

		//Opens method purchaseOrder
		btCalc.setOnAction(e-> purchaseOrder());

		btAttack.setOnAction(e -> {

		});

		btFlee.setOnAction(e -> {

		});

		btClear.setOnAction(e-> {
			//Resets all TextFields to "0"
			this.tField.setText("");
			this.tBox.setText("");
		});

		//Closes Stage
		btExit.setOnAction(e->{
			primaryStage.close();
		});

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

		return hb;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
