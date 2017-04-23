package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Puzzles;

/** Class : PuzzlesDB.java
 * @author: Jeffrey Graves, edited by Charneaka Lewis
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 22, 2017
 *
 * This class handles all of the DB's for the Puzzles
 */

public class PuzzleDB 
{
	/** Method: getNextPuzzleID
	 * Purpose: Gets the id for the next puzzle. 
	 * @return int
	 */

	public int getNextPuzzleID()
	{
		SQLiteDB sdb  = null;
		try
		{
			sdb = new SQLiteDB();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return sdb.getMaxValue("puzzleNumber", "Puzzle") + 1;
	}

	/** Method: getPuzzle
	 * Purpose: Gets a puzzle based upon the supplied ID
	 * @param id
	 * @return Room
	 * @throws SQLException
	 */
	public Puzzles getPuzzle(int id) throws SQLException
	{
		SQLiteDB sdb = GameController.getDB();
		Puzzles plz = new Puzzles();
		String sql = "Select * from Puzzles WHERE puzzleNumber = " + id;
		ResultSet rs = sdb.queryDB(sql);

		if (rs.next())
		{
			plz.setPuzzleID(rs.getInt("puzzleID"));
			plz.setPuzzleQuestion(rs.getString("puzzleQuestion"));
			plz.setPuzzleAnswer(rs.getString("puzzleAnswer"));
			plz.setOptA(rs.getString("optionA"));
			plz.setOptB(rs.getString("optionB"));
			plz.setOptC(rs.getString("optionC"));
			plz.setOptD(rs.getString("optionD"));
			plz.setIncorrectAnsDamage(rs.getInt("incorrectAnsDamage"));
			plz.setCorrectAnsReward(rs.getInt("correctAnsReward")); 
		}

		sdb.close();
		return plz;
	}

	/** Method: getAllPuzzles
	 * Purpose: gets all puzzles
	 * @return ArrayList<Puzzles>
	 * @throws SQLException
	 */
	public ArrayList<Puzzles> getAllPuzzles() throws SQLException
	{
		ArrayList<Puzzles> puzzles = new ArrayList<Puzzles>();
		SQLiteDB sdb = GameController.getDB();
		String sql = "Select * from Puzzles";

		ResultSet rs = sdb.queryDB(sql);

		while(rs.next())
		{
			Puzzles plz = new Puzzles();
			plz.setPuzzleID(rs.getInt("puzzleID"));
			plz.setPuzzleQuestion(rs.getString("puzzleQuestion"));
			plz.setPuzzleAnswer(rs.getString("puzzleAnswer"));
			plz.setOptA(rs.getString("optionA"));
			plz.setOptB(rs.getString("optionB"));
			plz.setOptC(rs.getString("optionC"));
			plz.setOptD(rs.getString("optionD"));
			plz.setIncorrectAnsDamage(rs.getInt("incorrectAnsDamage"));
			plz.setCorrectAnsReward(rs.getInt("correctAnsReward")); 
			puzzles.add(plz);
		}

		sdb.close();
		return puzzles;
	}

}

