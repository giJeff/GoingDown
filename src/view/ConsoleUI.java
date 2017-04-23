package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Combat;
import controller.GameController;
import controller.Movement;
import controller.Player;
import controller.Room;
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
						System.out.println("-----------------------------------");
						room = gc.getRoomData(move.choosePath(room));
					}
					if(room.getIsMonsterRoom() == 1) {
						System.out.println("-----------------------------------");
						System.out.println(room.getRoomDescription());
						System.out.println("-----------------------------------");
						combat.battle(player, 1, 9);
						room.setRoomClear(1);
						room = gc.getRoomData(move.choosePath(room));
					}
					if(room.getIsBossRoom() == 1) {
						System.out.println("-----------------------------------");
						System.out.println(room.getRoomDescription());
						System.out.println("-----------------------------------");
						combat.battle(player, 10, 16);
						room.setRoomClear(1);
						room = gc.getRoomData(move.choosePath(room));
					}
					if(room.getIsPuzzleRoom() == 1) {
						System.out.println("-----------------------------------");
						System.out.println(room.getRoomDescription());
						System.out.println("-----------------------------------");
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
				} else if(room.getRoomClear()== 1) {
					System.out.println("-----------------------------------");
					System.out.println(room.getRoomDescription());
					System.out.println("This room has been cleared!");
					System.out.println("-----------------------------------");
					room = gc.getRoomData(move.choosePath(room));
				}

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

	public void startCombat(Player player) {
		ArrayList<Monster> monsterList = new ArrayList<>();
		Monster mon = new Monster();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		System.out.println("get " + randomNum + " Monsters!");
		monsterList.addAll(mon.getNormalMonsters(randomNum));

		for (Monster monster : monsterList) {
			System.out.println(monster);
			battle(monster, player);
		}
	}

	public void checkInventory()
	{
		
	}
	
	public void battle(Monster monster, Player player) {
		boolean playerDead = false;
		boolean monsterDead = false;
		int userIn = 0;


	


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