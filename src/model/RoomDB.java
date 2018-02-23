package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Room;

/**
 * Class : RoomDB.java
 * 
 * @author: Jeff Graves
 * @version: 1.0 Course: ITEC 3860 Written: Mar 01, 2017
 *
 *           This class handles all of the DB interactions for Rooms
 */
public class RoomDB
{
	/**
	 * Method: getNextRoomID Purpose: gets the next ID for a room
	 * 
	 * @return int
	 * @throws SQLException
	 */
	public int getNextRoomID() throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		int max = sdb.getMaxValue("roomNumber", "room") + 1;
		sdb.close();
		return max;
	}

	/**
	 * Method: getRoom Purpose: Gets a room based upon the supplied ID
	 * 
	 * @param id
	 * @return Room
	 * @throws SQLException
	 */
	public Room getRoom(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Room rm = new Room();
		String sql = "Select * from Room WHERE roomNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			rm.setRoomID(rs.getInt("roomNumber"));
			rm.setFloorNumber(rs.getInt("floorNumber"));
			rm.setRoomID(rs.getInt("roomNumber"));
			rm.setRoomName(rs.getString("roomName"));
			rm.setRoomDescription(rs.getString("roomDescription"));
			rm.setExitNorth(rs.getInt("exitNorth"));
			rm.setExitEast(rs.getInt("exitEast"));
			rm.setExitSouth(rs.getInt("exitSouth"));
			rm.setExitWest(rs.getInt("exitWest"));
			rm.setRoomClear(rs.getInt("roomClear"));
			rm.setIsFloorExit(rs.getInt("isFloorExit"));
			rm.setIsPuzzleRoom(rs.getInt("isPuzzleRoom"));
			rm.setIsMonsterRoom(rs.getInt("isMonsterRoom"));
			rm.setIsBossRoom(rs.getInt("isBossRoom"));
			rm.setIsSafeRoom(rs.getInt("isSafeRoom"));
		}
		sdb.close();
		return rm;
	}

	/**
	 * Method: getAllRooms Purpose: gets all rooms
	 * 
	 * @return ArrayList<Room>
	 * @throws SQLException
	 */
	public ArrayList<Room> getAllRooms() throws SQLException
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Room";

		ResultSet rs = sdb.queryDB(sql);

		while (rs.next())
		{
			Room rm = new Room();
			rm.setRoomID(rs.getInt("roomNumber"));
			rm.setFloorNumber(rs.getInt("floorNumber"));
			rm.setRoomID(rs.getInt("roomNumber"));
			rm.setRoomName(rs.getString("roomName"));
			rm.setRoomDescription(rs.getString("roomDescription"));
			rm.setExitNorth(rs.getInt("exitNorth"));
			rm.setExitEast(rs.getInt("exitEast"));
			rm.setExitSouth(rs.getInt("exitSouth"));
			rm.setExitWest(rs.getInt("exitWest"));
			rm.setRoomClear(rs.getInt("roomClear"));
			rm.setIsFloorExit(rs.getInt("isFloorExit"));
			rm.setIsPuzzleRoom(rs.getInt("isPuzzleRoom"));
			rm.setIsMonsterRoom(rs.getInt("isMonsterRoom"));
			rm.setIsBossRoom(rs.getInt("isBossRoom"));
			rm.setIsSafeRoom(rs.getInt("isSafeRoom"));
			rooms.add(rm);
		}

		sdb.close();
		return rooms;
	}

}
