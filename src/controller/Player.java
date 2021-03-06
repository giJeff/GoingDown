package controller;

import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import model.PlayerDB;
import model.SQLiteDB;

/**
 * Class : Player.java
 * 
 * @author: Jeff Graves
 * @version: 1.0 Course: ITEC 3860 Written: April 16, 2017
 *
 *           This class is the Player class handling business logic for the
 *           Player
 */

public class Player
{
	private int playerID;
	private String playerName;
	private String gender;
	private int hitPoints;
	private int minDamage;
	private int maxDamage;
	private int score;
	private int numKilled;
	private int numSolved;
	Inventory inv = new Inventory();
	private float weight;
	private float maxWeight;
	private int currentRoom;
	private int peekNorth;
	private int peekEast;
	private int peekSouth;
	private int peekWest;

	/**
	 * Constructor: Monster
	 * 
	 * @throws SQLException
	 */
	public Player() throws SQLException
	{
		PlayerDB pdb = new PlayerDB();
		playerID = pdb.getNextPlayerID();
	}

	/**
	 * Method: getPlayer Purpose: Gets a specified Player from the Player table
	 * 
	 * @param id
	 * @return Player
	 * @throws SQLException
	 */
	public Player getPlayer(int id) throws SQLException
	{
		PlayerDB pdb = new PlayerDB();
		return pdb.getPlayer(id);
	}

	public void savePlayer() throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		sdb.savePlayerInt("Player", "hitPoints", hitPoints, "playerNumber", this.getPlayerID());
		sdb.savePlayerInt("Player", "score", score, "playerNumber", this.getPlayerID());
		sdb.savePlayerInt("Player", "numKilled", numKilled, "playerNumber", this.getPlayerID());
		sdb.savePlayerInt("Player", "numSolved", numSolved, "playerNumber", this.getPlayerID());
		sdb.savePlayerFloat("Player", "weight", weight, "playerNumber", this.getPlayerID());
		sdb.savePlayerInt("Player", "currentRoom", currentRoom, "playerNumber", this.getPlayerID());
		sdb.close();
		slowText("+------------------------------------------------------------------+");
		slowText("Game has been saved!");
	}

	public boolean playerAttack(boolean playerDead, boolean monsterDead, Player player, Monster monster)
	{
		int randomPlayerAttack = ThreadLocalRandom.current().nextInt(player.getMinDamage(), player.getMaxDamage() + 1);
		if (!playerDead && !monsterDead)
		{
			monster.setHitPoints(monster.getHitPoints() - randomPlayerAttack);
			System.out.println("Monster took " + randomPlayerAttack + " damage this turn!");
			if (monster.getHitPoints() < 1)
			{
				monsterDead = true;
			}
		}
		return monsterDead;
	}

	/**
	 * @return the playerID
	 */
	public int getPlayerID()
	{
		return playerID;
	}

	/**
	 * @param playerID
	 *            the playerID to set
	 */
	public void setPlayerID(int playerID)
	{
		this.playerID = playerID;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName()
	{
		return playerName;
	}

	/**
	 * @param playerName
	 *            the playerName to set
	 */
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	/**
	 * @return the gender
	 */
	public String getGender()
	{
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}

	/**
	 * @return the hitPoints
	 */
	public int getHitPoints()
	{
		return hitPoints;
	}

	/**
	 * @param hitPoints
	 *            the hitPoints to set
	 */
	public void setHitPoints(int hitPoints)
	{
		this.hitPoints = hitPoints;
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
	 * @return the score
	 */
	public int getScore()
	{
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score)
	{
		this.score = score;
	}

	/**
	 * @return the numKilled
	 */
	public int getNumKilled()
	{
		return numKilled;
	}

	/**
	 * @param numKilled
	 *            the numKilled to set
	 */
	public void setNumKilled(int numKilled)
	{
		this.numKilled = numKilled;
	}

	/**
	 * @return the numSolved
	 */
	public int getNumSolved()
	{
		return numSolved;
	}

	/**
	 * @param numSolved
	 *            the numSolved to set
	 */
	public void setNumSolved(int numSolved)
	{
		this.numSolved = numSolved;
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
	 * @return the maxWeight
	 */
	public float getMaxWeight()
	{
		return maxWeight;
	}

	/**
	 * @param maxWeight
	 *            the maxWeight to set
	 */
	public void setMaxWeight(float maxWeight)
	{
		this.maxWeight = maxWeight;
	}

	/**
	 * @return the currentRoom
	 */
	public int getCurrentRoom()
	{
		return currentRoom;
	}

	/**
	 * @param currentRoom
	 *            the currentRoom to set
	 */
	public void setCurrentRoom(int currentRoom)
	{
		this.currentRoom = currentRoom;
	}

	/**
	 * @return the peekNorth
	 */
	public int getPeekNorth()
	{
		return peekNorth;
	}

	/**
	 * @param peekNorth
	 *            the peekNorth to set
	 */
	public void setPeekNorth(int peekNorth)
	{
		this.peekNorth = peekNorth;
	}

	/**
	 * @return the peekEast
	 */
	public int getPeekEast()
	{
		return peekEast;
	}

	/**
	 * @param peekEast
	 *            the peekEast to set
	 */
	public void setPeekEast(int peekEast)
	{
		this.peekEast = peekEast;
	}

	/**
	 * @return the peekSouth
	 */
	public int getPeekSouth()
	{
		return peekSouth;
	}

	/**
	 * @param peekSouth
	 *            the peekSouth to set
	 */
	public void setPeekSouth(int peekSouth)
	{
		this.peekSouth = peekSouth;
	}

	/**
	 * @return the peekWest
	 */
	public int getPeekWest()
	{
		return peekWest;
	}

	/**
	 * @param peekWest
	 *            the peekWest to set
	 */
	public void setPeekWest(int peekWest)
	{
		this.peekWest = peekWest;
	}

	public void slowText(String msg)
	{
		for (int i = 0; i < msg.length(); i++)
		{
			System.out.print(msg.charAt(i));

			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	/**
	 * Method: toString Purpose: Returns a String of the Monster class
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Player {\nplayerID = " + playerID + "\nplayerName = " + playerName + "\ngender = " + gender
				+ "\nhitPoints = " + hitPoints + "\nminDamage = " + minDamage + "\nmaxDamage = " + maxDamage
				+ "\nscore = " + score + "\nnumKilled = " + numKilled + "\nnumSolved = " + numSolved + "\nweight = "
				+ weight + "\nmaxWeight = " + maxWeight + "\ncurrentRoom = " + currentRoom + "\npeekNorth = "
				+ peekNorth + "\npeekEast = " + peekEast + "\npeekSouth = " + peekSouth + "\npeekWest = " + peekWest
				+ "\n}";
	}

}
