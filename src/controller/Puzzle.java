package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import model.PuzzleDB;
import model.SQLiteDB;


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

	Scanner in = new Scanner(System.in);

	private int puzzleID;
	private String puzzleQuestion;
	private String puzzleAnswer;
	private String optA;
	private String optB;
	private String optC;
	private String optD;
	private int incorrectDamage;
	private int correctReward;
	private int solved;


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

	public Puzzle randomPuzzle(Puzzle puzzle) throws SQLException 
	{
		int randomNum = ThreadLocalRandom.current().nextInt(1, 27 + 1);

		if(puzzle.getSolved() == 0)
		{
			puzzle = puzzle.getPuzzle(randomNum);
		} 
		else 
		{
			randomPuzzle(puzzle);
		}
		return puzzle;
	}

	public void solvePuzzle(Room room, Player player, Puzzle puzzle) throws SQLException, ClassNotFoundException 
	{
		boolean playerDead = false;
		boolean puzzleSolved = false;
		puzzle = randomPuzzle(puzzle);
		String userIn = "";
		int input = 0;
		Quest quest = new Quest();

		do {
			player.slowText("+------------------------------------------------------------------+");
			player.slowText(puzzle.puzzleQuestion + "\t\n" + puzzle.optA 
					+ "\t\n" + puzzle.optB + "\t\n" + puzzle.optC + "\t\n" + puzzle.optD);
			player.slowText("+------------------------------------------------------------------+");

			if (!in.hasNext()) {
				in.next();
			} else {
				userIn = in.next();
			}

			if(userIn.equalsIgnoreCase(puzzle.getPuzzleAnswer())) {
				puzzleSolved = true;
				if(puzzleSolved) {
					player.setNumSolved(player.getNumSolved()+1);
					SQLiteDB sdb = GameController.getDB();
					String sql = "UPDATE Puzzle Set solved = 1 WHERE puzzleNumber = " + puzzle.getPuzzleID();
					sdb.updateDB(sql);
					sql = "UPDATE Room Set roomClear = 1 WHERE roomNumber = " + room.getRoomID();
					sdb.updateDB(sql);
					sdb.close();
					player.setScore(player.getScore()+20);
					quest.addPuzzle(quest, room);
					quest.addRoomClear(quest, room);
				}
			} else {

				if(!playerDead && !puzzleSolved) {
					player.setHitPoints(player.getHitPoints() - puzzle.getIncorrectAnsDamage());
					player.slowText("+------------------------------------------------------------------+");
					player.slowText("Player took " + puzzle.getIncorrectAnsDamage() + " damage this turn!");
					player.slowText("+------------------------------------------------------------------+");
					if(player.getHitPoints() < 1) {
						playerDead = true;
					}
				}
			}
		}while(!puzzleSolved);
		if(playerDead) {
			//gameOver();
			player.slowText("+------------------------------------------------------------------+");
			player.slowText("Oh no you ran out of health.  Game over please try again!");
			player.slowText("+------------------------------------------------------------------+");
			
				System.exit(0);
			
		}


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
		return incorrectDamage;
	}

	/** Method: setIncorrectAnsDamage
	 * Sets the point reduction for the puzzle
	 * @param incorrectAnsDamage
	 */ 
	public void setIncorrectAnsDamage(int incorrectAnsDamage) 
	{
		this.incorrectDamage = incorrectAnsDamage;
	}

	/** Method: getCorrectAnsReward
	 * @return correctAnsReward
	 */ 
	public int getCorrectAnsReward() 
	{
		return correctReward;
	}

	/** Method: setCorrectAnsDamage
	 * Sets the reward for solving the puzzle
	 * @param correctAnsReward
	 */ 
	public void setCorrectAnsReward(int correctAnsReward) 
	{
		this.correctReward = correctAnsReward;
	}

	public int getSolved() {
		return solved;
	}

	public void setSolved(int solved) {
		this.solved = solved;
	}

	@Override
	public String toString() 
	{
		return "Puzzles [\npuzzleID=" + puzzleID + "\npuzzleQuestion=" + puzzleQuestion + " \npuzzleAnswer=" + puzzleAnswer
				+ "\noptA=" + optA + "\noptB=" + optB + "\noptC=" + optC + "\noptD=" + optD + "\nincorrectAnsDamage="
				+ incorrectDamage + "\ncorrectAnsReward=" + correctReward + "]";
	}	
}