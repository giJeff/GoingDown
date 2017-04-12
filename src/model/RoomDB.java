package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Room;

/** Class : RoomDB.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Mar 01, 2017
 *
 * This class handles all of the DB interactions for Rooms
 */
public class RoomDB
{
	/** Method: getNextRoomID
	 * Purpose: gets the next ID for a room 
	 * @return int
	 */
	public int getNextRoomID()
	{
		SQLiteDB sdb  = null;
		try
		{
			sdb = new SQLiteDB();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return sdb.getMaxValue("roomNumber", "room") + 1;
	}
	
	/** Method: getRoom
	 * Purpose: Gets a room based upon the supplied ID
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
			System.out.println(rs.getInt("roomNumber"));
			rm.setRoomID(rs.getInt("roomNumber"));
			rm.setRoomName(rs.getString("roomName"));
			rm.setRoomDescription(rs.getString("roomDescription"));
			rm.setExitNorth(rs.getInt("exitNorth"));
			rm.setExitEast(rs.getInt("exitEast"));
			rm.setExitSouth(rs.getInt("exitSouth"));
			rm.setExitWest(rs.getInt("exitWest"));
		}
		sdb.close();
		return rm;
	}
	
	/** Method: getAllRooms
	 * Purpose: gets all rooms
	 * @return ArrayList<Room>
	 * @throws SQLException
	 */
	public ArrayList<Room> getAllRooms() throws SQLException
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Room";
		
		ResultSet rs = sdb.queryDB(sql);
		
		while(rs.next())
		{
			Room rm = new Room();
			rm.setRoomID(rs.getInt("roomNumber"));
			rm.setRoomName(rs.getString("roomName"));
			rm.setRoomDescription(rs.getString("roomDescription"));
			rm.setExitNorth(rs.getInt("exitNorth"));
			rm.setExitEast(rs.getInt("exitEast"));
			rm.setExitSouth(rs.getInt("exitSouth"));
			rm.setExitWest(rs.getInt("exitWest"));
			rooms.add(rm);
		}
		
		sdb.close();
		return rooms;
	}
}
