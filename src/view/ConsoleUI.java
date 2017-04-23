package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import controller.GameController;
import controller.Monster;
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
		Player player = new Player();
		Room room = new Room();
		boolean game = false;
		int currentFloor = 1;
		int currentRoom = 1;

		try {
			room = gc.getRoomData(currentRoom);
			player.getPlayer(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(!game) {
			try {
				if(room.getRoomClear()== 0) {
					if(room.getIsSafeRoom() == 1) {
						System.out.println(room.getRoomDescription());
						room = gc.getRoomData(choosePath(room));
					}
					if(room.getIsMonsterRoom() == 1) {
						System.out.println(room.getRoomDescription());
						System.out.println("Player has " + player.getHitPoints() + "  health left");
						startCombat(player);
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
						SQLiteDB sdb = GameController.getDB();
						currentRoom = sdb.getMaxOfSomething("roomNumber", "Room", "floorNumber", currentFloor);
						sdb.close();
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

		
		while(!playerDead && !monsterDead) {

			int randomMonsterAttack = ThreadLocalRandom.current().nextInt(monster.getMinDamage(), monster.getMaxDamage() + 1);
			int randomPlayerAttack = ThreadLocalRandom.current().nextInt(player.getMinDamage(), player.getMaxDamage() + 1);

			System.out.println("-----------------------------------");
			System.out.println("A " + monster.getMonsterName() + " has " + monster.getHitPoints() + " health left");
			System.out.println("\t1. Attack");
			System.out.println("\t2. Run");
			System.out.println("-----------------------------------");
			System.out.println("Player has " + player.getHitPoints() + "  health left");
			
			if (!in.hasNextInt()) {
				in.next();
			} else {
				userIn = in.nextInt();
			}
			
			if(userIn == 1) {
				if(monster.getAttackFirst() == 1) {
					player.setHitPoints(player.getHitPoints()-randomMonsterAttack);
					System.out.println("Player took " + randomMonsterAttack + " damage this turn!");
					if(player.getHitPoints() < 1) {
						playerDead = true;
					} else {
						monster.setHitPoints(monster.getHitPoints()-randomPlayerAttack);
						System.out.println("Monster took " + randomPlayerAttack + " damage this turn!");
						if(monster.getHitPoints() < 1) {
							monsterDead = true;
						}
					}

				} else {
					monster.setHitPoints(monster.getHitPoints()-randomPlayerAttack);
					System.out.println("Monster took " + randomPlayerAttack + " damage this turn!");
					if(monster.getHitPoints() < 1) {
						monsterDead = true;
					} else {
						player.setHitPoints(player.getHitPoints()-randomMonsterAttack);
						System.out.println("Player took " + randomMonsterAttack + " damage this turn!");
						if(player.getHitPoints() < 1) {
							playerDead = true;
						}
					}
				}
			} else {
				System.out.println("no run logic yet!");
			}
			
			System.out.println("playerDead = " + playerDead + " monsterDead = " + monsterDead);
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