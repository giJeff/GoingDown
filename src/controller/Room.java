package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.RoomDB;

public class Room {
	
		private int roomID;
		private String roomName;
		private String roomDescription;
		private int exitNorth;
		private int exitEast;
		private int exitSouth;
		private int exitWest; 
		private int roomClear; // 0 or 1 boolean value
		private int isFloorExit; // 0 or 1 boolean value
		private int isPuzzleRoom;
		private int isMonsterRoom;
		private int isBossRoom;
		private int isSafeRoom;
		
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
		public int getRoomID() {
			return roomID;
		}
		public void setRoomID(int roomID) {
			this.roomID = roomID;
		}
		public String getRoomName() {
			return roomName;
		}
		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}
		public String getRoomDescription() {
			return roomDescription;
		}
		public void setRoomDescription(String roomDescription) {
			this.roomDescription = roomDescription;
		}
		public int getExitNorth() {
			return exitNorth;
		}
		public void setExitNorth(int exitNorth) {
			this.exitNorth = exitNorth;
		}
		public int getExitEast() {
			return exitEast;
		}
		public void setExitEast(int exitEast) {
			this.exitEast = exitEast;
		}
		public int getExitSouth() {
			return exitSouth;
		}
		public void setExitSouth(int exitSouth) {
			this.exitSouth = exitSouth;
		}
		public int getExitWest() {
			return exitWest;
		}
		public void setExitWest(int exitWest) {
			this.exitWest = exitWest;
		}
		public int getRoomClear() {
			return roomClear;
		}
		public void setRoomClear(int roomClear) {
			this.roomClear = roomClear;
		}
		public int getIsFloorExit() {
			return isFloorExit;
		}
		public void setIsFloorExit(int isFloorExit) {
			this.isFloorExit = isFloorExit;
		}
		public int getIsPuzzleRoom() {
			return isPuzzleRoom;
		}
		public void setIsPuzzleRoom(int isPuzzleRoom) {
			this.isPuzzleRoom = isPuzzleRoom;
		}
		public int getIsMonsterRoom() {
			return isMonsterRoom;
		}
		public void setIsMonsterRoom(int isMonsterRoom) {
			this.isMonsterRoom = isMonsterRoom;
		}
		public int getIsBossRoom() {
			return isBossRoom;
		}
		public void setIsBossRoom(int isBossRoom) {
			this.isBossRoom = isBossRoom;
		}
		public int getIsSafeRoom() {
			return isSafeRoom;
		}
		public void setIsSafeRoom(int isSafeRoom) {
			this.isSafeRoom = isSafeRoom;
		}

}
