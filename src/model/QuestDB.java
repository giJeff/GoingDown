package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Quest;

/**
 * Class : QuestDB.java
 * 
 * @author: Jeff Graves
 * @version: 1.0 Course: ITEC 3860 Written: April 04, 2017
 *
 *           This class handles all database access for the Quest class
 */
public class QuestDB
{
	/**
	 * Method: getNextQuestID Purpose: Gets the id for the next quest.
	 * 
	 * @return int
	 * @throws SQLException
	 */
	public int getNextQuestID() throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		int max = sdb.getMaxValue("questNumber", "Quest") + 1;
		sdb.close();
		return max;
	}

	/**
	 * Method: getQuest Purpose: handles db interactions to retrieve a single Quest
	 * 
	 * @param id
	 * @return Quest
	 * @throws SQLException
	 */
	public Quest getQuest(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Quest que = new Quest();
		String sql = "Select * from Quest WHERE questNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			que.setQuestID(rs.getInt("questNumber"));
			que.setQuestDescription(rs.getString("questNumber"));
			que.setMonsterKilled(rs.getInt("monsterKilled"));
			que.setBossKilled(rs.getInt("bossKilled"));
			que.setPuzzleSolved(rs.getInt("puzzleSolved"));
			que.setRoomClear(rs.getInt("roomClear"));

		}
		sdb.close();
		return que;
	}

	/**
	 * Method: getAllQuest Purpose: Handles the DB interactions to retrieve all
	 * quests
	 * 
	 * @return ArrayList<Quest>
	 * @throws SQLException
	 */
	public ArrayList<Quest> getAllQuests() throws SQLException
	{
		ArrayList<Quest> quests = new ArrayList<Quest>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Quest";

		ResultSet rs = sdb.queryDB(sql);

		while (rs.next())
		{
			Quest que = new Quest();
			que.setQuestID(rs.getInt("questNumber"));
			que.setQuestDescription(rs.getString("questNumber"));
			que.setMonsterKilled(rs.getInt("monsterKilled"));
			que.setBossKilled(rs.getInt("bossKilled"));
			que.setPuzzleSolved(rs.getInt("puzzleSolved"));
			que.setRoomClear(rs.getInt("roomClear"));
			quests.add(que);
		}

		sdb.close();
		return quests;
	}

}
