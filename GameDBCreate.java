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
		String sql = "CREATE TABLE Room(roomNumber int Primary Key not null, floorNumber int not null, roomName text not null, roomDescription text not null, exitNorth int, exitEast int, exitSouth int, 
			exitWest int, roomClear int not null, isFloorExit int not null, isPuzzleRoom int not null, isMonsterRoom int not null, isBossRoom int not null, isSafeRoom int not null)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(1, 1, 'Entrance', 'This is the entrance room', null, 2, null, null, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(2, 1, 'Monster', 'This is a monster room', 3, 5, 4, 1, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(3, 1, 'Puzzle', 'This is a puzzle room', null, null, 2, null, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(4, 1, 'Monster', 'This is a monster room', 2, null, null, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(5, 1, 'Boss', 'This is a boss room', null, 6, null, 2, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(6, 1, 'Safe', 'This is a safe room', null, 7, null, 5, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(7, 1, 'Exit', 'This is an exit room', null, null, null, 6, 0, 1, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		
		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(8, 2, 'Entrance', 'This is the entrance room', 16, null, null, 9, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(9, 2, 'Monster', 'This is the monster room', null, 8, null, 10, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);
	
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(10, 2, 'Boss', 'This is the Boss room', 15, 9, null, 11, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(11, 2, 'Monster', 'This is the monster room', 14, 10, null, 12, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(12, 2, 'Puzzle', 'This is the puzzle room', 13, 11, null, null, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(13, 2, 'Monster', 'This is the monster room', null, 14, 12, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(14, 2, 'Safe', 'This is a safe room', null, 15, 11, 13, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(15, 2, 'Monster', 'This is the monster room', 19, null, 10, 14, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(16, 2, 'Monster', 'This is the monster room', 17, null, 8, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(17, 2, 'Safe', 'This is a safe room', null, null, 16, 18, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(18, 2, 'Monster', 'This is the monster room', null, 17, null, 19, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(19, 2, 'Puzzle', 'This is the puzzle room', 20, 18, 15, null, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(20, 2, 'Monster', 'This is the monster room', 24, null, 19, 21, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(21, 2, 'Safe', 'This is a safe room', 23, 20, null, 22, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(22, 2, 'Monster', 'This is the monster room', null, 21, null, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(23, 2, 'Boss', 'This is the Boss room', null, 24, 21, null, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(24, 2, 'Monster', 'This is the monster room', null, 25, 20, 23, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(25, 2, 'Exit', 'This is an exit room', null, 26, null, 24, 0, 1, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(26, 2, 'Boss', 'This is the Boss room', null, null, null, 25, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);


		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(27, 3, 'Entrance', 'This is the entrance room', 28, null, 38, null, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(28, 3, 'Monster', 'This is the monster room', null, null, 27, 29, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(29, 3, 'Puzzle', 'This is the puzzle room', null, 28, null, 30, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(30, 3, 'Monster', 'This is the monster room', null, 29, null, 31, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(31, 3, 'Boss', 'This is the Boss room', null, 30, 32, null, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);
	
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(32, 3, 'Safe', 'This is a safe room', 31, null, 35, 33, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(33, 3, 'Monster', 'This is the monster room', null, 32, 34, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(34, 3, 'Puzzle', 'This is the puzzle room', 33, 35, 41, null, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(35, 3, 'Exit', 'This is an exit room', 32, 36, null, 34, 0, 1, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(36, 3, 'Monster', 'This is the monster room', null, 37, 40, 35, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(37, 3, 'Monster', 'This is the monster room', null, 38, null, 36, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(38, 3, 'Puzzle', 'This is the puzzle room', 27, null, 39, 37, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(39, 3, 'Monster', 'This is the monster room', 38, null, 45, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(40, 3, 'Safe', 'This is a safe room', 36, null, 44, null, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(41, 3, 'Monster', 'This is the monster room', 34, null, 42, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(43, 3, 'Boss', 'This is the Boss room', null, 44, null, 42, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(44, 3, 'Monster', 'This is the monster room', 40, null, null, 43, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(45, 3, 'Puzzle', 'This is the puzzle room', 39, null, null, null, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);



		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(46, 4, 'Entrance', 'This is the entrance room', null, 47, 53, null, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(47, 4, 'Monster', 'This is the monster room', null, 48, 52, 46, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(48, 4, 'Monster', 'This is the monster room', null, 49, 51, 47, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(49, 4, 'Safe', 'This is a safe room', null, 50, null, 48, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(50, 4, 'Boss', 'This is the Boss room', null, null, null, 49, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(51, 4, 'Monster', 'This is the monster room', 48, null, 55, 52, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(52, 4, 'Safe', 'This is a safe room', 47, 51, 54, 53, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(53, 4, 'Puzzle', 'This is the puzzle room', 46, 52, null, null, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(54, 4, 'Monster', 'This is the monster room', 52, 55, 60, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);	

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(55, 4, 'Puzzle', 'This is the puzzle room', 51, 56, null, 54, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(56, 4, 'Monster', 'This is the monster room', null, 57, 59, 55, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(57, 4, 'Boss', 'This is the Boss room', null, null, 58, 56, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(58, 4, 'Monster', 'This is the monster room', 57, null, null, 59, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(59, 4, 'Safe', 'This is a safe room', 56, 58, 64, null, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(60, 4, 'Monster', 'This is the monster room', 54, null, 62, 61, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(61, 4, 'Exit', 'This is an exit room', null, 60, null, null, 0, 1, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(62, 4, 'Puzzle', 'This is the puzzle room', 60, 63, null, null, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(63, 4, 'Boss', 'This is the Boss room', null, 64, null, 62, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(64, 4, 'Monster', 'This is the monster room', 59, null, null, 63, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(65, 5, 'Entrance', 'This is the entrance room', null, 72, null, null, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(66, 5, 'Boss', 'This is the Boss room', null, 67, 72, null, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(67, 5, 'Monster', 'This is the monster room', null, 68, 71, 66, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(68, 5, 'Boss', 'This is the Boss room', null, 69, 70, 67, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(69, 5, 'Monster', 'This is the monster room', null, null, null, 68, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(70, 5, 'Safe', 'This is a safe room', 68, null, 74, 71, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(71, 5, 'Monster', 'This is the monster room', 67, 70, 73, 72, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(72, 5, 'Safe', 'This is a safe room', 66, 71, null, 65, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(73, 5, 'Puzzle', 'This is the puzzle room', 71, 74, 77, null, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(68, 5, 'MegaBoss', 'This is the MegaBoss room', 70, null, 76, 73, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(75, 5, 'Puzzle', 'This is the puzzle room', null, null, 83, 76, 0, 0, 1, 0, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(76, 5, 'Safe', 'This is a safe room', 74, 75, 82, 77, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(77, 5, 'Monster', 'This is the monster room', 73, 76, 81, 78, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(78, 5, 'Safe', 'This is a safe room', null, 77, null, 79, 0, 0, 0, 0, 0, 1)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(79, 5, 'Monster', 'This is the monster room', null, 78, 80, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(80, 5, 'Monster', 'This is the monster room', 79, null, null, null, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(81, 5, 'Boss', 'This is the Boss room', 77, 82, null, null, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(82, 5, 'Monster', 'This is the monster room', 76, 83, null, 81, 0, 0, 0, 1, 0, 0)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest, roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) 
			Values(83, 5, 'Boss', 'This is the Boss room', 75, null, null, 82, 0, 0, 0, 0, 1, 0)";
		sdb.updateDB(sql);
		

		sdb.close();
	}

	/** Method: buildWeapon
	 * Purpose: Build the weapon table and load data
	 * @throws SQLException
	 * @return void
	 */
	public void buildWeapon() throws SQLException
	{
		sdb = GameController.getDB(weaponNumber int not null, weaponName int not null, handed int not null, attackType text, minDamage int not null, maxDamage int not null, attribute text, rarity int not null, "
			+"weight int not null, dropRate int not null);
		String sql = "CREATE TABLE Weapon() "
				+"Values()";
		sdb.updateDB(sql);

		sql = "INSERT INTO Weapon()";
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
		String sql = "CREATE TABLE Monster(monsterNumber int Primary Key not Null, monsterName text not null, monsterDescription text not null, immune text not null, hitPoints int not null, "
				+"minDamage int not null, maxDamage int not null, commonDrop int not null, uncommonDrop int not null, rareDrop int not null, "
				+"legendaryDrop int not null, spawnChance int not null)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(1, 'Skeletal Archer', 'Ranged', 'none', 30, 6, 10, 60, 25, 10, 5, 15)";
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
