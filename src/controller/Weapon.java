package controller;

public class Weapon extends Item{
	private int minDamage;
	private int maxDamage;
	private int specialDamage;
	
	public int getMinDamage() {
		return minDamage;
	}
	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}
	public int getMaxDamage() {
		return maxDamage;
	}
	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}
	public int getSpecialDamage() {
		return specialDamage;
	}
	public void setSpecialDamage(int specialDamage) {
		this.specialDamage = specialDamage;
	}
}
