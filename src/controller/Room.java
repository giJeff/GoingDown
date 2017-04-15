package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.RoomDB;

/** Class : Room.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Mar 01, 2017
 *
 * This class is the business logic for the Room objects
 */
public class Room
{
	private int roomID;
	private int floorNumber;
	private String roomName;
	private String roomDescription;
	
	private int exitNorth;
	private int exitEast;
	private int exitSouth;
	private int exitWest; 
	private int roomClear;
	private int isFloorExit; 
	private int isPuzzleRoom;
	private int isMonsterRoom;
	private int isBossRoom;
	private int isSafeRoom;

	/** Constructor: Room
	 */
	public Room()
	{
		RoomDB  rdb = new RoomDB();
		roomID = rdb.getNextRoomID();
	}
	
	/** Method: getRoom
	 * Purpose: Retrieves a room based upon the supplied ID
	 * @param id
	 * @return Room
	 * @throws SQLException
	 */
	public Room getRoom(int id) throws SQLException
	{
		RoomDB rdb = new RoomDB();
		return rdb.getRoom(id);
	}
	
	public ArrayList<Room> getAllRooms() throws SQLException
	{
		RoomDB rdb = new RoomDB();
		return rdb.getAllRooms();
	}

	/** Method: getRoomID
	 * @return the roomID
	 */
	public int getRoomID()
	{
		return roomID;
	}

	/** Method: setRoomID
	 * @param roomID the roomID to set
	 */
	public void setRoomID(int roomID)
	{
		this.roomID = roomID;
	}

	/** Method: getRoomName
	 * @return the roomName
	 */
	public String getRoomName()
	{
		return roomName;
	}

	/** Method: setRoomName
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName)
	{
		this.roomName = roomName;
	}

	/** Method: getRoomDescription
	 * @return the roomDescription
	 */
	public String getRoomDescription()
	{
		return roomDescription;
	}

	/** Method: setRoomDescription
	 * @param roomDescription the roomDescription to set
	 */
	public void setRoomDescription(String roomDescription)
	{
		this.roomDescription = roomDescription;
	}



	/**
	 * @return the floorNumber
	 */
	public int getFloorNumber() {
		return floorNumber;
	}

	/**
	 * @param floorNumber the floorNumber to set
	 */
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	/**
	 * @return the exitNorth
	 */
	public int getExitNorth() {
		return exitNorth;
	}

	/**
	 * @param exitNorth the exitNorth to set
	 */
	public void setExitNorth(int exitNorth) {
		this.exitNorth = exitNorth;
	}

	/**
	 * @return the exitEast
	 */
	public int getExitEast() {
		return exitEast;
	}

	/**
	 * @param exitEast the exitEast to set
	 */
	public void setExitEast(int exitEast) {
		this.exitEast = exitEast;
	}

	/**
	 * @return the exitSouth
	 */
	public int getExitSouth() {
		return exitSouth;
	}

	/**
	 * @param exitSouth the exitSouth to set
	 */
	public void setExitSouth(int exitSouth) {
		this.exitSouth = exitSouth;
	}

	/**
	 * @return the exitWest
	 */
	public int getExitWest() {
		return exitWest;
	}

	/**
	 * @param exitWest the exitWest to set
	 */
	public void setExitWest(int exitWest) {
		this.exitWest = exitWest;
	}

	/**
	 * @return the roomClear
	 */
	public int getRoomClear() {
		return roomClear;
	}

	/**
	 * @param roomClear the roomClear to set
	 */
	public void setRoomClear(int roomClear) {
		this.roomClear = roomClear;
	}

	/**
	 * @return the isFloorExit
	 */
	public int getIsFloorExit() {
		return isFloorExit;
	}

	/**
	 * @param isFloorExit the isFloorExit to set
	 */
	public void setIsFloorExit(int isFloorExit) {
		this.isFloorExit = isFloorExit;
	}

	/**
	 * @return the isPuzzleRoom
	 */
	public int getIsPuzzleRoom() {
		return isPuzzleRoom;
	}

	/**
	 * @param isPuzzleRoom the isPuzzleRoom to set
	 */
	public void setIsPuzzleRoom(int isPuzzleRoom) {
		this.isPuzzleRoom = isPuzzleRoom;
	}

	/**
	 * @return the isMonsterRoom
	 */
	public int getIsMonsterRoom() {
		return isMonsterRoom;
	}

	/**
	 * @param isMonsterRoom the isMonsterRoom to set
	 */
	public void setIsMonsterRoom(int isMonsterRoom) {
		this.isMonsterRoom = isMonsterRoom;
	}

	/**
	 * @return the isBossRoom
	 */
	public int getIsBossRoom() {
		return isBossRoom;
	}

	/**
	 * @param isBossRoom the isBossRoom to set
	 */
	public void setIsBossRoom(int isBossRoom) {
		this.isBossRoom = isBossRoom;
	}

	/**
	 * @return the isSafeRoom
	 */
	public int getIsSafeRoom() {
		return isSafeRoom;
	}

	/**
	 * @param isSafeRoom the isSafeRoom to set
	 */
	public void setIsSafeRoom(int isSafeRoom) {
		this.isSafeRoom = isSafeRoom;
	}

	/** Method: toString
	 * Purpose: 
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Room roomID = " + roomID  + "\nfloorNumber = " + floorNumber + "\nroomName = " + roomName + "\nroomDescription = " 
				+ roomDescription + "\nexitNorth = " + exitNorth + "\nexitEast = " + exitEast  + "\nexitSouth = " + exitSouth
				 + "\nexitWest = " + exitWest + "\nroomClear = " + roomClear + "\nisFloorExit = " + isFloorExit
				 + "\nisPuzzleRoom = " + isPuzzleRoom + "\nisMonsterRoom = " + isMonsterRoom + "\nisBossRoom = " + isBossRoom
				 + "\nisSafeRoom = " + isSafeRoom;
	}
	
}
