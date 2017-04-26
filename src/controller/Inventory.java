package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory
{
	private int itemID;
	private String itemName;

	//Defining constant-IDs.
	public static final int ARMORID = 0;
	public static final int POTIONID = 1;
	public static final int WEAPONID = 2;

	// HashMap with arrayLists of items by ID.
	public static HashMap<Integer, ArrayList<String>> items = new HashMap<Integer, ArrayList<String>>();
	// Backpack with a slightly different structure.
	public static HashMap<Integer, String> inventory = new HashMap<Integer, String>();

	Armor arm = new Armor();
	Potion pot = new Potion();
	Weapon weap = new Weapon();

	public Inventory() throws SQLException
	{

	}

	public Armor addArmor()
	{
		arm.getArmorID();
		return arm;
	}

	public Armor dropArmor()
	{
		return arm;
	}

	public Potion addPotion()
	{
		return pot;
	}

	public Potion dropPotion()
	{
		return pot;
	}

	public Weapon addWeapon()
	{
		return weap;
	}

	public Weapon dropWeapon()
	{
		return weap;
	}




	public void temp()
	{

		// Creating the arrayLists.
		ArrayList<String> armor = new ArrayList<String>();
		ArrayList<String> weapon = new ArrayList<String>();
		ArrayList<String> potion = new ArrayList<String>();

		// Adding content to them...
		for (Integer i = 0; i < 10; i++) {
			armor.add("Armor" + i.toString());
			weapon.add("Weapon" + i.toString());
			potion.add("Potion" + i.toString());

		}

		// Putting the arrayLists to the HashMap of items by their IDs.
		items.put(ARMORID, armor); 
		items.put(POTIONID, potion);
		items.put(WEAPONID, weapon); 

		// Printing all the content in all arrayLists in all IDs.
		for (ArrayList<String> e : items.values()) {
			for (int i = 0; i < e.size(); i++) {
				if (e.get(i)!=null) {
					System.out.println(e.get(i));
				}
			}
		}

		// Here you could add any item to the backpack.
		inventory.put(ARMORID, armor.get(0));
		inventory.put(POTIONID, potion.get(0));
		inventory.put(WEAPONID, weapon.get(0));
	}


}




