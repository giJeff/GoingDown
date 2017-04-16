package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Potion;

/** Class : PotionDB.java
 * @author: Jeff Graves
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 04, 2017
 *
 * This class handles all database access for the Potion class
 */
public class PotionDB
{
	/** Method: getNextPotionID
	 * Purpose: Gets the id for the next potion. 
	 * @return int
	 */
	public int getNextPotionID()
	{
		SQLiteDB sdb  = null;
		try
		{
			sdb = new SQLiteDB();
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return sdb.getMaxValue("potionNumber", "Potion") + 1;
	}
	
	/** Method: getPotion
	 * Purpose: handles db interactions to retrieve a single potion
	 * @param id
	 * @return Potion
	 * @throws SQLException
	 */
	public Potion getPotion(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Potion pot = new Potion();
		String sql = "Select * from Potion WHERE potionNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			pot.setPotionID(rs.getInt("potionNumber"));
			pot.setPotionName(rs.getString("potionName"));
			pot.setHealPerTurn(rs.getInt("healPerTurn"));
			pot.setNumberOfTurn(rs.getInt("numberOfTurn"));
			pot.setExtra(rs.getString("extra"));
			pot.setWeight(rs.getFloat("weight"));

		}
		sdb.close();
		return pot;
	}
	
	/** Method: getAllPotion
	 * Purpose: Handles the DB interactions to retrieve all potions 
	 * @return ArrayList<Potion>
	 * @throws SQLException
	 */
	public ArrayList<Potion> getAllPotions() throws SQLException
	{
		ArrayList<Potion> potions = new ArrayList<Potion>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Potion";
		
		ResultSet rs = sdb.queryDB(sql);
		
		while(rs.next())
		{
			Potion pot = new Potion();
			pot.setPotionID(rs.getInt("potionNumber"));
			pot.setPotionName(rs.getString("potionName"));
			pot.setHealPerTurn(rs.getInt("healPerTurn"));
			pot.setNumberOfTurn(rs.getInt("numberOfTurn"));
			pot.setExtra(rs.getString("extra"));
			pot.setWeight(rs.getFloat("weight"));

			potions.add(pot);
		}
		
		sdb.close();
		return potions;
	}

}
