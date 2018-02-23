package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.InventoryDB;

/**
 * Class : Inventory.java
 * 
 * @author: Jeff Graves
 * @version: 1.0 Course: ITEC 3860 Written: April 16, 2017
 *
 *           This class is the Inventory class handling business logic for the
 *           Inventory class
 */
public class Inventory
{
	private int itemNumber;
	private int playerNumber;
	private int weaponNumber;
	private int armorNumber;
	private int potionNumber;
	private int isEquiped;
	private int equipSlot;

	Weapon weapon = new Weapon();
	Armor armor = new Armor();
	Potion potion = new Potion();

	public void dropItem(Monster monster, Player player, int min, int max)
	{
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	/**
	 * Constructor: Inventory
	 * 
	 * @throws SQLException
	 */
	public Inventory() throws SQLException
	{
		InventoryDB idb = new InventoryDB();
		itemNumber = idb.getNextInventoryID();
	}

	/**
	 * Method: getItem Purpose: Gets a specified item from the Inventory table
	 * 
	 * @param id
	 * @return Inventory
	 * @throws SQLException
	 */
	public Inventory getItem(int id) throws SQLException
	{
		InventoryDB idb = new InventoryDB();
		return idb.getItem(id);
	}

	/**
	 * Method: getAllItems Purpose: gets all items from the Inventory table
	 * 
	 * @return ArrayList<Inventory>
	 * @throws SQLException
	 */
	public ArrayList<Inventory> getAllItems() throws SQLException
	{
		InventoryDB idb = new InventoryDB();
		return idb.getAllItems();
	}

	/**
	 * @return the itemNumber
	 */
	public int getItemNumber()
	{
		return itemNumber;
	}

	/**
	 * @param itemNumber
	 *            the itemNumber to set
	 */
	public void setItemNumber(int itemNumber)
	{
		this.itemNumber = itemNumber;
	}

	public int getPlayerNumber()
	{
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber)
	{
		this.playerNumber = playerNumber;
	}

	public int getWeaponNumber()
	{
		return weaponNumber;
	}

	public void setWeaponNumber(int weaponNumber)
	{
		this.weaponNumber = weaponNumber;
	}

	public int getArmorNumber()
	{
		return armorNumber;
	}

	public void setArmorNumber(int armorNumber)
	{
		this.armorNumber = armorNumber;
	}

	public int getPotionNumber()
	{
		return potionNumber;
	}

	public void setPotionNumber(int potionNumber)
	{
		this.potionNumber = potionNumber;
	}

	public int getIsEquiped()
	{
		return isEquiped;
	}

	public void setIsEquiped(int isEquiped)
	{
		this.isEquiped = isEquiped;
	}

	public int getEquipSlot()
	{
		return equipSlot;
	}

	public void setEquipSlot(int equipSlot)
	{
		this.equipSlot = equipSlot;
	}

	/**
	 * Method: toString Purpose: Returns a String of the Weapon class
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Inventory {\nitemNumber = " + itemNumber + "\nplayerNumber = " + playerNumber + "\nweaponNumber = "
				+ weaponNumber + "\narmorNumber = " + armorNumber + "\npotionNumber = " + potionNumber
				+ "\nisEquiped = " + isEquiped + "\nequipSlot = " + equipSlot + "\n}";
	}

}
