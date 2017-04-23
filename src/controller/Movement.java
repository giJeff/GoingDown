package controller;

import java.util.Scanner;

public class Movement {

	Scanner in = new Scanner(System.in);

	public int choosePath(Room room) 
	{
		boolean path = false;
		int nextRoom=0;
		int userIn=0;
		while(!path) 
		{
			System.out.println("-----------------------------------");
			System.out.println("Choose your direction. Enter a number: ");
			System.out.println(room.getExitNorth() + "\t1. North");
			System.out.println(room.getExitEast() + "\t2. East");
			System.out.println(room.getExitSouth() + "\t3. South");
			System.out.println(room.getExitWest() + "\t4. West");
			System.out.println("-----------------------------------");

			if (!in.hasNextInt()) {
				in.next();
			} else {
				userIn = in.nextInt();
			}
			if(userIn == 1) {
				if(room.getExitNorth() == 0) {
					System.out.println("There is a wall here try again.");
				} else {
					nextRoom = room.getExitNorth();
					path = true;
				}
			} else if(userIn == 2) {
				if(room.getExitEast() == 0) {
					System.out.println("There is a wall here try again.");
				} else {
					nextRoom = room.getExitEast();
					path = true;
				}

			} else if(userIn == 3) {
				if(room.getExitSouth() == 0) {
					System.out.println("There is a wall here try again.");
				} else {
					nextRoom = room.getExitSouth();
					path = true;
				}
			} else if(userIn == 4) {
				if(room.getExitWest() == 0) {
					System.out.println("There is a wall here try again.");
				} else {
					nextRoom = room.getExitWest();
					path = true;
				}
			}
		} return nextRoom;
	}

}
