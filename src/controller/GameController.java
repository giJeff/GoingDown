package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.SQLiteDB;

/** Class : GameController.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Mar 01, 2017
 *
 * This class is the main controller for the DB Demo program.  
 * Will hold utility functions as well as central functionality 
 */
public class GameController {
	private static SQLiteDB sdb;

	
	/** Method: getDB
	 * @return the db
	 */
	public static SQLiteDB getDB() {
		try {
			sdb = new SQLiteDB();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("ERROR!\nThere was a problem opening the database \n" + e.getMessage());
		}

		return sdb;
	}
	
	/** Method: getRoomData
	 * Purpose: gets room data and returns a String containing it
	 * String
	 * @throws SQLException 
	 */
	public String getRoomData(int roomNumber) throws SQLException {
		Room rm = new Room();
		rm = rm.getRoom(roomNumber);
		return rm.toString();
	}
	
	/** Method: getAllRoomsData
	 * Purpose: Gets all rooms and returns an ArrayList<String> of all of the rooms 
	 * @return ArrayList<String>
	 * @throws SQLException
	 */
	public ArrayList<String> getAllRoomsData() throws SQLException {
		ArrayList<Room> rooms = null;
		Room rm = new Room();
		rooms = rm.getAllRooms();
		ArrayList<String> roomStrs = new ArrayList<String>();
		for(Room room : rooms) {
			roomStrs.add(room.toString());
		}
		return roomStrs;
	}
	
	/** Method: getMonsterData
	 * Purpose: gets Monster data and returns a String containing it
	 * String
	 * @throws SQLException 
	 */
	public String getMonsterData(int monsterNumber) throws SQLException {
		Monster mon = new Monster();
		mon = mon.getMonster(monsterNumber);
		return mon.toString();
	}
	
	/** Method: getAllMonstersData
	 * Purpose: Get all of the monster data from the DB 
	 * 
	 * @throws SQLException
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAllMonstersData() throws SQLException {
		Monster mon = new Monster();
		ArrayList<Monster> monsters = null;
		monsters = mon.getAllMonsters();
		ArrayList<String> monstersStr = new ArrayList<String>();
		for(Monster monster : monsters) {
			monstersStr.add(monster.toString());
		}		
		return monstersStr;
	}	
	
	/** Method: getMonsterRoomData
	 * Purpose: Gets the monster and room for the specified room and displays list of monsters in specified rooms
	 * void
	 * @throws SQLException 
	 */
	public String getMonsterRoomData(int monsterRoomNumber) throws SQLException {
		MonsterRoom mr = new MonsterRoom();
		mr = mr.getMonster(monsterRoomNumber);
		return mr.toString();
	}
	
	/** Method: getAllMonsterRoomData
	 * Purpose: Get all of the monster and room data.  Joins these two tables. 
	 * @throws SQLException
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAllMonsterRoomData() throws SQLException {
		MonsterRoom mr = new MonsterRoom();
		ArrayList<MonsterRoom> monsterRooms = null;
		monsterRooms = mr.getAllMonsters();
		ArrayList<String> mrStrs = new ArrayList<String>();	
		for(MonsterRoom monsterRoom : monsterRooms) {
			mrStrs.add(monsterRoom.toString());
		}		
		return mrStrs;
	}


}
