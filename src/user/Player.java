package user;

import java.util.ArrayList;

import assets.Building;
import assets.Item;

public class Player {
	
	// Vars
	private String userName;
	private ArrayList<Building> buildingList;
	private ArrayList<Item> itemList;
	public double currency = 1;
	public double income;
	
	// Ctor
	// Make it so it reads a file to load a player
	public Player() {
		buildingList = new ArrayList<Building>();
	}
	
	// getCurrency()
	public double getCurrency() {
		return currency;
	}
	
	// getIncome()
	public double getIncome() {
		income = 0;
		for(Building building: buildingList) {
			income += (building.getIncome()/building.getRate());
		}
		return income;
	}
	
	// getBuildingList()
	public ArrayList<Building> getBuildingList() {
		return buildingList;
	}
	
	// addItem()
	public void addItem(Item item) {
		itemList.add(item);
	}
	
	// addBuilding()
	public void addBuilding(Building building) {
		buildingList.add(building);
	}
	
	// getScale()
	public int getScale() {
		return buildingList.size() + 1;
	}
	
	// getBuyCost()
	public double getBuyCost() {
		return Math.pow(buildingList.size()+1, 4);
	}
	
}
