import java.util.Random;

package controller;


public class Combat extends Character{
	

	private int attack;


	
	public int attack(int minAttack, int maxAttack, int elementalDamage) {
		Random rand = new Random();
		randomAttack = minAttack + rand.nextInt((maxAttack - minAttack) + 1);
		attack=randomAttack+elementalDamage;
		
		return attack;
	}

	
	public void deadMonster(int numDeadMonster) {
		int numDead = numDeadMonster;
		
		
	}
    
}
