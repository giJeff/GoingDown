package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import controller.GameController;
import controller.Monster;
import controller.MonsterRoom;
import controller.Player;
import controller.Room;
import controller.Weapon;
import model.DB;
import model.SQLiteDB;
import controller.Armor;

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
	Scanner in = new Scanner(System.in);
	public void startGame() throws ClassNotFoundException, SQLException
	{
		GameController gc = new GameController();
		Player player = new Player();
		Room room = new Room();
		boolean game = false;
		int currentFloor = 1;
		int currentRoom = 1;
		
		try {
			room = gc.getRoomData(currentRoom);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(!game) {
			try {
				if(room.getRoomClear()== 0) {
					if(room.getIsSafeRoom() == 1) {
						System.out.println(room.getRoomDescription());
						System.out.println("Would you like to save?  1 yes or 2 no");
						//player.savePlayer();
						room = gc.getRoomData(choosePath(room));
					}
					if(room.getIsMonsterRoom() == 1) {
						System.out.println(room.getRoomDescription());
						startCombat();
						room = gc.getRoomData(choosePath(room));
					}
					if(room.getIsBossRoom() == 1) {
						System.out.println(room.getRoomDescription());
						room = gc.getRoomData(choosePath(room));
					}
					if(room.getIsPuzzleRoom() == 1) {
						System.out.println(room.getRoomDescription());
						room = gc.getRoomData(choosePath(room));
					}
					if(room.getIsFloorExit() == 1) {
						System.out.println(room.getRoomDescription());
						//if quests complete do this next
						SQLiteDB sql = new SQLiteDB();
						currentRoom = sql.getMaxOfSomething("roomNumber", "Room", "floorNumber", currentFloor);
						sql.close();
						currentFloor++;
						
						room = gc.getRoomData(++currentRoom);
					}
				} // what if room is clear? need more stuffs here
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public int choosePath(Room room) 
	{
		boolean path = false;
		int nextRoom=0;
		int userIn=0;
		PATH:
		while(!path) 
		{
			System.out.println("-----------------------------------");
			System.out.println("Choose your direction. Enter a number: ");
			System.out.println(room.getExitNorth() + "\t1. North");
			System.out.println(room.getExitEast() + "\t2. East");
			System.out.println(room.getExitSouth() + "\t3. South");
			System.out.println(room.getExitWest() + "\t4. West");
			System.out.println("-----------------------------------");

			if (!in.hasNextInt()) {
				in.next();
			} else {
				userIn = in.nextInt();
			}
			if(userIn == 1) {
				if(room.getExitNorth() == 0) {
					System.out.println("There is a wall here try again.");
				} else {
					nextRoom = room.getExitNorth();
					path = true;
				}
			} else if(userIn == 2) {
				if(room.getExitEast() == 0) {
					System.out.println("There is a wall here try again.");
				} else {
					nextRoom = room.getExitEast();
					path = true;
				}
				
			} else if(userIn == 3) {
				if(room.getExitSouth() == 0) {
					System.out.println("There is a wall here try again.");
				} else {
					nextRoom = room.getExitSouth();
					path = true;
				}
			} else if(userIn == 4) {
				if(room.getExitWest() == 0) {
					System.out.println("There is a wall here try again.");
				} else {
					nextRoom = room.getExitWest();
					path = true;
				}
			}
		} return nextRoom;
	}
	
	public void startCombat() {
		Random rand = new Random();
		ArrayList<Monster> monsterList = new ArrayList<>();
		Monster mon = new Monster();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		System.out.println("get " + randomNum + " Monsters!");
		monsterList.addAll(mon.getNormalMonsters(randomNum));

		for (Monster monster : monsterList) {
			System.out.println(monster);
		}
	}
	
	public void battle() {
		
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
