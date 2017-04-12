package controller;

public class Item {
	
	private String itemName;
	private double itemWeight;
	private int rarity;


	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
			this.itemName = itemName;
		}
	public double getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(double itemWeight) {
		this.itemWeight = itemWeight;
	}
		
	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
}
