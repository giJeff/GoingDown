package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Combat;
import controller.GameController;
import controller.Movement;
import controller.Player;
import controller.Puzzle;
import controller.Room;
import model.DB;
import model.SQLiteDB;

/** Class : ConsoleUI.java
 * @author: Jeff Graves
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
		Combat combat = new Combat();
		Movement move = new Movement();
		Player player = new Player();
		Room room = new Room();
		Puzzle puzzle = new Puzzle();
		ArrayList<Room> rooms = room.getAllRooms();
		boolean game = false;
		int currentFloor = 1;
		int currentRoom = 1;
		int currentPlayer = 1; // will need to get these from a load

		try {
			room = gc.getRoomData(currentRoom);
			player = gc.getPlayerData(currentPlayer);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(!game) {
			try {
				if(room.getRoomClear()== 0) {
					if(room.getIsSafeRoom() == 1) {
						System.out.println("-----------------------------------");
						System.out.println(room.getRoomDescription());
						if(room.getRoomID() != 1) {
							System.out.println("Would you like to save \n\t1: yes\n\t2: no\n");
							if(in.nextInt() == 1) 
							{
								player.savePlayer();
							}
						}
						System.out.println("-----------------------------------");
						room = gc.getRoomData(move.choosePath(room));
					} 
					if(room.getIsMonsterRoom() == 1 && room.getRoomClear() == 0) {
						System.out.println("-----------------------------------");
						System.out.println(room.getRoomDescription());
						System.out.println("-----------------------------------");
						combat.battle(player, 1, 9);
						SQLiteDB sdb = GameController.getDB();
						String sql = "UPDATE Room Set roomClear = 1 WHERE roomNumber = " + room.getRoomID();
						sdb.updateDB(sql);
						sdb.close();
						room = gc.getRoomData(move.choosePath(room));
					}
					if(room.getIsBossRoom() == 1) {
						System.out.println("-----------------------------------");
						System.out.println(room.getRoomDescription());
						System.out.println("-----------------------------------");
						combat.battle(player, 10, 16);
						SQLiteDB sdb = GameController.getDB();
						String sql = "UPDATE Room Set roomClear = 1 WHERE roomNumber = " + room.getRoomID();
						sdb.updateDB(sql);
						sdb.close();
						room = gc.getRoomData(move.choosePath(room));
					}
					if(room.getIsPuzzleRoom() == 1) {
						System.out.println("-----------------------------------");
						System.out.println(room.getRoomDescription());
						System.out.println("-----------------------------------");
						puzzle.solvePuzzle(room, player, puzzle);

						room = gc.getRoomData(move.choosePath(room));
					}
					if(room.getIsFloorExit() == 1 && room.getRoomClear()== 1) {
						System.out.println("-----------------------------------");
						System.out.println(room.getRoomDescription());
						System.out.println("-----------------------------------");
						//if quests complete do this next
						SQLiteDB sdb = GameController.getDB();
						currentRoom = sdb.getMaxOfSomething("roomNumber", "Room", "floorNumber", currentFloor);
						sdb.close();
						currentFloor++;

						room = gc.getRoomData(++currentRoom);
					}

				} else {
					System.out.println("-----------------------------------");
					System.out.println("Room is clear");
					System.out.println(room.getRoomDescription());
					System.out.println("-----------------------------------");
					room = gc.getRoomData(move.choosePath(room));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
