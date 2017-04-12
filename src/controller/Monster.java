package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MonsterDB;


public class Monster extends Combat{
	
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
	public Monster() {
		MonsterDB  mdb = new MonsterDB();
		monsterID = mdb.getNextMonsterID();
	}
	
	/** Method: getMonster
	 * Purpose: Gets a specified monster from the Monster table 
	 * @param id
	 * @return Monster
	 * @throws SQLException
	 */
	public Monster getMonster(int id) throws SQLException {
		MonsterDB  mdb = new MonsterDB();
		return mdb.getMonster(id);
	}
	
	/** Method: getAllMonsters
	 * Purpose: gets all monsters from the Monster table
	 * @return ArrayList<Monster>
	 * @throws SQLException
	 */
	public ArrayList<Monster> getAllMonsters() throws SQLException {
		MonsterDB  mdb = new MonsterDB();
		return mdb.getAllMonsters();
	}

	public int getMonsterID() {
		return monsterID;
	}

	public void setMonsterID(int monsterID) {
		this.monsterID = monsterID;
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

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
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

	@Override
	public String toString() {
		return "Monster monsterID = " + monsterID + "\nmonsterName = " + monsterName + "\nmonsterDescription = "
				+ monsterDescription;
	}


}
