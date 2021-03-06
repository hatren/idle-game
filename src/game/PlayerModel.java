package game;

import java.util.ArrayList;

import assets.Building;
import assets.Item;

public class PlayerModel {
	// Vars
	private String userName;
	private ArrayList<BuildingModel> buildingList;
	public double currency = 1;
	public double income;
	
	// Ctor
	// Make it so it reads a file to load a player
	public PlayerModel() {
		buildingList = new ArrayList<BuildingModel>();
	}
	
	// getCurrency()
	public double getCurrency() {
		return currency;
	}
	
	// getIncome()
	public double getIncome() {
		income = 0;
		for(BuildingModel building: buildingList) {
			income += (building.getIncome()/building.getRate());
		}
		return income;
	}
	
	// getBuildingList()
	public ArrayList<BuildingModel> getBuildingList() {
		return buildingList;
	}
	
	// addBuilding()
	public void addBuilding(BuildingModel building) {
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