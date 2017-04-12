package controller;

public class Player extends Combat{
	
	private int playerID;
	private String playerName;
	private int hitPoints;
	private int minDamage;
	private int maxDamage;
	private int elemantalDamage;
	private int damagePerTurn;
	private int numTurns;
	
	
	
	public int getPlayerID() {
		return playerID;
	}
	
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
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
	
	public int getElemantalDamage() {
		return elemantalDamage;
	}
	
	public void setElemantalDamage(int elemantalDamage) {
		this.elemantalDamage = elemantalDamage;
	}
	
	public int getDamagePerTurn() {
		return damagePerTurn;
	}
	
	public void setDamagePerTurn(int damagePerTurn) {
		this.damagePerTurn = damagePerTurn;
	}
	
	public int getNumTurns() {
		return numTurns;
	}
	
	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}
	

}
