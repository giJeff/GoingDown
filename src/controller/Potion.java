package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.PotionDB;

/** Class : Potion.java
 * @author: Jeff Graves
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 16, 2017
 *
 * This class is the Armor class handling business logic for the Potion class
 */
public class Potion
{

	private int potionID;
	private String potionName;
	private int healPerTurn;
	private int numberOfTurn;
	private String extra;
	private float weight;
	
	
	/** Constructor: Potion
	 * @throws SQLException 
	 */
	public Potion() throws SQLException
	{
		PotionDB pdb = new PotionDB();
		potionID = pdb.getNextPotionID();
	}
	
	/** Method: getPotion
	 * Purpose: Gets a specified potion from the Potion table 
	 * @param id
	 * @return Potion
	 * @throws SQLException
	 */
	public Potion getPotion(int id) throws SQLException
	{
		PotionDB pdb = new PotionDB();
		return pdb.getPotion(id);
	}
	
	/** Method: getAllPotion
	 * Purpose: gets all potions from the Potion table
	 * @return ArrayList<Potion>
	 * @throws SQLException
	 */
	public ArrayList<Potion> getAllPotions() throws SQLException
	{
		PotionDB  pdb = new PotionDB();
		return pdb.getAllPotions();
	}
	
	

	/**
	 * @return the potionID
	 */
	public int getPotionID() {
		return potionID;
	}

	/**
	 * @param potionID the potionID to set
	 */
	public void setPotionID(int potionID) {
		this.potionID = potionID;
	}

	/**
	 * @return the potionName
	 */
	public String getPotionName() {
		return potionName;
	}

	/**
	 * @param potionName the potionName to set
	 */
	public void setPotionName(String potionName) {
		this.potionName = potionName;
	}

	/**
	 * @return the healPerTurn
	 */
	public int getHealPerTurn() {
		return healPerTurn;
	}

	/**
	 * @param healPerTurn the healPerTurn to set
	 */
	public void setHealPerTurn(int healPerTurn) {
		this.healPerTurn = healPerTurn;
	}

	/**
	 * @return the numberOfTurn
	 */
	public int getNumberOfTurn() {
		return numberOfTurn;
	}

	/**
	 * @param numberOfTurn the numberOfTurn to set
	 */
	public void setNumberOfTurn(int numberOfTurn) {
		this.numberOfTurn = numberOfTurn;
	}

	/**
	 * @return the extra
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * @param extra the extra to set
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/** Method: toString
	 * Purpose: Returns a String of the Weapon class
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Potion {\npotionID = " + potionID + "\npotionName = " + potionName + "\nhealPerTurn = " + healPerTurn 
				+ "\nnumberOfTurn = " + numberOfTurn + "\nextra = " + extra + "\nweight = " + weight + "\n}"; 
	}


}
