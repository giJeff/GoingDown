package controller;

import java.sql.SQLException;

import model.GameDBCreate;

public class CreateFilesController
{
	/**
	 * Method: createFile Purpose: Create the database for DOA
	 * 
	 * @return void
	 */
	public void createFile()
	{
		try
		{
			GameDBCreate sdb = new GameDBCreate();
			sdb.buildTables();
		}
		catch (SQLException e)
		{
			System.out.println("Creation failed");
		}
	}
}
