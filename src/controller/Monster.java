package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import model.MonsterDB;

/** Class : Monster.java
 * @author: Jeff Graves
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
	private String immune;
	private int hitPoints;
	private int minDamage;
	private int maxDamage;
	private int attackFirst;
	private int turnToHitPlayer;
	private int commonDrop;
	private int uncommonDrop;
	private int rareDrop;
	private int legendaryDrop;
	private int spawnChance;
	
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
	public ArrayList<Monster> getNormalMonsters(int numMonster)
	{
		ArrayList<Monster> monsterList = new ArrayList<>();
		Monster mon = new Monster();
		for (int i = 0; i < numMonster; i++) 
		{
			try 
			{
				int randomNum = ThreadLocalRandom.current().nextInt(1, 9 + 1);
				System.out.println("get the moster ID " + randomNum);
				monsterList.add(mon.getMonster(randomNum));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return monsterList;
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

	/**
	 * @return the immune
	 */
	public String getImmune() {
		return immune;
	}

	/**
	 * @param immune the immune to set
	 */
	public void setImmune(String immune) {
		this.immune = immune;
	}

	/**
	 * @return the attackFirst
	 */
	public int getAttackFirst() {
		return attackFirst;
	}

	/**
	 * @param attackFirst the attackFirst to set
	 */
	public void setAttackFirst(int attackFirst) {
		this.attackFirst = attackFirst;
	}

	/**
	 * @return the turnToHitPlayer
	 */
	public int getTurnToHitPlayer() {
		return turnToHitPlayer;
	}

	/**
	 * @param turnToHitPlayer the turnToHitPlayer to set
	 */
	public void setTurnToHitPlayer(int turnToHitPlayer) {
		this.turnToHitPlayer = turnToHitPlayer;
	}

	/**
	 * @return the commonDrop
	 */
	public int getCommonDrop() {
		return commonDrop;
	}

	/**
	 * @param commonDrop the commonDrop to set
	 */
	public void setCommonDrop(int commonDrop) {
		this.commonDrop = commonDrop;
	}

	/**
	 * @return the uncommonDrop
	 */
	public int getUncommonDrop() {
		return uncommonDrop;
	}

	/**
	 * @param uncommonDrop the uncommonDrop to set
	 */
	public void setUncommonDrop(int uncommonDrop) {
		this.uncommonDrop = uncommonDrop;
	}

	/**
	 * @return the rareDrop
	 */
	public int getRareDrop() {
		return rareDrop;
	}

	/**
	 * @param rareDrop the rareDrop to set
	 */
	public void setRareDrop(int rareDrop) {
		this.rareDrop = rareDrop;
	}

	/**
	 * @return the legendaryDrop
	 */
	public int getLegendaryDrop() {
		return legendaryDrop;
	}

	/**
	 * @param legendaryDrop the legendaryDrop to set
	 */
	public void setLegendaryDrop(int legendaryDrop) {
		this.legendaryDrop = legendaryDrop;
	}

	/**
	 * @return the spawnChance
	 */
	public int getSpawnChance() {
		return spawnChance;
	}

	/**
	 * @param spawnChance the spawnChance to set
	 */
	public void setSpawnChance(int spawnChance) {
		this.spawnChance = spawnChance;
	}

	/** Method: toString
	 * Purpose: Returns a String of the Monster class
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Monster {\nmonsterID = " + monsterID + "\nmonsterName = " + monsterName + "\nmonsterDescription = "
				+ monsterDescription + "\nimmune = " + immune + "\nhitPoints = " + hitPoints + "\nminDamage = " + minDamage 
				+ "\nmaxDamage = " + maxDamage + "\nattackFirst = " + attackFirst + "\nturnToHitPlayer = " + turnToHitPlayer
				+ "\ncommonDrop = " + commonDrop + "\nuncommonDrop = " + uncommonDrop + "\nrareDrop = " + rareDrop 
				+ "\nlegendaryDrop = " + legendaryDrop + "\nspawnChance = " + spawnChance +"\n}"; 
	}


}
