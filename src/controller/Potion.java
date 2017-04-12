package controller;

public class Potion extends Item {
	private int numOfTurn;
	private int healPerTurn;
	
	public int getNumOfTurn() {
		return numOfTurn;
	}
	public void setNumOfTurn(int numOfTurn) {
		this.numOfTurn = numOfTurn;
	}
	public int getHealPerTurn() {
		return healPerTurn;
	}
	public void setHealPerTurn(int healPerTurn) {
		this.healPerTurn = healPerTurn;
	}
	
}
