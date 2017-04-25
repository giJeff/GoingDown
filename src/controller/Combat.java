package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Combat {

	Scanner in = new Scanner(System.in);
	
	public void battle(Player player, int minIndex, int maxIndex) throws SQLException {
		
		ArrayList<Monster> monsterList = new ArrayList<>();
		Monster monster = new Monster();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		System.out.println("get " + randomNum + " Monsters!");
		monsterList.addAll(monster.getBattleMonsters(randomNum, minIndex, maxIndex));

		boolean playerDead = false;
		int userIn = 0;

		for (int i = 0; i < monsterList.size(); i++) {
			monster = monsterList.get(i);
			boolean monsterDead = false;
			do {

				while(!playerDead && !monsterDead) {
					
					System.out.println("-----------------------------------");
					System.out.println("A " + monster.getMonsterName() + " has " + monster.getHitPoints() + " health left");
					System.out.println("Player has " + player.getHitPoints() + "  health left");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Run");
					System.out.println("-----------------------------------");

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
							player.setNumKilled(player.getNumKilled()+1);
						}
					} else {
						System.out.println("No flee logic yet");
					}
				}
				System.out.println("-----------------------------------");
				System.out.println("playerDead = " + playerDead + " monsterDead = " + monsterDead);
			} while(!playerDead && !monsterDead);
			
			if(playerDead) {
				//gameOver();
			}
		}

	}
	
}
