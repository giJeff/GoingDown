package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Class : UIController.java
 * 
 * @author: Rick Price
 * @version: 1.0 Course: ITEC 3860 Written: Mar 24, 2017
 *
 *           This class is the UI version of the DB Tutorial
 *
 */
public class UIController
{
	@FXML
	private TextArea descTA;
	@FXML
	private TextField cmdTF;

	private int number = 0;

	private GameController gc = new GameController();

	/**
	 * Method: next Purpose: Perform the next operation in the demo void
	 */
	@FXML
	public void next()
	{
		number++;
		String desc = getString(number);

		descTA.setText(desc);
	}

	/**
	 * Method: saveMsg Purpose: Display a message on button click void
	 */
	@FXML
	public void saveMsg()
	{
		cmdTF.setText("Save pressed");
	}

	/**
	 * Method: cancel Purpose: Closes the DOA application
	 * 
	 * @return void
	 */
	@FXML
	public void cancel()
	{
		Stage stage = (Stage) descTA.getScene().getWindow();
		stage.close();
	}

	private String getString(int number)
	{
		String retStr = "";
		try
		{
			switch (number)
			{
				case 1:
				{
					// retStr = gc.getRoomData(1);
					break;
				}
				case 2:
				{
					retStr = buildStrs(gc.getAllRoomsData());

					break;
				}
				case 3:
				{
					retStr = gc.getMonsterData(1);
					break;
				}
				case 4:
				{
					retStr = buildStrs(gc.getAllMonstersData());
					break;
				}
				case 5:
				{
					retStr = gc.getWeaponData(1);
					break;
				}
				case 6:
				{
					retStr = buildStrs(gc.getAllWeaponData());
					break;
				}
				case 7:
				{
					retStr = gc.getArmorData(1);
					break;
				}
				case 8:
				{
					retStr = buildStrs(gc.getAllArmorData());
					break;
				}
				case 9:
				{
					retStr = gc.getPotionData(1);
					break;
				}
				case 10:
				{
					retStr = buildStrs(gc.getAllPotionData());
					break;
				}
				default:
				{
					retStr = "Error:  Invalid number of attempts";
				}
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retStr;
	}

	private String buildStrs(ArrayList<String> strs)
	{
		String retStr = "";
		for (String str : strs)
		{
			retStr += str;
			retStr += "\n";
		}
		return retStr;
	}

}
