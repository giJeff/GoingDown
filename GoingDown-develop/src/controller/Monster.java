package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MonsterDB;

/** Class : Monster.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Feb 28, 2017
 *
 * This class is the Monster class handling business logic for the Monster class
 */
public class Monster
{
	private int monsterID;
	private String monsterName;
	private String monsterDescription;
	private int hitPoints;
	private int minDamage;
	private int maxDamage;
	private int elemantalDamage;
	private int damagePerTurn;
	private int numTurns;
	
	
	
	/** Constructor: Monster
	 */
	public Monster()
	{
		MonsterDB  mdb = new MonsterDB();
		monsterID = mdb.getNextMonsterID();
	}
	
	/** Method: getMonster
	 * Purpose: Gets a specified monster from the Monster table 
	 * @param id
	 * @return Monster
	 * @throws SQLException
	 */
	public Monster getMonster(int id) throws SQLException
	{
		MonsterDB  mdb = new MonsterDB();
		return mdb.getMonster(id);
	}
	
	/** Method: getAllMonsters
	 * Purpose: gets all monsters from the Monster table
	 * @return ArrayList<Monster>
	 * @throws SQLException
	 */
	public ArrayList<Monster> getAllMonsters() throws SQLException
	{
		MonsterDB  mdb = new MonsterDB();
		return mdb.getAllMonsters();
	}

	/** Method: getMonsterID
	 * @return the monsterID
	 */
	public int getMonsterID()
	{
		return monsterID;
	}

	/** Method: setMonsterID
	 * @param monsterID the monsterID to set
	 */
	public void setMonsterID(int monsterID)
	{
		this.monsterID = monsterID;
	}

	/** Method: getMonsterName
	 * @return the monsterName
	 */
	public String getMonsterName()
	{
		return monsterName;
	}

	/** Method: setMonsterName
	 * @param monsterName the monsterName to set
	 */
	public void setMonsterName(String monsterName)
	{
		this.monsterName = monsterName;
	}

	/** Method: getMonsterDescription
	 * @return the monsterDescription
	 */
	public String getMonsterDescription()
	{
		return monsterDescription;
	}

	/** Method: setMonsterDescription
	 * @param monsterDescription the monsterDescription to set
	 */
	public void setMonsterDescription(String monsterDescription)
	{
		this.monsterDescription = monsterDescription;
	}

	/** Method: getHitPoints
	 * @return the hitPoints
	 */
	public int getHitPoints()
	{
		return hitPoints;
	}

	/** Method: setHitPoints
	 * @param hitPoints the hitPoints to set
	 */
	public void setHitPoints(int hitPoints)
	{
		this.hitPoints = hitPoints;
	}

	/** Method: getMinDamage
	 * @return the minDamage
	 */
	public int getMinDamage()
	{
		return minDamage;
	}

	/** Method: setMinDamage
	 * @param minDamage the minDamage to set
	 */
	public void setMinDamage(int minDamage)
	{
		this.minDamage = minDamage;
	}

	/** Method: getMaxDamage
	 * @return the maxDamage
	 */
	public int getMaxDamage()
	{
		return maxDamage;
	}

	/** Method: setMaxDamage
	 * @param maxDamage the maxDamage to set
	 */
	public void setMaxDamage(int maxDamage)
	{
		this.maxDamage = maxDamage;
	}

	/** Method: toString
	 * Purpose: Returns a String of the Monster class
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Monster monsterID = " + monsterID + "\nmonsterName = " + monsterName + "\nmonsterDescription = "
				+ monsterDescription + "\nhitPoints = " + hitPoints + "\nminDamage = " + minDamage + "\nmaxDamage = "
				+ maxDamage;
	}


}
