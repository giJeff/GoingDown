package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Inventory;

/**
 * Class : InventoryDB.java
 * 
 * @author: Jeff Graves
 * @version: 1.0 Course: ITEC 3860 Written: April 04, 2017
 *
 *           This class handles all database access for the Inventory class
 */
public class InventoryDB
{
	/**
	 * Method: getNextInventoryID Purpose: Gets the id for the next item.
	 * 
	 * @return int
	 * @throws SQLException
	 */
	public int getNextInventoryID() throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		int max = sdb.getMaxValue("itemNumber", "Inventory") + 1;
		sdb.close();
		return max;
	}

	/**
	 * Method: getInventory Purpose: handles db interactions to retrieve a single
	 * Inventory
	 * 
	 * @param id
	 * @return Inventory
	 * @throws SQLException
	 */
	public Inventory getItem(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Inventory inv = new Inventory();
		String sql = "Select * from Inventory WHERE itemNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			inv.setItemNumber(rs.getInt("itemNumber"));
			inv.setPlayerNumber(rs.getInt("playerNumber"));
			inv.setWeaponNumber(rs.getInt("weaponNumber"));
			inv.setArmorNumber(rs.getInt("armorNumber"));
			inv.setPotionNumber(rs.getInt("potionNumber"));
			inv.setIsEquiped(rs.getInt("isEquiped"));
			inv.setEquipSlot(rs.getInt("equipSlot"));

		}
		sdb.close();
		return inv;
	}

	/**
	 * Method: getAllItems Purpose: Handles the DB interactions to retrieve all
	 * items
	 * 
	 * @return ArrayList<Inventory>
	 * @throws SQLException
	 */
	public ArrayList<Inventory> getAllItems() throws SQLException
	{
		ArrayList<Inventory> items = new ArrayList<Inventory>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Inventory";

		ResultSet rs = sdb.queryDB(sql);

		while (rs.next())
		{
			Inventory inv = new Inventory();
			inv.setItemNumber(rs.getInt("itemNumber"));
			inv.setPlayerNumber(rs.getInt("playerNumber"));
			inv.setWeaponNumber(rs.getInt("weaponNumber"));
			inv.setArmorNumber(rs.getInt("armorNumber"));
			inv.setPotionNumber(rs.getInt("potionNumber"));
			inv.setIsEquiped(rs.getInt("isEquiped"));
			inv.setEquipSlot(rs.getInt("equipSlot"));
			items.add(inv);
		}

		sdb.close();
		return items;
	}

}
