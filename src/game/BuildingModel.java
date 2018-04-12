package game;

import java.text.DecimalFormat;

public class BuildingModel {
	
	// Variables
	private double level = 0;
	private double scale;
	private String buildingName;
	private double income;
	private double rate;
	private double upgradeCost;
	private DecimalFormat decimalFormat = new DecimalFormat("#.##");
	private double elapsed = 0;
	
	public void addElapsed(double time) {
		elapsed += time;
	}
	
	// Constructor
	public BuildingModel(int level, int scale) {
		this.scale = scale;
		this.buildingName = getName();
		upgrade(level);
	}
	
	// getName()
	private String getName() {
		return "Building " + scale;
	}
	
	// getInfo()
	public String getInfo() {
		String info = 
				buildingName + "\n" +
				"Level: " + level + "\n" +
				"Income: " + decimalFormat.format(income) + "\n" +
				"Rate: " + decimalFormat.format(rate/1000);
		return info;
	}
	
	// upgrade()
	public void upgrade(int increase) {
		level += increase;
		income = Math.pow(level, 2) + scale-1;
		rate = 1000*(1/level + scale - 1);
		upgradeCost = Math.pow(4 + scale, level);
	}
	
	// getMoney()
	public double getMoney() {
		if((elapsed/rate) >= 1) {
			elapsed = elapsed - rate;
			return income;
		}
		else {
			return 0;
		}
	}
	
	// getIncome()
	public double getIncome() {
		return income;
	}
	
	// getRate()
	public double getRate() {
		return rate/1000;
	}
	
	// getUpgradeCost()
	public double getUpgradeCost() {
		return upgradeCost;
	}
}