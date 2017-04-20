package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.SQLiteDB;

/** Class : GameController.java
 * @author: Jeff Graves
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 01, 2017
 *
 * This class is the main controller for the GoingDown program.  
 * Will hold utility functions as well as central functionality 
 */
public class GameController
{
	private static SQLiteDB sdb;

	
	/** Method: getDB
	 * @return the db
	 */
	public static SQLiteDB getDB()
	{
		try
		{
			sdb = new SQLiteDB();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("ERROR!\nThere was a problem opening the database \n" + e.getMessage());
		}

		return sdb;
	}
	
	/** Method: getRoomData
	 * Purpose: gets room data and returns a String containing it
	 * String
	 * @throws SQLException 
	 */
	public Room getRoomData(int roomNumber) throws SQLException
	{
		Room rm = new Room();
		rm = rm.getRoom(roomNumber);
		return rm;
	}
	
	/** Method: getAllRoomsData
	 * Purpose: Gets all rooms and returns an ArrayList<String> of all of the rooms 
	 * @return ArrayList<String>
	 * @throws SQLException
	 */
	public ArrayList<String> getAllRoomsData() throws SQLException
	{
		ArrayList<Room> rooms = null;
		Room rm = new Room();
		rooms = rm.getAllRooms();
		ArrayList<String> roomStrs = new ArrayList<String>();
		for(Room room : rooms)
		{
			roomStrs.add(room.toString());
		}
		return roomStrs;
	}
	
	/** Method: getMonsterData
	 * Purpose: gets Monster data and returns a String containing it
	 * String
	 * @throws SQLException 
	 */
	public String getMonsterData(int monsterNumber) throws SQLException
	{
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
	public ArrayList<String> getAllMonstersData() throws SQLException
	{
		Monster mon = new Monster();
		ArrayList<Monster> monsters = null;
		monsters = mon.getAllMonsters();
		ArrayList<String> monstersStr = new ArrayList<String>();
		for(Monster monster : monsters)
		{
			monstersStr.add(monster.toString());
		}		
		return monstersStr;
	}	
	
	/** Method: getMonsterRoomData
	 * Purpose: Gets the monster and room for the specified room and displays list of monsters in specified rooms
	 * void
	 * @throws SQLException 
	 */
	public String getMonsterRoomData(int monsterRoomNumber) throws SQLException
	{
		MonsterRoom mr = new MonsterRoom();
		mr = mr.getMonster(monsterRoomNumber);
		return mr.toString();
	}
	
	/** Method: getAllMonsterRoomData
	 * Purpose: Get all of the monster and room data.  Joins these two tables. 
	 * @throws SQLException
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAllMonsterRoomData() throws SQLException
	{
		MonsterRoom mr = new MonsterRoom();
		ArrayList<MonsterRoom> monsterRooms = null;
		monsterRooms = mr.getAllMonsters();
		ArrayList<String> mrStrs = new ArrayList<String>();	
		for(MonsterRoom monsterRoom : monsterRooms)
		{
			mrStrs.add(monsterRoom.toString());
		}		
		return mrStrs;
	}
	
	/** Method: getWeaponData
	 * Purpose: Gets the weapon and displays list of attributes
	 * void
	 * @throws SQLException 
	 */
	public String getWeaponData(int weaponNumber) throws SQLException
	{
		Weapon wep = new Weapon();
		wep = wep.getWeapon(weaponNumber);
		return wep.toString();
	}
	
	/** Method: getAllWeaponData
	 * Purpose: Get all of the weapon data.
	 * @throws SQLException
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAllWeaponData() throws SQLException
	{
		Weapon wep = new Weapon();
		ArrayList<Weapon> weapons = null;
		weapons = wep.getAllWeapons();
		ArrayList<String> wepStrs = new ArrayList<String>();	
		for(Weapon weapon : weapons)
		{
			wepStrs.add(weapon.toString());
		}		
		return wepStrs;
	}
	
	/** Method: getArmorData
	 * Purpose: Gets the armor and displays list of attributes
	 * void
	 * @throws SQLException 
	 */
	public String getArmorData(int armorNumber) throws SQLException
	{
		Armor arm = new Armor();
		arm = arm.getArmor(armorNumber);
		return arm.toString();
	}
	
	/** Method: getAllArmorData
	 * Purpose: Get all of the armor data.
	 * @throws SQLException
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAllArmorData() throws SQLException
	{
		Armor arm = new Armor();
		ArrayList<Armor> armors = null;
		armors = arm.getAllArmors();
		ArrayList<String> armStrs = new ArrayList<String>();	
		for(Armor armor : armors)
		{
			armStrs.add(armor.toString());
		}		
		return armStrs;
	}
	
	/** Method: getPotionData
	 * Purpose: Gets the potion and displays list of attributes
	 * void
	 * @throws SQLException 
	 */
	public String getPotionData(int potionNumber) throws SQLException
	{
		Potion pot = new Potion();
		pot = pot.getPotion(potionNumber);
		return pot.toString();
	}
	
	/** Method: getAllPotionData
	 * Purpose: Get all of the potion data.
	 * @throws SQLException
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAllPotionData() throws SQLException
	{
		Potion pot = new Potion();
		ArrayList<Potion> potions = null;
		potions = pot.getAllPotions();
		ArrayList<String> potStrs = new ArrayList<String>();	
		for(Potion potion : potions)
		{
			potStrs.add(potion.toString());
		}		
		return potStrs;
	}


}
