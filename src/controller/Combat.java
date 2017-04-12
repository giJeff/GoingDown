package controller;

import java.util.Random;



public class Combat {
	
	private int attack;

	public int attack(int minAttack, int maxAttack, int elementalDamage) {
		Random rand = new Random();
		int randomAttack = minAttack + rand.nextInt((maxAttack - minAttack) + 1);
		attack=randomAttack+elementalDamage;
		
		return attack;
	}

	public void deadMonster(int numDeadMonster) {
		int numDead = numDeadMonster;
			
	}
    
}
