package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MonsterDB;


public class Monster extends Sprite 
{
	private int monsterID;
	private String monsterName;
	private String monsterDescription;
	
	
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


	@Override
	public String toString() {
		return "Monster monsterID = " + monsterID + "\nmonsterName = " + monsterName + "\nmonsterDescription = "
				+ monsterDescription;
	}


}
