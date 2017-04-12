package model;

import java.sql.SQLException;

import controller.GameController;

/** Class : GameDBCreate
 * @author: Rick Price
 * @version: 1.0
 * Course: 
 * Written: Feb 27, 2017
 *
 * This class creates the Game db if it doesn't exist
 *
 * Purpose: Allows the Game test program to create a DB if not there
 */
public class GameDBCreate
{
	SQLiteDB sdb;
	
	/** Method: buildTables
	 * Purpose: Build all tables
	 * @throws SQLException
	 * @return void
	 */
	public void buildTables() throws SQLException
	{
		buildRoom();
		buildMonster();
		buildMonsterRoom();
	}
	
	/** Method: buildRoom
	 * Purpose: Build the Room table and load data
	 * @throws SQLException
	 * @return void
	 */
	public void buildRoom() throws SQLException
	{
		sdb = GameController.getDB();
		String sql = "CREATE TABLE Room(roomNumber int Primary Key not Null, roomName text not null, roomDescription text not null, exits text not null)";
		sdb.updateDB(sql);
		sql = "INSERT INTO Room(roomNumber, roomName, roomDescription, exits) Values(1, 'Entrance', 'A dark, spooky, hole in the ground', 'east, west')";
		sdb.updateDB(sql);
		sql = "INSERT INTO Room(roomNumber, roomName, roomDescription, exits) Values(2, 'Hall', 'A dark, slimy, tunnel leading down', 'east, west')";
		sdb.updateDB(sql);
		sql = "INSERT INTO Room(roomNumber, roomName, roomDescription, exits) Values(3, 'Cavern', 'A huge, dark, cave. You cannot see across the cave, it disappears to the east.', 'west')";
		sdb.updateDB(sql);
		sdb.close();
	}
	
	/** Method: buildMonster
	 * Purpose: Build the Monster table and load data
	 * @throws SQLException
	 * @return void
	 */
	public void buildMonster() throws SQLException
	{
		sdb = GameController.getDB();
		String sql = "CREATE TABLE Monster(monsterNumber int Primary Key not Null, monsterName text not null, monsterDescription text not null, hitPoints int not null, "
				+"minDamage int not null, maxDamage int not null)";
		sdb.updateDB(sql);
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, hitPoints, minDamage, maxDamage) " 
				+ " Values(1, 'Giant Rat', 'A large snarling rat with an extremely long pointed and tooth filled snout', "
				+ "10, 3, 10)";
		sdb.updateDB(sql);
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, hitPoints, minDamage, maxDamage) " 
				+ " Values(2, 'Red Dragon', 'A huge red dragon breathing fire', "
				+ "100, 10, 40)";
		sdb.updateDB(sql);
		sdb.close();
	}
	
	/** Method: buildMonsterRoom
	 * Purpose: Build the Monster table and load data
	 * @throws SQLException
	 * @return void
	 */
	public void buildMonsterRoom() throws SQLException
	{
		sdb = GameController.getDB();
		String sql = "CREATE TABLE MonsterRoom(monsterNumber int not Null, roomNumber int not Null)";
		sdb.updateDB(sql);
		sql = "INSERT INTO MonsterRoom(monsterNumber, roomNumber) Values(1, 2)";
		sdb.updateDB(sql);
		sql = "INSERT INTO MonsterRoom(monsterNumber, roomNumber) Values(2, 3)";
		sdb.updateDB(sql);
		sdb.close();
	}


}
