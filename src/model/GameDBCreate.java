package model;

import java.sql.SQLException;

import controller.GameController;

/** Class : GameDBCreate
 * @author: Jeff Graves
 * @version: 1.0
 * Course: 
 * Written: April 1, 2017
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
		buildWeapon();
		buildArmor();
		buildPotion();
		buildPlayer();
		buildPuzzle();
		//buildMonsterRoom();
	}
	
	/** Method: buildRoom
	 * Purpose: Build the Room table and load data
	 * @throws SQLException
	 * @return void
	 */
	public void buildRoom() throws SQLException
	{
	    sdb = GameController.getDB();
		String sql = "CREATE TABLE Room(roomNumber int Primary Key not null, floorNumber int not null, roomName text not null,"
				+ " roomDescription text not null, exitNorth int, exitEast int, exitSouth int, exitWest int, roomClear int not null,"
				+ " isFloorExit int not null, isPuzzleRoom int not null, isMonsterRoom int not null, isBossRoom int not null,"
				+ " isSafeRoom int not null)";
		sdb.updateDB(sql);

		
		//FLOOR 1 ***********************************************************************************************************************
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(1, 1, 'Entrance', 'This is the entrance room', 0, 2, 0, 0, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(2, 1, 'Monster', 'This is a monster room', 3, 5, 4, 1, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(3, 1, 'Puzzle', 'This is a puzzle room', 0, 0, 2, 0, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(4, 1, 'Monster', 'This is a monster room', 2, 0, 0, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(5, 1, 'Boss', 'This is a boss room', 0, 6, 0, 2, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(6, 1, 'Safe', 'This is a safe room', 0, 7, 0, 5, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(7, 1, 'Exit', 'This is an exit room', 0, 0, 0, 6, 0, 1, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				
		// FLOOR 2 *******************************************************************************************************************		
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(8, 2, 'Entrance', 'This is the entrance room', 16, 0, 0, 9, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(9, 2, 'Monster', 'This is the monster room', 0, 8, 0, 10, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);
			
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(10, 2, 'Boss', 'This is the Boss room', 15, 9, 0, 11, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(11, 2, 'Monster', 'This is the monster room', 14, 10, 0, 12, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(12, 2, 'Puzzle', 'This is the puzzle room', 13, 11, 0, 0, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(13, 2, 'Monster', 'This is the monster room', 0, 14, 12, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(14, 2, 'Safe', 'This is a safe room', 0, 15, 11, 13, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(15, 2, 'Monster', 'This is the monster room', 19, 0, 10, 14, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(16, 2, 'Monster', 'This is the monster room', 17, 0, 8, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(17, 2, 'Safe', 'This is a safe room', 0, 0, 16, 18, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);
				
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(18, 2, 'Monster', 'This is the monster room', 0, 17, 0, 19, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(19, 2, 'Puzzle', 'This is the puzzle room', 20, 18, 15, 0, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(20, 2, 'Monster', 'This is the monster room', 24, 0, 19, 21, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(21, 2, 'Safe', 'This is a safe room', 23, 20, 0, 22, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(22, 2, 'Monster', 'This is the monster room', 0, 21, 0, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(23, 2, 'Boss', 'This is the Boss room', 0, 24, 21, 0, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(24, 2, 'Monster', 'This is the monster room', 0, 25, 20, 23, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(25, 2, 'Exit', 'This is an exit room', 0, 26, 0, 24, 0, 1, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(26, 2, 'Boss', 'This is the Boss room', 0, 0, 0, 25, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);


		// FLOOR 3 *******************************************************************************************************************		
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(27, 3, 'Entrance', 'This is the entrance room', 28, 0, 38, 0, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(28, 3, 'Monster', 'This is the monster room', 0, 0, 27, 29, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(29, 3, 'Puzzle', 'This is the puzzle room', 0, 28, 0, 30, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);
				
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(30, 3, 'Monster', 'This is the monster room', 0, 29, 0, 31, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(31, 3, 'Boss', 'This is the Boss room', 0, 30, 32, 0, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);
			
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(32, 3, 'Safe', 'This is a safe room', 31, 0, 35, 33, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(33, 3, 'Monster', 'This is the monster room', 0, 32, 34, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);
				
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(34, 3, 'Puzzle', 'This is the puzzle room', 33, 35, 41, 0, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(35, 3, 'Exit', 'This is an exit room', 32, 36, 0, 34, 0, 1, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(36, 3, 'Monster', 'This is the monster room', 0, 37, 40, 35, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(37, 3, 'Monster', 'This is the monster room', 0, 38, 0, 36, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(38, 3, 'Puzzle', 'This is the puzzle room', 27, 0, 39, 37, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(39, 3, 'Monster', 'This is the monster room', 38, 0, 45, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);
				
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(40, 3, 'Safe', 'This is a safe room', 36, 0, 44, 0, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(41, 3, 'Monster', 'This is the monster room', 34, 0, 42, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);
				
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(43, 3, 'Boss', 'This is the Boss room', 0, 44, 0, 42, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(44, 3, 'Monster', 'This is the monster room', 40, 0, 0, 43, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(45, 3, 'Puzzle', 'This is the puzzle room', 39, 0, 0, 0, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);


		// FLOOR 4 *******************************************************************************************************************
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(46, 4, 'Entrance', 'This is the entrance room', 0, 47, 53, 0, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(47, 4, 'Monster', 'This is the monster room', 0, 48, 52, 46, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(48, 4, 'Monster', 'This is the monster room', 0, 49, 51, 47, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(49, 4, 'Safe', 'This is a safe room', 0, 50, 0, 48, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(50, 4, 'Boss', 'This is the Boss room', 0, 0, 0, 49, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(51, 4, 'Monster', 'This is the monster room', 48, 0, 55, 52, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(52, 4, 'Safe', 'This is a safe room', 47, 51, 54, 53, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(53, 4, 'Puzzle', 'This is the puzzle room', 46, 52, 0, 0, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(54, 4, 'Monster', 'This is the monster room', 52, 55, 60, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);	

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(55, 4, 'Puzzle', 'This is the puzzle room', 51, 56, 0, 54, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(56, 4, 'Monster', 'This is the monster room', 0, 57, 59, 55, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(57, 4, 'Boss', 'This is the Boss room', 0, 0, 58, 56, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(58, 4, 'Monster', 'This is the monster room', 57, 0, 0, 59, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(59, 4, 'Safe', 'This is a safe room', 56, 58, 64, 0, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);
				
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(60, 4, 'Monster', 'This is the monster room', 54, 0, 62, 61, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(61, 4, 'Exit', 'This is an exit room', 0, 60, 0, 0, 0, 1, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(62, 4, 'Puzzle', 'This is the puzzle room', 60, 63, 0, 0, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(63, 4, 'Boss', 'This is the Boss room', 0, 64, 0, 62, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(64, 4, 'Monster', 'This is the monster room', 59, 0, 0, 63, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				
		// FLOOR 5 *******************************************************************************************************************
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(65, 5, 'Entrance', 'This is the entrance room', 0, 72, 0, 0, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom)"
						+ "Values(66, 5, 'Boss', 'This is the Boss room', 0, 67, 72, 0, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(67, 5, 'Monster', 'This is the monster room', 0, 68, 71, 66, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(68, 5, 'Boss', 'This is the Boss room', 0, 69, 70, 67, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(69, 5, 'Monster', 'This is the monster room', 0, 0, 0, 68, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);
				
				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(70, 5, 'Safe', 'This is a safe room', 68, 0, 74, 71, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(71, 5, 'Monster', 'This is the monster room', 67, 70, 73, 72, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(72, 5, 'Safe', 'This is a safe room', 66, 71, 0, 65, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(73, 5, 'Puzzle', 'This is the puzzle room', 71, 74, 77, 0, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(74, 5, 'MegaBoss', 'This is the MegaBoss room', 70, 0, 76, 73, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(75, 5, 'Puzzle', 'This is the puzzle room', 0, 0, 83, 76, 0, 0, 1, 0, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(76, 5, 'Safe', 'This is a safe room', 74, 75, 82, 77, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(77, 5, 'Monster', 'This is the monster room', 73, 76, 81, 78, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(78, 5, 'Safe', 'This is a safe room', 0, 77, 0, 79, 0, 0, 0, 0, 0, 1)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(79, 5, 'Monster', 'This is the monster room', 0, 78, 80, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(80, 5, 'Monster', 'This is the monster room', 79, 0, 0, 0, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(81, 5, 'Boss', 'This is the Boss room', 77, 82, 0, 0, 0, 0, 0, 0, 1, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(82, 5, 'Monster', 'This is the monster room', 76, 83, 0, 81, 0, 0, 0, 1, 0, 0)";
				sdb.updateDB(sql);

				sql = "INSERT INTO Room(roomNumber, floorNumber, roomName, roomDescription, exitNorth, exitEast, exitSouth, exitWest,"
						+ " roomClear, isFloorExit, isPuzzleRoom, isMonsterRoom, isBossRoom, isSafeRoom) "
						+ "Values(83, 5, 'Boss', 'This is the Boss room', 75, 0, 0, 82, 0, 0, 0, 0, 1, 0)";
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
		String sql = "CREATE TABLE Monster(monsterNumber int Primary Key not Null, monsterName text not null,"
				+ " monsterDescription text not null, immune text not null, hitPoints int not null, "
				+"minDamage int not null, maxDamage int not null, attackFirst int not null,"
				+ " turnToHitPlayer int not null, commonDrop int not null, uncommonDrop int not null, rareDrop int not null, "
				+"legendaryDrop int not null, spawnChance int not null)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(1, 'Skeletal Archer', 'Ranged', 'none', 30, 6, 10, 1, 0, 60, 25, 10, 5, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(2, 'Gaurd', 'Melee', 'none', 50, 10, 20, 0, 0, 60, 25, 10, 5, 20)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(3, 'Gargoyle', 'Melee', 'Melee', 20, 4, 8, 1, 0, 75, 15, 7, 3, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(4, 'Skeleton', 'Melee', 'Poison', 40, 8, 12, 0, 1, 70, 15, 10, 5, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(5, 'Golem', 'Melee', 'Fire', 100, 15, 25, 0, 3, 10, 40, 40, 10, 5)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(6, 'Dragon', 'Ranged', 'Fire', 80, 20, 30, 0, 0, 15, 30, 30, 25, 5)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(7, 'Undead', 'Melee', 'none', 20, 3, 6, 0, 1, 84, 10, 5, 1, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(8, 'Spearman', 'Ranged', 'none', 50, 6, 15, 1, 0, 70, 15, 10, 5, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(9, 'Goblin', 'Melee', 'none', 25, 4, 10, 1, 0, 45, 25, 15, 15, 5)";
		sdb.updateDB(sql);
		
//START ELITE MONSTERS     !!!!!!!*****#**#&*@#*(@(

		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(10, 'Elite Skeletal Archer', 'Ranged', 'none', 75, 15, 25, 1, 0, 0, 40, 30, 30, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(11, 'Elite Gaurd', 'Melee', 'none', 125, 25, 50, 0, 0, 0, 40, 30, 30, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(12, 'Elite Gargoyle', 'Melee', 'Melee', 50, 10, 20, 1, 0, 0, 40, 30, 30, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(13, 'Elite Skeleton', 'Melee', 'Poison', 100, 20, 30, 0, 1, 0, 40, 30, 30, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(14, 'Elite Golem', 'Melee', 'Fire', 250, 40, 65, 0, 3, 0, 40, 30, 30, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(15, 'Elite Dragon', 'Ranged', 'Fire', 200, 50, 75, 0, 0, 0, 40, 30, 30, 15)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Monster(monsterNumber, monsterName, monsterDescription, immune, hitPoints, minDamage, maxDamage,"
				+ "attackFirst, turnToHitPlayer, commonDrop, uncommonDrop, rareDrop, legendaryDrop, spawnChance) " 
				+ " Values(16, 'Elite Spearman', 'Ranged', 'none', 125, 15, 40, 1, 0, 0, 40, 30, 30, 15)";
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
	
	/** Method: buildWeapon
	 * Purpose: Build the Weapon table and load data
	 * @throws SQLException
	 * @return void
	 */
	public void buildWeapon() throws SQLException
	{
		sdb = GameController.getDB();
		String sql = "CREATE TABLE Weapon(weaponNumber int Primary Key not null, weaponName text not null, equipSlot int not null, "
				+ "attackType text not null, minDamage int not null, maxDamage int not null, extra text not null, "
				+ "commonDamage float(2) not null, uncommonDamage float(2) not null, rareDamage float(2) not null, "
				+ "legendaryDamage float(2) not null, weight float(2) not null)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(1, 'Knights Zweihander', 2, 'melee', 30, 60, 'none', 1.00, 1.10, 1.25, 1.50, 30)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(2, 'Xiphos', 1, 'melee', 20, 30, 'none', 1.00, 1.10, 1.25, 1.50, 20)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(3, 'Serpents Sabre', 1, 'melee', 20, 25, 'none', 1.00, 1.10, 1.25, 1.50, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(4, 'Spark Sword', 1, 'melee', 12, 18, 'all', 1.00, 1.10, 1.25, 1.50, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(5, 'Lightning Staff', 2, 'melee', 12, 20, 'lightning', 1.00, 1.10, 1.25, 1.50, 25)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(6, 'Maple Bow', 1, 'ranged', 0, 0, 'none', 1.00, 1.10, 1.25, 1.50, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(7, 'Bow of Slaying', 1, 'ranged', 0, 0, 'none', 1.10, 1.25, 1.50, 1.75, 15)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(8, 'Buckler', 0, 'shield', 0, 0, 'block10', 1.00, 1.10, 1.25, 1.50, 5)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(9, 'Skirmishers Kite Shield', 0, 'shield', 0, 0, 'block20', 1.00, 1.10, 1.25, 1.50, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(10, 'Crusaders Shield', 0, 'shield', 0, 0, 'block30', 1.00, 1.10, 1.25, 1.50, 20)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(11, 'Arrow', 0, 'arrow', 10, 20, 'none', 1.00, 1.10, 1.25, 1.50, 0.5)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(12, 'Poison Arrow', 0, 'arrow', 8, 16, 'Poison', 1.00, 1.10, 1.25, 1.50, 0.5)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(13, 'Flame Arrow', 0, 'arrow', 12, 18, 'Fire', 1.00, 1.10, 1.25, 1.50, 0.5)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Weapon(weaponNumber, weaponName, equipSlot, attackType, minDamage, maxDamage, extra, "
				+ "commonDamage, uncommonDamage, rareDamage, legendaryDamage, weight) "
				+ "Values(14, 'Lightning Arrow', 0, 'arrow', 8, 12, 'lightning', 1.00, 1.10, 1.25, 1.50, 0.5)";
		sdb.updateDB(sql);
		
		sdb.close();
	}

	/** Method: buildArmor
	 * Purpose: Build the Armor table and load data
	 * @throws SQLException
	 * @return void
	 */
	public void buildArmor() throws SQLException
	{
		sdb = GameController.getDB();
		String sql = "CREATE TABLE Armor(armorNumber int Primary Key not Null, equipSlot int not null, armorType text not null,"
				+ " commonDamageReduction float not null, uncommonDamageReduction float not null, rareDamageReduction float not null,"
				+ " legendaryDamageReduction float not null, weight float not null)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Armor(armorNumber, armorType, equipSlot,commonDamageReduction, uncommonDamageReduction, "
				+ "rareDamageReduction, legendaryDamageReduction, weight) "
				+ "Values(1, 'Helmet', 3, 0.99, 0.98, 0.95, 0.90, 2)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Armor(armorNumber, armorType, equipSlot,commonDamageReduction, uncommonDamageReduction, "
				+ "rareDamageReduction, legendaryDamageReduction, weight) "
				+ "Values(2, 'Chestpiece', 4, 0.99, 0.98, 0.95, 0.90, 4)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Armor(armorNumber, armorType, equipSlot,commonDamageReduction, uncommonDamageReduction, "
				+ "rareDamageReduction, legendaryDamageReduction, weight) "
				+ "Values(3, 'Legs', 5, 0.99, 0.98, 0.95, 0.90, 3)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Armor(armorNumber, armorType, equipSlot,commonDamageReduction, uncommonDamageReduction, "
				+ "rareDamageReduction, legendaryDamageReduction, weight) "
				+ "Values(4, 'Gloves', 6, 0.99, 0.98, 0.95, 0.90, 0.5)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Armor(armorNumber, armorType, equipSlot,commonDamageReduction, uncommonDamageReduction, "
				+ "rareDamageReduction, legendaryDamageReduction, weight) "
				+ "Values(5, 'Boots', 7, 0.99, 0.98, 0.95, 0.90, 0.5)";
		sdb.updateDB(sql);
		
		sdb.close();
	}
	
	/** Method: buildArmor
	 * Purpose: Build the Armor table and load data
	 * @throws SQLException
	 * @return void
	 */
	public void buildPotion() throws SQLException
	{
		sdb = GameController.getDB();
		String sql = "CREATE TABLE Potion(potionNumber int Primary Key not Null, potionName text not null, healPerTurn int not null,"
				+ " numberOfTurn int not null,  extra text not null, weight float(2) not null)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Potion(potionNumber, potionName, healPerTurn, numberOfTurn,  extra, weight) "
				+ "Values(1, 'Health Potion', 30, 0, 'none', 0.1)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Potion(potionNumber, potionName, healPerTurn, numberOfTurn,  extra, weight) "
				+ "Values(2, 'Greater Health Potion', 60, 0, 'none', 0.1)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Potion(potionNumber, potionName, healPerTurn, numberOfTurn,  extra, weight) "
				+ "Values(3, 'Max Health Potion', 0, 0, 'all', 0.1)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Potion(potionNumber, potionName, healPerTurn, numberOfTurn,  extra, weight) "
				+ "Values(4, 'Regen Health Potion', 12, 15, 'none', 0.1)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Potion(potionNumber, potionName, healPerTurn, numberOfTurn,  extra, weight) "
				+ "Values(5, 'Greater Regen Health Potion', 15, 10, 'none', 0.1)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Potion(potionNumber, potionName, healPerTurn, numberOfTurn,  extra, weight) "
				+ "Values(6, 'Cure Potion', 0, 0, 'cure', 0.1)";
		sdb.updateDB(sql);
		
		
		sdb.close();
	}
	
	public void buildPlayer() throws SQLException
	{
		sdb = GameController.getDB();
		String sql = "CREATE TABLE Player(playerNumber int Primary Key not Null, playerName text not null, gender text not null,"
				+ " hitPoints int not null, minDamage int not null, maxDamage int not null, score int not null, numKilled int not null,"
				+ " numSolved int not null, weight float(2) not null, maxWeight float(2) not null, currentRoom int not null,"
				+ " peekNorth int not null, peekEast int not null, peekSouth int not null, peekWest int not null)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Player(playerNumber, playerName, gender, hitPoints, minDamage, maxDamage, score, numKilled,"
				+ " numSolved, weight, maxWeight, currentRoom, peekNorth, peekEast, peekSouth, peekWest) "
				+ "Values(1, 'Name', 'Male', 100, 20, 30, 0, 0, 0, 0, 100, 1, 0, 0, 0, 0)";
		sdb.updateDB(sql);
		
		sdb.close();
	}
	
	public void buildPuzzle() throws SQLException
	{
		sdb = GameController.getDB();
		String sql = "CREATE TABLE Puzzles(puzzleID int Primary Key not null, puzzleQuestion text not null, puzzleAnswer text not null, "
				+ "optA text not null, optB text not null, optC text not null, optD text, "
				+ "incorrectDamage int not null, correctReward int not null)";	
				
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(1, 'A man went into a party and drank some of the grey punch. He then left early. "
				+ "Everyone at the party who drunk the gray punch subsequently died of poisoning. "
				+ "What color punch did the man drink?', 'd',"
				+ "'a. Pink', 'b. Blue', 'c. Gray', 'd. Grey', 5, 10)";
		sdb.updateDB(sql);

		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(2, 'Are the Nobel prizes awarded every year, every 5 years or every 10 years?, 'a',"
				+ "'a. Every year', 'b. 5 years', 'c. 10 years', 'd. Once in a while', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(3, 'What belongs to you but others use it more than you do?, 'c', "
				+ "'a. Your phone', 'b. Your toilet', 'c. Your name', 'd. Your time', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(4, 'What can you keep but cannot share and once you share it you can't keep it anymore?, 'a', "
				+ "'a. A secret', 'b. Food', 'c. Homework answers', 'd. Your bestie's number', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(5, 'What has six eyes, but can not see?, 'a', "
				+ "'a. Three blind mice', 'b. A spider', 'c. A fly', 'd. A praying mantis', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(6, 'Whats 3/7 chicken, 2/3 cat, and 2/4 goat?, 'b', "
				+ "'a. A weird meal', 'b. Chicago', 'c. A science project gone wrong', null, 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(7, 'How can FIVE minus TWO equal 4?, 'a', "
				+ "'a. Roman Numerals', 'b. By magic', 'c. Not possible', 'd. I don't know', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(8, 'You will always find me in the past. I can be created in the present, "
				+ "But the future can never taint me. What am I?, 'a', "
				+ "'a. History', 'b. A newspaper', 'c. Last weeks lunch', 'd. A memory', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(9, 'He who builds me doesn't want me. He who buys me doesn't use me. "
				+ "He that uses me doesn't know he's in me, 'b', "
				+ "'a. A tree', 'b. A mountain', 'c. A valley', null, 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(10, 'What does this say: A bird in the the bush.', 'c', "
				+ "'a.	A space bird in the space the bush', 'b. A bird in the bush', 'c. A bird in the the bush.', null, 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(11, 'What goes up and down without moving?', 'd',"
				+ "'a. A staircase', 'b. The temperature', 'c. A thermometer.', 'd. All of the above', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(12, 'What is harder to catch the faster you run?', 'b',"
				+ "'a. A ball', 'b. Your breath', 'c. A cheetah.', 'd. A break', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(13, '16.	What mathematical symbol can be placed between 5 and 9"
				+ "to get a number greater than 5 and smaller than 9?', 'c',"
				+ "'a. A plus sign', 'b. A dash', 'c. A decimal point', null, 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(14, 'What is greater than God. More evil than the devil. The poor have it. The rich need it."
				+ "and if you eat it, you'll die?', 'c','a.	McDonalds', 'b. Fruit cake', 'c. Nothing', null, 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(15, 'What can travel around the world while staying in a corner?',"
				+ "'b', 'a.	You on your computer', 'b. A stamp', 'c. A troll.', null, 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(16, 'He has married many women, but has never been married. Who is he?', 'c',"
				+ "'a. The Pope', 'b. A Shaman', 'c. A priest.', 'd. A Rabi', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(17, 'Which creature walks on four legs in the morning, two legs in the afternoon, and three legs in the evening?', 'c',"
				+ "'a. A fish ', 'b. A dog', 'c. A man', 'd. A cat', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(18, 'What invention lets you look right through a wall?', 'a',"
				+ "'a. A window ', 'b. A door', 'c. Sunglasses', 'd. Nothing', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(19, 'Which weighs more, a pound of feathers or a pound of bricks?', 'd',"
				+ "'a. Feathers ', 'b. Bricks', 'c. They weigh the same amounts.', 'd. They weigh the same.', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(20, 'What occurs once in every minute, twice in every moment, yet never in a thousand years?', 'd',"
				+ "'a. A shooting star ', 'b. A blue moon', 'c. A raise in your paycheck.', 'd. M', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(21, 'It takes 10 minutes to fry one steak – 5 minutes from each side. Two steaks can fit on a pan. "
				+ "What is the shortest possible time to fry 3 steaks?', 'c',"
				+ "'a. 20 minutes', 'b. 30 minutes', 'c. 15 minutes', 'd. 10 minutes', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(22, 'If you look at the number on my face you won't find thirteen anyplace. What am I?', 'c',"
				+ "'a. Your face ', 'b. A book', 'c. A clock', null, 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(23, 'What is it that's always coming but never arrives?', 'd',"
				+ "'a. The pakage from Amazon', 'b. A raise in your paycheck', 'c. That A in chemistry', 'd. Tommorrow', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(24, 'Which plural form is incorrect: monkeys, cats, deers, giraffes?', 'c',"
				+ "'a. Cats ', 'b. Monkeys', 'c. Deers', 'd. Giraffes', 5, 10)";
		sdb.updateDB(sql);		

		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(25, 'What comes up when the rain comes down?', 'c',"
				+ "'a. The sun ', 'b. Sunscreen', 'c. An umbrella', null, 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(26, 'What gets wetter the more it drys?', 'd',"
				+ "'a. A pool ', 'b. The sun', 'c. An umbrella', 'd. A towel', 5, 10)";
		sdb.updateDB(sql);
		
		sql = "INSERT INTO Puzzles(puzzleNumber, puzzleQuestion, puzzleAnswer, optA, optB, optC, optD, "
				+ "incorrectDamage, correctReward) "
				+ "Values(27, 'What number can you take half of and leave nothing?', 'a',"
				+ "'a. 8', 'b. 4', 'c. 2', 'd. 9', 5, 10)";
		
		sdb.close();
	}

}
