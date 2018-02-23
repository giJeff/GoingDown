package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Weapon;

/**
 * Class : WeaponDB.java
 * 
 * @author: Jeff Graves
 * @version: 1.0 Course: ITEC 3860 Written: April 04, 2017
 *
 *           This class handles all database access for the Weapon class
 */
public class WeaponDB
{
	/**
	 * Method: getNextWeaponID Purpose: Gets the id for the next weapon.
	 * 
	 * @return int
	 * @throws SQLException
	 */
	public int getNextWeaponID() throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		int max = sdb.getMaxValue("weaponNumber", "Weapon") + 1;
		sdb.close();
		return max;
	}

	/**
	 * Method: getWeapon Purpose: handles db interactions to retrieve a single
	 * weapon
	 * 
	 * @param id
	 * @return Weapon
	 * @throws SQLException
	 */
	public Weapon getWeapon(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Weapon wep = new Weapon();
		String sql = "Select * from Weapon WHERE weaponNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			wep.setWeaponID(rs.getInt("weaponNumber"));
			wep.setWeaponName(rs.getString("weaponName"));
			wep.setEquipSlot(rs.getInt("equipSlot"));
			wep.setAttackType(rs.getString("attackType"));
			wep.setMinDamage(rs.getInt("minDamage"));
			wep.setMaxDamage(rs.getInt("maxDamage"));
			wep.setExtra(rs.getString("extra"));
			wep.setCommonDamage(rs.getFloat("commonDamage"));
			wep.setUncommonDamage(rs.getFloat("uncommonDamage"));
			wep.setRareDamage(rs.getFloat("rareDamage"));
			wep.setLegendaryDamage(rs.getFloat("legendaryDamage"));
			wep.setWeight(rs.getFloat("weight"));

		}
		sdb.close();
		return wep;
	}

	/**
	 * Method: getAllWeapons Purpose: Handles the DB interactions to retrieve all
	 * weapons
	 * 
	 * @return ArrayList<Weapon>
	 * @throws SQLException
	 */
	public ArrayList<Weapon> getAllWeapons() throws SQLException
	{
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Weapon";

		ResultSet rs = sdb.queryDB(sql);

		while (rs.next())
		{
			Weapon wep = new Weapon();
			wep.setWeaponID(rs.getInt("weaponNumber"));
			wep.setWeaponName(rs.getString("weaponName"));
			wep.setEquipSlot(rs.getInt("equipSlot"));
			wep.setAttackType(rs.getString("attackType"));
			wep.setMinDamage(rs.getInt("minDamage"));
			wep.setMaxDamage(rs.getInt("maxDamage"));
			wep.setExtra(rs.getString("extra"));
			wep.setCommonDamage(rs.getFloat("commonDamage"));
			wep.setUncommonDamage(rs.getFloat("uncommonDamage"));
			wep.setRareDamage(rs.getFloat("rareDamage"));
			wep.setLegendaryDamage(rs.getFloat("legendaryDamage"));
			wep.setWeight(rs.getFloat("weight"));
			weapons.add(wep);
		}

		sdb.close();
		return weapons;
	}

}
