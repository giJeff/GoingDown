package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.PuzzleDB;


/** Class : Puzzles.java
 * @author: Jeff Graves, edited by Charneaka Lewis
 * @version: 1.0
 * Course: ITEC 3860
 * Written: April 22, 2017
 *
 * This class is the Puzzle class handling business logic for the Puzzles class
 */

public class Puzzle
{
	private int puzzleID;
	private String puzzleQuestion;
	private String puzzleAnswer;
	private String optA;
	private String optB;
	private String optC;
	private String optD;
	private int incorrectAnsDamage;
	private int correctAnsReward;


	/** Constructor: Puzzles
	 * @throws SQLException 
	 */
	public Puzzle() throws SQLException
	{
		PuzzleDB pdb = new PuzzleDB();
		puzzleID = pdb.getNextPuzzleID();
	}

	/** Method: getPuzzles
	 * Purpose: Gets a specified puzzle from the Puzzle table 
	 * @param id
	 * @return Puzzle
	 * @throws SQLException
	 */
	public Puzzle getPuzzle(int id) throws SQLException
	{
		PuzzleDB pdb = new PuzzleDB();
		return pdb.getPuzzle(id);
	}
	
	public ArrayList<Puzzle> getPuzzles(int numPuzzles,int minIndex, int maxIndex) throws SQLException
	{
		ArrayList<Puzzle> puzzleList = new ArrayList<>();
		Puzzle p1 = new Puzzle();
		for (int i = 0; i < numPuzzles; i++) 
		{
			try 
			{
				int randomNum = ThreadLocalRandom.current().nextInt(minIndex, maxIndex + 1);
				System.out.println("get the puzzle ID " + randomNum);
				puzzleList.add(p1.getPuzzle(randomNum));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	return puzzleList;
}
	
	public boolean solvePuzzle(boolean playerDead, boolean puzzleSolved, Player player, Puzzle puzzle) 
	{
		if(!playerDead && !puzzleSolved) {
			player.setHitPoints(player.getHitPoints() - puzzle.getIncorrectAnsDamage());
			System.out.println("Player took " + puzzle.getIncorrectAnsDamage() + " damage this turn!");
			if(player.getHitPoints() < 1) {
				playerDead = true;
			}
		}
		return playerDead;
	}
	
	/** Method: getAllPuzzles
	 * Purpose: gets all of the Puzzles from the Puzzle table
	 * @return ArrayList<Puzzle>
	 * @throws SQLException
	 */

	public ArrayList<Puzzle> getAllPuzzless() throws SQLException
	{
		PuzzleDB  pdb = new PuzzleDB();
		return pdb.getAllPuzzles();
	}

	/** Method: getPuzzleID
	  * @return puzzleID
	  */ 
	public int getPuzzleID() 
	{
		return puzzleID;
	}
	
	/** Method: setPuzzleID
	 * @param puzzleID
	 */ 
	public void setPuzzleID(int puzzleID)
	{
		this.puzzleID = puzzleID;
	}

	/** Method: getPuzzleID
	 * @return puzzleID
	 */ 
	public String getPuzzleQuestion()
	{
		return puzzleQuestion;
	}

	/** Method: setPuzzleQuestion
	 * Sets the Puzzle to be solved
	 * @param puzzleID
	 */ 
	public void setPuzzleQuestion(String puzzleQuestion) 
	{
		this.puzzleQuestion = puzzleQuestion;
	}

	/** Method: getPuzzleID
	  * @return puzzleID
	  */ 
	public String getPuzzleAnswer() 
	{
		return puzzleAnswer;
	}

	/** Method: setPuzzleAnswer
	 * Sets the answer to the puzzle being solved
	 * @param puzzleID
	 */ 
	public void setPuzzleAnswer(String puzzleAnswer) 
	{
		this.puzzleAnswer = puzzleAnswer;
	}

	/** Method: getPuzzleID
	 * @return puzzleID
	 */ 
	public String getOptA() 
	{
		return optA;
	}
	
	/** Method: setOptionA
	 * Sets the first answer choice for the puzzle
	 * @param optionA
	 */ 
	public void setOptA(String optA) 
	{
		this.optA = optA;
	}
	
	/** Method: getOptionB
	 * @return optionB
	 */ 
	public String getOptB() 
	{
		return optB;
	}

	/** Method: setOptionB
	 * Sets the second answer choice for the puzzle
	 * @param optionB
	 */ 
	public void setOptB(String optB) 
	{
		this.optB = optB;
	}
	
	/** Method: getOptionC
	  * @return optionC
	  */ 
	public String getOptC() 
	{
		return optC;
	}

	/** Method: setOptionC
	 * Sets the third answer choice for the puzzle
	 * @param optionC
	 */ 
	public void setOptC(String optC) 
	{
		this.optC = optC;
	}

	/** Method: getOptionD
	 * @return OptionD
	 */ 
	public String getOptD() 
	{
		return optD;
	}

	/** Method: setOptionD
	 * Sets the fourth answer choice for the puzzle
	 * @param optionD
	 */ 
	public void setOptD(String optD) 
	{
		this.optD = optD;
	}

	/** Method: getIncorrectAnsDamage
	 * @return incorrectAnsDamage
	 */ 
	public int getIncorrectAnsDamage() 
	{
		return incorrectAnsDamage;
	}

	/** Method: setIncorrectAnsDamage
	 * Sets the point reduction for the puzzle
	 * @param incorrectAnsDamage
	 */ 
	public void setIncorrectAnsDamage(int incorrectAnsDamage) 
	{
		this.incorrectAnsDamage = incorrectAnsDamage;
	}
	
	/** Method: getCorrectAnsReward
	 * @return correctAnsReward
	 */ 
	public int getCorrectAnsReward() 
	{
		return correctAnsReward;
	}

	/** Method: setCorrectAnsDamage
	 * Sets the reward for solving the puzzle
	 * @param correctAnsReward
	 */ 
	public void setCorrectAnsReward(int correctAnsReward) 
	{
		this.correctAnsReward = correctAnsReward;
	}

	@Override
	public String toString() 
	{
		return "Puzzles [\npuzzleID=" + puzzleID + "\npuzzleQuestion=" + puzzleQuestion + " \npuzzleAnswer=" + puzzleAnswer
				+ "\noptA=" + optA + "\noptB=" + optB + "\noptC=" + optC + "\noptD=" + optD + "\nincorrectAnsDamage="
				+ incorrectAnsDamage + "\ncorrectAnsReward=" + correctAnsReward + "]";
	}	
}