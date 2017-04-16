package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Armor;

/** Class : ArmorDB.java
 * @author: Jeff Graves
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 04, 2017
 *
 * This class handles all database access for the Armor class
 */
public class ArmorDB
{
	/** Method: getNextArmorID
	 * Purpose: Gets the id for the next armor. 
	 * @return int
	 */
	public int getNextArmorID()
	{
		SQLiteDB sdb  = null;
		try
		{
			sdb = new SQLiteDB();
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return sdb.getMaxValue("armorNumber", "Armor") + 1;
	}
	
	/** Method: getArmor
	 * Purpose: handles db interactions to retrieve a single Armor
	 * @param id
	 * @return Armor
	 * @throws SQLException
	 */
	public Armor getArmor(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Armor arm = new Armor();
		String sql = "Select * from Armor WHERE armorNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			arm.setArmorID(rs.getInt("armorNumber"));
			arm.setArmorType(rs.getString("armorType"));
			arm.setEquipSlot(rs.getInt("equipSlot"));
			arm.setCommonDamageReduction(rs.getFloat("commonDamageReduction"));
			arm.setUncommonDamageReduction(rs.getFloat("uncommonDamageReduction"));
			arm.setRareDamageReduction(rs.getFloat("rareDamageReduction"));
			arm.setLegendaryDamageReduction(rs.getFloat("legendaryDamageReduction"));
			arm.setWeight(rs.getFloat("weight"));

		}
		sdb.close();
		return arm;
	}
	
	/** Method: getAllArmor
	 * Purpose: Handles the DB interactions to retrieve all armors 
	 * @return ArrayList<Armor>
	 * @throws SQLException
	 */
	public ArrayList<Armor> getAllArmors() throws SQLException
	{
		ArrayList<Armor> armors = new ArrayList<Armor>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Armor";
		
		ResultSet rs = sdb.queryDB(sql);
		
		while(rs.next())
		{
			Armor arm = new Armor();
			arm.setArmorID(rs.getInt("armorNumber"));
			arm.setArmorType(rs.getString("armorType"));
			arm.setEquipSlot(rs.getInt("equipSlot"));
			arm.setCommonDamageReduction(rs.getFloat("commonDamageReduction"));
			arm.setUncommonDamageReduction(rs.getFloat("uncommonDamageReduction"));
			arm.setRareDamageReduction(rs.getFloat("rareDamageReduction"));
			arm.setLegendaryDamageReduction(rs.getFloat("legendaryDamageReduction"));
			arm.setWeight(rs.getFloat("weight"));
			armors.add(arm);
		}
		
		sdb.close();
		return armors;
	}

}
