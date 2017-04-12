package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MonsterRoomDB;


public class MonsterRoom {
	
	private int monsterNumber;
	private String monsterName;
	private String monsterDescription;
	private int hitPoints;
	private int maxDamage;
	private int minDamage;
	private int elemantalDamage;
	private int damagePerTurn;
	private int numTurns;
	private int roomNumber;
	private String roomName;
	private String roomDescription;
	
	/** Method: getMonster
	 * Purpose: Get the monster in a specific room
	 * @param id
	 * @return MonsterROom
	 * @throws SQLException
	 */
	public MonsterRoom getMonster(int roomID) throws SQLException {
		MonsterRoomDB  mdb = new MonsterRoomDB();
		return mdb.getMonster(roomID);
	}
	
	/** Method: getAllMonsters
	 * Purpose: gets all mosters and their associated rooms
	 * @return ArrayList<MonsterRoom>
	 * @throws SQLException
	 */
	public ArrayList<MonsterRoom> getAllMonsters() throws SQLException {
		MonsterRoomDB  mdb = new MonsterRoomDB();
		return mdb.getAllMonsters();
	}

	public int getMonsterNumber() {
		return monsterNumber;
	}

	public void setMonsterNumber(int monsterNumber) {
		this.monsterNumber = monsterNumber;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getMonsterDescription() {
		return monsterDescription;
	}

	public void setMonsterDescription(String monsterDescription) {
		this.monsterDescription = monsterDescription;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getElemantalDamage() {
		return elemantalDamage;
	}

	public void setElemantalDamage(int elemantalDamage) {
		this.elemantalDamage = elemantalDamage;
	}

	public int getDamagePerTurn() {
		return damagePerTurn;
	}

	public void setDamagePerTurn(int damagePerTurn) {
		this.damagePerTurn = damagePerTurn;
	}

	public int getNumTurns() {
		return numTurns;
	}

	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
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


	@Override
	public String toString() {
		return "MonsterRoom,  monsterNumber = " + monsterNumber + ", monsterName = " + monsterName + "\n monsterDescription = "
				+ monsterDescription + "\nwith hitPoints = " + hitPoints + " causing maxDamage = " + maxDamage + " and minDamage = "
				+ minDamage + ".\nIs in roomNumber = " + roomNumber + ", roomName = " + roomName + ", roomDescription = "
				+ roomDescription;
	}

	
}
