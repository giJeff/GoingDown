package controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Movement {

	Scanner in = new Scanner(System.in);

	public int choosePath(Room room, Player player) throws SQLException 
	{
		boolean path = false;
		int nextRoom=0;
		int userIn=0;
		while(!path) 
		{
			Room temp = room.getRoom(room.getExitNorth());
			String peekNorth = (room.getExitNorth() != 0) ? temp.getRoomDescription() : "There is nothing in this direction." ;

			temp = room.getRoom(room.getExitEast());
			String peekEast = (room.getExitEast() != 0) ? temp.getRoomDescription() : "There is nothing in this direction." ;
			
			temp = room.getRoom(room.getExitSouth());
			String peekSouth = (room.getExitSouth() != 0) ? temp.getRoomDescription() : "There is nothing in this direction." ;

			temp = room.getRoom(room.getExitWest());
			String peekWest = (room.getExitWest() != 0) ? temp.getRoomDescription() : "There is nothing in this direction." ;
			
			player.slowText("-----------------------------------");
			player.slowText("Choose your direction. Enter a number: ");
			player.slowText("\t1. North \t->\t" + peekNorth);
			player.slowText("\t2. East \t->\t" + peekEast);
			player.slowText("\t3. South \t->\t" + peekSouth);
			player.slowText("\t4. West \t->\t" + peekWest);
			player.slowText("-----------------------------------");

			if (!in.hasNextInt()) {
				in.next();
			} else {
				userIn = in.nextInt();
			}
			if(userIn == 1) {
				if(room.getExitNorth() == 0) {
					player.slowText("There is a wall here try again.");
				} else {
					nextRoom = room.getExitNorth();
					path = true;
				}
			} else if(userIn == 2) {
				if(room.getExitEast() == 0) {
					player.slowText("There is a wall here try again.");
				} else {
					nextRoom = room.getExitEast();
					path = true;
				}

			} else if(userIn == 3) {
				if(room.getExitSouth() == 0) {
					player.slowText("There is a wall here try again.");
				} else {
					nextRoom = room.getExitSouth();
					path = true;
				}
			} else if(userIn == 4) {
				if(room.getExitWest() == 0) {
					player.slowText("There is a wall here try again.");
				} else {
					nextRoom = room.getExitWest();
					path = true;
				}
			}
		} return nextRoom;
	}



}
