package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Player;

/** Class : PlayerDB.java
 * @author: Jeff Graves
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 04, 2017
 *
 * This class handles all database access for the Player class
 */
public class PlayerDB
{
	/** Method: getNextPlayerID
	 * Purpose: Gets the id for the next player. 
	 * @return int
	 * @throws SQLException 
	 */
	public int getNextPlayerID() throws SQLException
	{
		SQLiteDB sdb  = GameController.getDB();
		int max = sdb.getMaxValue("playerNumber", "Player") + 1;
		sdb.close();
		return max;
	}
	
	
	
	/** Method: getPlayer
	 * Purpose: handles db interactions to retrieve a single Player
	 * @param id
	 * @return Player
	 * @throws SQLException
	 */
	public Player getPlayer(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Player player = new Player();
		String sql = "Select * from Player WHERE playerNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			player.setPlayerID(rs.getInt("playerNumber"));
			player.setPlayerName(rs.getString("playerName"));
			player.setGender(rs.getString("gender"));
			player.setHitPoints(rs.getInt("hitpoints"));
			player.setMinDamage(rs.getInt("minDamage"));
			player.setMaxDamage(rs.getInt("maxDamage"));
			player.setScore(rs.getInt("score"));
			player.setNumKilled(rs.getInt("numKilled"));
			player.setNumSolved(rs.getInt("numSolved"));
			player.setWeight(rs.getFloat("weight"));
			player.setCurrentRoom(rs.getInt("currentRoom"));
			player.setPeekNorth(rs.getInt("peekNorth"));
			player.setPeekEast(rs.getInt("peekEast"));
			player.setPeekSouth(rs.getInt("peekSouth"));
			player.setPeekWest(rs.getInt("peekWest"));

		}
		sdb.close();
		return player;
	}
	
	/** Method: getAllPlayer
	 * Purpose: Handles the DB interactions to retrieve all players 
	 * @return ArrayList<Player>
	 * @throws SQLException
	 */
	public ArrayList<Player> getAllPlayers() throws SQLException
	{
		ArrayList<Player> players = new ArrayList<Player>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Player";
		
		ResultSet rs = sdb.queryDB(sql);
		
		while(rs.next())
		{
			Player player = new Player();
			player.setPlayerID(rs.getInt("playerNumber"));
			player.setPlayerName(rs.getString("playerName"));
			player.setGender(rs.getString("gender"));
			player.setHitPoints(rs.getInt("hitpoints"));
			player.setMinDamage(rs.getInt("minDamage"));
			player.setMaxDamage(rs.getInt("maxDamage"));
			player.setScore(rs.getInt("score"));
			player.setNumKilled(rs.getInt("numKilled"));
			player.setNumSolved(rs.getInt("numSolved"));
			player.setWeight(rs.getFloat("weight"));
			player.setCurrentRoom(rs.getInt("currentRoom"));
			player.setPeekNorth(rs.getInt("peekNorth"));
			player.setPeekEast(rs.getInt("peekEast"));
			player.setPeekSouth(rs.getInt("peekSouth"));
			player.setPeekWest(rs.getInt("peekWest"));
			players.add(player);
		}
		
		sdb.close();
		return players;
	}

}
