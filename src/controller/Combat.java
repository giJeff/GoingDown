package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import model.SQLiteDB;
import view.ConsoleUI;

public class Combat {

	Scanner in = new Scanner(System.in);
	
	public void battle(Player player, int minIndex, int maxIndex, int oldRoom, Room room) throws SQLException, ClassNotFoundException {
		
		ArrayList<Monster> monsterList = new ArrayList<>();
		Monster monster = new Monster();
		Quest quest = new Quest();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		//System.out.println("get " + randomNum + " Monsters!");
		monsterList.addAll(monster.getBattleMonsters(randomNum, minIndex, maxIndex));

		boolean playerDead = false;
		int userIn = 0;

		for (int i = 0; i < monsterList.size(); i++) {
			monster = monsterList.get(i);
			boolean monsterDead = false;
			do {

				while(!playerDead && !monsterDead) {
					
					player.slowText("-----------------------------------");
					player.slowText("A " + monster.getMonsterName() + " has " + monster.getHitPoints() + " health left");
					player.slowText("Player has " + player.getHitPoints() + "  health left");
					player.slowText("\t1. Attack");
					player.slowText("\t2. Run");
					player.slowText("-----------------------------------");

					if (!in.hasNextInt()) {
						in.next();
					} else {
						userIn = in.nextInt();
					}

					if(userIn == 1) {
						if(monster.getAttackFirst() == 0) {
							monsterDead = player.playerAttack(playerDead, monsterDead, player, monster);
							playerDead = monster.monsterAttack(playerDead, monsterDead, player, monster);
						} else {
							playerDead = monster.monsterAttack(playerDead, monsterDead, player, monster);
							monsterDead = player.playerAttack(playerDead, monsterDead, player, monster);
						}
						if(monsterDead) {
							SQLiteDB sdb = GameController.getDB();
							String sql = "UPDATE Room Set roomClear = 1 WHERE roomNumber = " + room.getRoomID();
							sdb.updateDB(sql);
							sdb.close();	
							player.setNumKilled(player.getNumKilled()+1);
							player.setScore(player.getScore()+50);
							quest.addMonster(quest, room);
						}
					} else {
						System.out.println("No flee logic yet");
						room.setRoomID(oldRoom);
						return;
					}
				}
				player.slowText("-----------------------------------");
				player.slowText("playerDead = " + playerDead + " monsterDead = " + monsterDead);
			} while(!playerDead && !monsterDead);
			
			if(playerDead) {
				//gameOver();
				player.slowText("-----------------------------------");
				player.slowText("Oh no you ran out of health.  Game over please try again!");
				player.slowText("-----------------------------------");
				
					System.exit(0);
				
			}
		}

	}
	
public void battleBoss(Player player, int minIndex, int maxIndex, int oldRoom, Room room) throws SQLException, ClassNotFoundException {
		
		ArrayList<Monster> monsterList = new ArrayList<>();
		Monster monster = new Monster();
		Quest quest = new Quest();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 1 + 1);
		//System.out.println("get " + randomNum + " Monsters!");
		monsterList.addAll(monster.getBattleMonsters(randomNum, minIndex, maxIndex));

		boolean playerDead = false;
		int userIn = 0;

		for (int i = 0; i < monsterList.size(); i++) {
			monster = monsterList.get(i);
			boolean monsterDead = false;
			do {

				while(!playerDead && !monsterDead) {
					
					player.slowText("-----------------------------------");
					player.slowText("A " + monster.getMonsterName() + " has " + monster.getHitPoints() + " health left");
					player.slowText("Player has " + player.getHitPoints() + "  health left");
					player.slowText("\t1. Attack");
					player.slowText("\t2. Run");
					player.slowText("-----------------------------------");

					if (!in.hasNextInt()) {
						in.next();
					} else {
						userIn = in.nextInt();
					}

					if(userIn == 1) {
						if(monster.getAttackFirst() == 0) {
							monsterDead = player.playerAttack(playerDead, monsterDead, player, monster);
							playerDead = monster.monsterAttack(playerDead, monsterDead, player, monster);
						} else {
							playerDead = monster.monsterAttack(playerDead, monsterDead, player, monster);
							monsterDead = player.playerAttack(playerDead, monsterDead, player, monster);
						}
						if(monsterDead) {
							SQLiteDB sdb = GameController.getDB();
							String sql = "UPDATE Room Set roomClear = 1 WHERE roomNumber = " + room.getRoomID();
							sdb.updateDB(sql);
							sdb.close();
							player.setNumKilled(player.getNumKilled()+1);
							player.setScore(player.getScore()+50);
							quest.addBoss(quest, room);
						}
					} else {
						System.out.println("No flee logic yet");
						room.setRoomID(oldRoom);
						return;
					}
				}
				player.slowText("-----------------------------------");
				player.slowText("playerDead = " + playerDead + " monsterDead = " + monsterDead);
			} while(!playerDead && !monsterDead);
			
			if(playerDead) {
				//gameOver();
				player.slowText("-----------------------------------");
				player.slowText("Oh no you ran out of health.  Game over please try again!");
				player.slowText("-----------------------------------");
				
					System.exit(0);
				
			}
		}

	}
	
}
