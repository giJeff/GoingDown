package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Class : DB.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Feb 25, 2017
 *
 * This class controls basic DB functionality
 *
 * Purpose:Has Query and Update DB
 */
abstract public class DB
{
	protected String dbName = "Game.db";
	protected String sJdbc;
	protected String sDriverName;
	protected Connection conn;
	protected String sDbUrl;
	protected int timeout = 5;
	
	/** Method: queryDB
	 * Purpose: read from the database
	 * @param sql
	 * @throws SQLException
	 * @return ResultSet
	 */
	public ResultSet queryDB(String sql) throws SQLException
	{
		ResultSet rs = null;
		Statement stmt = conn.createStatement();
		stmt.setQueryTimeout(timeout);
		rs = stmt.executeQuery(sql);
		return rs;
	}
	
	/** Method: updateDB
	 * Purpose: Updates the database
	 * @param SQL
	 * @throws SQLException
	 * @return boolean
	 */
	public boolean updateDB(String SQL) throws SQLException
	{
		Statement stmt = conn.createStatement();
		boolean success = stmt.execute(SQL);
		return success;
	}
	
	/** Method: count
	 * Purpose: Gets the count of records in the specified table 
	 * @param table
	 * @return int
	 */
	public int count(String table)
	{
		int cnt = 0;
		try
		{
			Statement stmt = conn.createStatement();
			String sql = "Select count(*) as count from \"" + table + "\"";
			ResultSet rs =  stmt.executeQuery(sql);
			cnt = rs.getInt(1);
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe.getMessage());
		}
		return cnt;
	}
	
	/** Method: getMaxValue
	 * Purpose: Gets max value for a particular field in a particular table
	 * @param columnName
	 * @param table
	 * @return
	 * @return int
	 */
	public int getMaxValue(String columnName,String table)
	{
		int max = 0;
		try
		{
			Statement stmt = conn.createStatement();
			String sql = "Select MAX(" + columnName + ") from " + table;
			ResultSet rs =  stmt.executeQuery(sql);
			max = rs.getInt(1);
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe.getMessage());
		}
		return max;
	}
	public int getMaxOfSomething(String columnName,String table, String where, int value)
	{
		int max = 0;
		try
		{
			Statement stmt = conn.createStatement();
			String sql = "Select MAX(" + columnName + ") from " + table + " where " + where + " = " + value;
			ResultSet rs =  stmt.executeQuery(sql);
			max = rs.getInt(1);
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe.getMessage());
		}
		return max;
	}
	public void updateTableInt(String table, String columnName, int setValue,  String where, int id) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE " + table + " SET " + columnName + " = " + setValue + " WHERE " + where + " = " + id;
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateTableFloat(String table, String columnName, float setValue,  String where, int id) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE " + table + " SET " + columnName + " = " + setValue + " WHERE " + where + " = " + id;
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateTableString(String table, String columnName, String setValue,  String where, int id) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE " + table + " SET " + columnName + " = " + setValue + " WHERE " + where + " = " + id;
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
