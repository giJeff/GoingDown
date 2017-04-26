package controller;

import java.sql.SQLException;

public class Inventory
{
	private int itemID;
	private String itemName;

	Armor arm = new Armor();
	Potion pot = new Potion();
	Weapon weap = new Weapon();
	
	public Inventory() throws SQLException
	{
		
	}
	
	public Armor addArmor()
	{
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
	
	
	
}
