package controller;

/** Class : Player.java
 * @author: Charneaka Lewis
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 16, 2017
 *
 * This class is the Player class handling business logic for the Player 
 */

public class Player
{ 
	private String playerName;
	private int score;
	private int health; 
	
public Player()
{
	this.playerName = "";
	this.score = 0;
	this.health = 100;
}
	public Player(String playerName, int score, int health) {
		super();
		this.playerName = playerName;
		this.score = score;
		this.health = health;
	}

	public String getPlayerName() 
	{
		return playerName;
	}
	
	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}
	
	public int getScore() 
	{
		return score;
	}
	
	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public int getHealth() 
	{
		return health;
	}
	
	public void setHealth(int health) 
	{
		this.health = health;
	}
}
