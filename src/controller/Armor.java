package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ArmorDB;

/**
 * Class : Armor.java
 * 
 * @author: Jeff Graves
 * @version: 1.0 Course: ITEC 3860 Written: April 16, 2017
 *
 *           This class is the Armor class handling business logic for the Armor
 *           class
 */
public class Armor
{
	private int armorID;
	private String armorType;
	private int equipSlot;
	private float commonDamageReduction;
	private float uncommonDamageReduction;
	private float rareDamageReduction;
	private float legendaryDamageReduction;
	private float weight;

	/**
	 * Constructor: Armor
	 * 
	 * @throws SQLException
	 */
	public Armor() throws SQLException
	{
		ArmorDB adb = new ArmorDB();
		armorID = adb.getNextArmorID();
	}

	/**
	 * Method: getArmor Purpose: Gets a specified armor from the Armor table
	 * 
	 * @param id
	 * @return Armor
	 * @throws SQLException
	 */
	public Armor getArmor(int id) throws SQLException
	{
		ArmorDB adb = new ArmorDB();
		return adb.getArmor(id);
	}

	/**
	 * Method: getAllArmors Purpose: gets all armors from the Armor table
	 * 
	 * @return ArrayList<Armor>
	 * @throws SQLException
	 */
	public ArrayList<Armor> getAllArmors() throws SQLException
	{
		ArmorDB adb = new ArmorDB();
		return adb.getAllArmors();
	}

	/**
	 * @return the armorID
	 */
	public int getArmorID()
	{
		return armorID;
	}

	/**
	 * @param armorID
	 *            the armorID to set
	 */
	public void setArmorID(int armorID)
	{
		this.armorID = armorID;
	}

	/**
	 * @return the armorType
	 */
	public String getArmorType()
	{
		return armorType;
	}

	/**
	 * @param armorType
	 *            the armorType to set
	 */
	public void setArmorType(String armorType)
	{
		this.armorType = armorType;
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
	 * @return the commonDamageReduction
	 */
	public float getCommonDamageReduction()
	{
		return commonDamageReduction;
	}

	/**
	 * @param commonDamageReduction
	 *            the commonDamageReduction to set
	 */
	public void setCommonDamageReduction(float commonDamageReduction)
	{
		this.commonDamageReduction = commonDamageReduction;
	}

	/**
	 * @return the uncommonDamageReduction
	 */
	public float getUncommonDamageReduction()
	{
		return uncommonDamageReduction;
	}

	/**
	 * @param uncommonDamageReduction
	 *            the uncommonDamageReduction to set
	 */
	public void setUncommonDamageReduction(float uncommonDamageReduction)
	{
		this.uncommonDamageReduction = uncommonDamageReduction;
	}

	/**
	 * @return the rareDamageReduction
	 */
	public float getRareDamageReduction()
	{
		return rareDamageReduction;
	}

	/**
	 * @param rareDamageReduction
	 *            the rareDamageReduction to set
	 */
	public void setRareDamageReduction(float rareDamageReduction)
	{
		this.rareDamageReduction = rareDamageReduction;
	}

	/**
	 * @return the legendaryDamageReduction
	 */
	public float getLegendaryDamageReduction()
	{
		return legendaryDamageReduction;
	}

	/**
	 * @param legendaryDamageReduction
	 *            the legendaryDamageReduction to set
	 */
	public void setLegendaryDamageReduction(float legendaryDamageReduction)
	{
		this.legendaryDamageReduction = legendaryDamageReduction;
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
		return "Armor {\narmorID = " + armorID + "\narmorType = " + armorType + "\nequipSlot = " + equipSlot
				+ "\ncommonDamageReduction = " + commonDamageReduction + "\nuncommonDamageReduction = "
				+ uncommonDamageReduction + "\nrareDamageReduction = " + rareDamageReduction
				+ "\nlegendaryDamageReduction = " + legendaryDamageReduction + "\nweight = " + weight + "\n}";
	}

}
