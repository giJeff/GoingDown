package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Monster;


public class MonsterDB
{
	/** Method: getRandomMonster
	 * Purpose: Gets the id for the next random monster. 
	 * @return int
	 * 
	 */
	public int getNextMonsterID()
	{
		SQLiteDB sdb  = null;
		try
		{
			sdb = new SQLiteDB();
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return sdb.getMaxValue("monsterNumber", "Monster") + 1;
	}
	
	/** Method: getMonster
	 * Purpose: handles db interactions to retrieve a single Monster
	 * @param id
	 * @return Monster
	 * @throws SQLException
	 */
	public Monster getMonster(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Monster mon = new Monster();
		String sql = "Select * from Monster WHERE monsterNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			mon.setMonsterID(rs.getInt("monsterNumber"));
			mon.setMonsterName(rs.getString("monsterName"));
			mon.setMonsterDescription(rs.getString("monsterDescription"));
			mon.setHitPoints(rs.getInt("hitPoints"));
			mon.setMaxDamage(rs.getInt("maxDamage"));
			mon.setMinDamage(rs.getInt("minDamage"));
			mon.setElemantalDamage(rs.getInt("elementalDamage"));
			mon.setDamagePerTurn(rs.getInt("damagePerTurn"));
			mon.setNumTurns(rs.getInt("numTurns"));
		}
		sdb.close();
		return mon;
	}
	
	/** Method: getAllMonsters
	 * Purpose: Handles the DB interactions to retrieve all monsters 
	 * @return ArrayList<Monster>
	 * @throws SQLException
	 */
	public ArrayList<Monster> getAllMonsters() throws SQLException
	{
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Monster";
		
		ResultSet rs = sdb.queryDB(sql);
		
		while(rs.next())
		{
			Monster mon = new Monster();
			mon.setMonsterID(rs.getInt("monsterNumber"));
			mon.setMonsterName(rs.getString("monsterName"));
			mon.setMonsterDescription(rs.getString("monsterDescription"));
			mon.setHitPoints(rs.getInt("hitPoints"));
			mon.setMaxDamage(rs.getInt("maxDamage"));
			mon.setMinDamage(rs.getInt("minDamage"));
			mon.setElemantalDamage(rs.getInt("elementalDamage"));
			mon.setDamagePerTurn(rs.getInt("damagePerTurn"));
			mon.setNumTurns(rs.getInt("numTurns"));
			monsters.add(mon);
		}
		
		sdb.close();
		return monsters;
	}

}
