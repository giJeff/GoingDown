package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.QuestDB;
import model.SQLiteDB;

/** Class : Quest.java
 * @author: Jeff Graves
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 16, 2017
 *
 * This class is the Quest class handling business logic for the Quest class
 */
public class Quest
{

	private int questID;
	private String questDescription;
	private int monsterKilled;
	private int bossKilled;
	private int puzzleSolved;
	private int roomClear;

	/** Constructor: Quest
	 * @throws SQLException 
	 */
	public Quest() throws SQLException
	{
		QuestDB  qdb = new QuestDB();
		questID = qdb.getNextQuestID();
	}

	/** Method: getQuest
	 * Purpose: Gets a specified quest from the Quest table 
	 * @param id
	 * @return Quest
	 * @throws SQLException
	 */
	public Quest getQuest(int id) throws SQLException
	{
		QuestDB  qdb = new QuestDB();
		return qdb.getQuest(id);
	}

	/** Method: getAllQuests
	 * Purpose: gets all quests from the Quest table
	 * @return ArrayList<Quest>
	 * @throws SQLException
	 */
	public ArrayList<Quest> getAllQuests() throws SQLException
	{
		QuestDB  qdb = new QuestDB();
		return qdb.getAllQuests();
	}

	public void addMonster(Quest quest, Room room) throws SQLException {
		quest.setMonsterKilled(quest.getMonsterKilled()+1);
		int killed = quest.getMonsterKilled();
		SQLiteDB sdb = GameController.getDB();
		String sql = "UPDATE Quest Set monsterKilled = " + killed + " WHERE questNumber = " + room.getFloorNumber();
		sdb.updateDB(sql);
	}

	public void addBoss(Quest quest, Room room) throws SQLException {
		quest.setBossKilled(quest.getBossKilled()+1);
		int killed = quest.getBossKilled();
		SQLiteDB sdb = GameController.getDB();
		String sql = "UPDATE Quest Set bossKilled = " + killed + " WHERE questNumber = " + room.getFloorNumber();
		sdb.updateDB(sql);
	}

	public void addPuzzle(Quest quest, Room room) throws SQLException {
		quest.setPuzzleSolved(quest.getPuzzleSolved()+1);
		int solved = quest.getPuzzleSolved();
		SQLiteDB sdb = GameController.getDB();
		String sql = "UPDATE Quest Set puzzleSolved = " + solved + " WHERE questNumber = " + room.getFloorNumber();
		sdb.updateDB(sql);
	}

	public void addRoomClear(Quest quest, Room room) throws SQLException {
		quest.setRoomClear(quest.getRoomClear()+1);
		int clear = quest.getRoomClear();
		SQLiteDB sdb = GameController.getDB();
		String sql = "UPDATE Quest Set roomClear = " + clear + " WHERE questNumber = " + room.getFloorNumber();
		sdb.updateDB(sql);
	}

	public boolean questComplete(Quest quest, Room room) 
	{
		boolean complete = false;
		if(room.getFloorNumber() == 1) {
			if(quest.getRoomClear() >= 4) {
				complete = true;
			}
		}
		if(room.getFloorNumber() == 2) {
			if(quest.getMonsterKilled() >= 8 && quest.getBossKilled() >= 2) {
				complete = true;
			}
		}
		if(room.getFloorNumber() == 3) {
			if(quest.getMonsterKilled() >= 5 && quest.getPuzzleSolved() >= 3) {
				complete = true;
			}
		}
		if(room.getFloorNumber() == 4) {
			if(quest.getMonsterKilled() >= 5 && quest.getPuzzleSolved() >= 2 && quest.getBossKilled() >= 2) {
				complete = true;
			}
		}
		if(room.getFloorNumber() == 5) {
			if(quest.getBossKilled() >= 4) {
				complete = true;
			}
		}
		return complete;
	}


	public int getQuestID() {
		return questID;
	}

	public void setQuestID(int questID) {
		this.questID = questID;
	}

	public String getQuestDescription() {
		return questDescription;
	}

	public void setQuestDescription(String questDescription) {
		this.questDescription = questDescription;
	}

	public int getMonsterKilled() {
		return monsterKilled;
	}

	public void setMonsterKilled(int monsterKilled) {
		this.monsterKilled = monsterKilled;
	}

	public int getBossKilled() {
		return bossKilled;
	}

	public void setBossKilled(int bossKilled) {
		this.bossKilled = bossKilled;
	}

	public int getPuzzleSolved() {
		return puzzleSolved;
	}

	public void setPuzzleSolved(int puzzleSolved) {
		this.puzzleSolved = puzzleSolved;
	}

	public int getRoomClear() {
		return roomClear;
	}

	public void setRoomClear(int roomCleared) {
		this.roomClear = roomCleared;
	}

	/** Method: toString
	 * Purpose: Returns a String of the Weapon class
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Quest {\nquestID = " + questID + "\nquestDescription = " + questDescription + "\nmonsterKilled = " + monsterKilled 
				+ "\nbossKilled = " + bossKilled + "\npuzzleSolved = " + puzzleSolved + "\n}"; 
	}


}
