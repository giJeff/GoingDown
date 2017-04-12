package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.GameController;
import controller.Player;


public class PlayerDB {


	public Player getPlayer(int id) throws SQLException {
		SQLiteDB sdb = GameController.getDB();
		Player player = new Player();
		String sql = "Select * from Player WHERE playerNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);
		if (rs.next())
		{
			player.setPlayerID(rs.getInt("playerNumber"));
			player.setPlayerName(rs.getString("playerName"));
			player.setHitPoints(rs.getInt("hitPoints"));
			player.setMaxDamage(rs.getInt("maxDamage"));
			player.setMinDamage(rs.getInt("minDamage"));
			player.setElemantalDamage(rs.getInt("elementalDamage"));
			player.setDamagePerTurn(rs.getInt("damagePerTurn"));
			player.setNumTurns(rs.getInt("numTurns"));
			

		}
		sdb.close();
		return player;
	}
	


}
