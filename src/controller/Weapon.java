package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.WeaponDB;

/**
 * Class : Monster.java
 * 
 * @author: Jeff Graves
 * @version: 1.0 Course: ITEC 3860 Written: April 16, 2017
 *
 *           This class is the Weapon class handling business logic for the
 *           Weapon class
 */
public class Weapon
{
	private int weaponID;
	private String weaponName;
	private int equipSlot;
	private String attackType;
	private int minDamage;
	private int maxDamage;
	private String extra;
	private float commonDamage;
	private float uncommonDamage;
	private float rareDamage;
	private float legendaryDamage;
	private float weight;

	/**
	 * Constructor: Weapon
	 * 
	 * @throws SQLException
	 */
	public Weapon() throws SQLException
	{
		WeaponDB wdb = new WeaponDB();
		weaponID = wdb.getNextWeaponID();
	}

	/**
	 * Method: getWeapon Purpose: Gets a specified weapon from the Weapon table
	 * 
	 * @param id
	 * @return Weapon
	 * @throws SQLException
	 */
	public Weapon getWeapon(int id) throws SQLException
	{
		WeaponDB wdb = new WeaponDB();
		return wdb.getWeapon(id);
	}

	/**
	 * Method: getAllWeapons Purpose: gets all weapons from the Weapon table
	 * 
	 * @return ArrayList<Weapon>
	 * @throws SQLException
	 */
	public ArrayList<Weapon> getAllWeapons() throws SQLException
	{
		WeaponDB wdb = new WeaponDB();
		return wdb.getAllWeapons();
	}

	/**
	 * @return the weaponID
	 */
	public int getWeaponID()
	{
		return weaponID;
	}

	/**
	 * @param weaponID
	 *            the weaponID to set
	 */
	public void setWeaponID(int weaponID)
	{
		this.weaponID = weaponID;
	}

	/**
	 * @return the weaponName
	 */
	public String getWeaponName()
	{
		return weaponName;
	}

	/**
	 * @param weaponName
	 *            the weaponName to set
	 */
	public void setWeaponName(String weaponName)
	{
		this.weaponName = weaponName;
	}

	/**
	 * @return the equipSlot
	 */
	public int getEquipSlot()
	{
		return equipSlot;
	}

	/**
	 * @param equipSlot
	 *            the equipSlot to set
	 */
	public void setEquipSlot(int equipSlot)
	{
		this.equipSlot = equipSlot;
	}

	/**
	 * @return the attackType
	 */
	public String getAttackType()
	{
		return attackType;
	}

	/**
	 * @param attackType
	 *            the attackType to set
	 */
	public void setAttackType(String attackType)
	{
		this.attackType = attackType;
	}

	/**
	 * @return the minDamage
	 */
	public int getMinDamage()
	{
		return minDamage;
	}

	/**
	 * @param minDamage
	 *            the minDamage to set
	 */
	public void setMinDamage(int minDamage)
	{
		this.minDamage = minDamage;
	}

	/**
	 * @return the maxDamage
	 */
	public int getMaxDamage()
	{
		return maxDamage;
	}

	/**
	 * @param maxDamage
	 *            the maxDamage to set
	 */
	public void setMaxDamage(int maxDamage)
	{
		this.maxDamage = maxDamage;
	}

	/**
	 * @return the extra
	 */
	public String getExtra()
	{
		return extra;
	}

	/**
	 * @param extra
	 *            the extra to set
	 */
	public void setExtra(String extra)
	{
		this.extra = extra;
	}

	/**
	 * @return the commonDamage
	 */
	public float getCommonDamage()
	{
		return commonDamage;
	}

	/**
	 * @param commonDamage
	 *            the commonDamage to set
	 */
	public void setCommonDamage(float commonDamage)
	{
		this.commonDamage = commonDamage;
	}

	/**
	 * @return the uncommonDamage
	 */
	public float getUncommonDamage()
	{
		return uncommonDamage;
	}

	/**
	 * @param uncommonDamage
	 *            the uncommonDamage to set
	 */
	public void setUncommonDamage(float uncommonDamage)
	{
		this.uncommonDamage = uncommonDamage;
	}

	/**
	 * @return the rareDamage
	 */
	public float getRareDamage()
	{
		return rareDamage;
	}

	/**
	 * @param rareDamage
	 *            the rareDamage to set
	 */
	public void setRareDamage(float rareDamage)
	{
		this.rareDamage = rareDamage;
	}

	/**
	 * @return the legendaryDamage
	 */
	public float getLegendaryDamage()
	{
		return legendaryDamage;
	}

	/**
	 * @param legendaryDamage
	 *            the legendaryDamage to set
	 */
	public void setLegendaryDamage(float legendaryDamage)
	{
		this.legendaryDamage = legendaryDamage;
	}

	/**
	 * @return the weight
	 */
	public float getWeight()
	{
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(float weight)
	{
		this.weight = weight;
	}

	/**
	 * Method: toString Purpose: Returns a String of the Weapon class
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Weapon {\nweaponID = " + weaponID + "\nweaponName = " + weaponName + "\nequipSlot = " + equipSlot
				+ "\nattackType = " + attackType + "\nminDamage = " + minDamage + "\nmaxDamage = " + maxDamage
				+ "\nextra = " + extra + "\ncommonDamage = " + commonDamage + "\nuncommonDamage = " + uncommonDamage
				+ "\nrareDamage = " + rareDamage + "\nlegendaryDamage = " + legendaryDamage + "\nweight = " + weight
				+ "\n}";
	}

}
