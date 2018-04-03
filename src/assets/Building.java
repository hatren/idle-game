package assets;

import java.text.DecimalFormat;

import javax.swing.JButton;

public class Building {
	
	// Vars
	private double level = 0;
	private double scale;
	private String buildingName;
	private double income;
	private double rate;
	private double upgradeCost;
	private JButton upgradeButton;
	private DecimalFormat decimalFormat = new DecimalFormat("#.##");
	
	public double elapsed = 0;
	
	// Ctor
	public Building(int level, int scale) {
//		this.level = level;
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
	
	// setButton()
	public void setButton(JButton upgradeButton) {
		this.upgradeButton = upgradeButton;
	}
	
	// getButton()
	public JButton getButton() {
		return upgradeButton;
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
