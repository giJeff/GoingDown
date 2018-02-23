package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Puzzle;

/**
 * Class : PuzzlesDB.java
 * 
 * @author: Jeffrey Graves, edited by Charneaka Lewis
 * @version: 1.0 Course: ITEC 3860 Written: April 22, 2017
 *
 *           This class handles all of the DB's for the Puzzles
 */

public class PuzzleDB
{
	/**
	 * Method: getNextPuzzleID Purpose: Gets the id for the next puzzle.
	 * 
	 * @return int
	 * @throws SQLException
	 */

	public int getNextPuzzleID() throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		int max = sdb.getMaxValue("puzzleNumber", "Puzzle") + 1;
		sdb.close();
		return max;
	}

	/**
	 * Method: getPuzzle Purpose: Gets a puzzle based upon the supplied ID
	 * 
	 * @param id
	 * @return Room
	 * @throws SQLException
	 */
	public Puzzle getPuzzle(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Puzzle plz = new Puzzle();
		String sql = "Select * from Puzzle WHERE puzzleNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);

		if (rs.next())
		{
			plz.setPuzzleID(rs.getInt("puzzleNumber"));
			plz.setPuzzleQuestion(rs.getString("puzzleQuestion"));
			plz.setPuzzleAnswer(rs.getString("puzzleAnswer"));
			plz.setOptA(rs.getString("optA"));
			plz.setOptB(rs.getString("optB"));
			plz.setOptC(rs.getString("optC"));
			plz.setOptD(rs.getString("optD"));
			plz.setIncorrectAnsDamage(rs.getInt("incorrectDamage"));
			plz.setCorrectAnsReward(rs.getInt("correctReward"));
			plz.setSolved(rs.getInt("solved"));
		}

		sdb.close();
		return plz;
	}

	/**
	 * Method: getAllPuzzles Purpose: gets all puzzles
	 * 
	 * @return ArrayList<Puzzles>
	 * @throws SQLException
	 */
	public ArrayList<Puzzle> getAllPuzzles() throws SQLException
	{
		ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Puzzle";

		ResultSet rs = sdb.queryDB(sql);

		while (rs.next())
		{
			Puzzle plz = new Puzzle();
			plz.setPuzzleID(rs.getInt("puzzleNumber"));
			plz.setPuzzleQuestion(rs.getString("puzzleQuestion"));
			plz.setPuzzleAnswer(rs.getString("puzzleAnswer"));
			plz.setOptA(rs.getString("optA"));
			plz.setOptB(rs.getString("optB"));
			plz.setOptC(rs.getString("optC"));
			plz.setOptD(rs.getString("optD"));
			plz.setIncorrectAnsDamage(rs.getInt("incorrectDamage"));
			plz.setCorrectAnsReward(rs.getInt("correctReward"));
			plz.setSolved(rs.getInt("solved"));
			puzzles.add(plz);
		}

		sdb.close();
		return puzzles;
	}

}
