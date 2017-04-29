package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Combat;
import controller.GameController;
import controller.Movement;
import controller.Player;
import controller.Puzzle;
import controller.Quest;
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
		Quest quest = new Quest();
		Movement move = new Movement();
		Player player = new Player();
		Room room = new Room();
		Puzzle puzzle = new Puzzle();
		boolean game = false;
		int currentFloor = 1;
		int oldRoom = 1;
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
						player.slowText("-----------------------------------");
						player.slowText("Player HP = " + player.getHitPoints());
						player.slowText(room.getRoomDescription());
						if(room.getRoomID() != 1) {
							player.slowText("Would you like to save \n\r\t1: yes\n\t2: no");
							if(in.nextInt() == 1) 
							{
								player.savePlayer();
							}
						}
						player.slowText("-----------------------------------");
						room = gc.getRoomData(move.choosePath(room, player));
					} 
					if(room.getIsMonsterRoom() == 1 && room.getRoomClear() == 0) {
						player.slowText("-----------------------------------");
						player.slowText("Player HP = " + player.getHitPoints());
						player.slowText(room.getRoomDescription());
						player.slowText("-----------------------------------");
						combat.battle(player, 1, 9, oldRoom, room);
						quest.addRoomClear(quest, room);
						oldRoom = room.getRoomID();
						room = gc.getRoomData(move.choosePath(room, player));
					}
					if(room.getIsBossRoom() == 1) {
						player.slowText("-----------------------------------");
						player.slowText("Player HP = " + player.getHitPoints());
						player.slowText(room.getRoomDescription());
						player.slowText("-----------------------------------");
						combat.battleBoss(player, 10, 16, oldRoom, room);
						oldRoom = room.getRoomID();
						quest.addRoomClear(quest, room);
						room = gc.getRoomData(move.choosePath(room, player));
					}
					if(room.getIsPuzzleRoom() == 1) {
						player.slowText("-----------------------------------");
						player.slowText("Player HP = " + player.getHitPoints());
						player.slowText(room.getRoomDescription());
						player.slowText("-----------------------------------");
						puzzle.solvePuzzle(room, player, puzzle);
						quest.addRoomClear(quest, room);
						room = gc.getRoomData(move.choosePath(room, player));
					}
					if(room.getIsFloorExit() == 1) {
						player.slowText("-----------------------------------");
						player.slowText("Player HP = " + player.getHitPoints());
						player.slowText(room.getRoomDescription());
						player.slowText("-----------------------------------");
						
						//if quests complete do this next
						if(quest.questComplete(quest, room)) {
						SQLiteDB sdb = GameController.getDB();
						currentRoom = sdb.getMaxOfSomething("roomNumber", "Room", "floorNumber", currentFloor);
						sdb.close();
						currentFloor++;
						double newHP = 150 * 1.25 * room.getFloorNumber();
						player.setHitPoints((int)newHP);
						room = gc.getRoomData(++currentRoom);
						}
						
						room = gc.getRoomData(move.choosePath(room, player));
					}

				} else {
					player.slowText("-----------------------------------");
					player.slowText("Room is clear");
					player.slowText("Player HP = " + player.getHitPoints());
					player.slowText(room.getRoomDescription());
					player.slowText("-----------------------------------");
					room = gc.getRoomData(move.choosePath(room, player));
					
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
