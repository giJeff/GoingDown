package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.GameController;
import controller.Monster;
import controller.MonsterRoom;
import controller.Room;

/** Class : ConsoleUI.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Mar 01, 2017
 *
 * This class is the view component for the Console
 */
public class ConsoleUI
{

	/** Method: startGame
	 * Purpose: handles the demo 
	 * void
	 */
	public void startGame()
	{
		GameController gc = new GameController();
		try
		{
			printStrs(gc.getAllRoomsData());
		} 
		catch (SQLException e2)
		{
			e2.printStackTrace();
		}
		
		System.out.println("Please press a key to see Monster data");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		
		try
		{
			System.out.println(gc.getMonsterData(1));
			printStrs(gc.getAllMonstersData());
		} 
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		System.out.println("Please press a key to see Monster/Room data");
		input.nextLine();
		
		try
		{
			System.out.println(gc.getMonsterRoomData(1));
			printStrs(gc.getAllMonsterRoomData());
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/** Method: printStrs
	 * Purpose: Print the ArrayList of Strings
	 * @param strs
	 * void
	 */
	private void printStrs(ArrayList<String> strs)
	{
		for (String str : strs)
		{
			System.out.println(str);
		}
	}
	
}
