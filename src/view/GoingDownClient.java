package view;
import controller.Player;

import java.sql.SQLException;
import java.util.Scanner;


public class GoingDownClient
{
	private Player p1;
	
	public GoingDownClient()
	{
		try
		{
			p1 = new Player();
		} 
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		

		System.out.println("Going Down");
		System.out.println(" ");
		System.out.println("1. New Game" + " " + "Resume Game");

		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();

		if(choice == 1)
		{
			System.out.println("Please enter your name");
		}
		String pName = input.next();

		

	}

}

