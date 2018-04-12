package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import assets.Building;

public class IdleController {
	// Vars
	private int fps;
	private Timer timer;
	private IdleView view;
	private PlayerModel model;
	
	// Ctor
	public IdleController(int fps) {
		this.fps = (1000/fps);
		// Timer
		timer = new Timer(fps, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Update Currency Text
				view.getCurrencyTextArea().setText("Currency: " + model.getCurrency() + "\n" + 
										view.getFormat().format(model.getIncome()) + " per sec");
				
				// Check Buy Button
				if(model.getBuyCost() > model.currency) {
					view.getBuyButton().setEnabled(false);
				}
				else {
					view.getBuyButton().setEnabled(true);
				}
				
				// Check Upgrade Buttons
				for(BuildingModel buildingModel: model.getBuildingList()) {
					buildingModel.addElapsed(getFPS()); 
					model.currency += buildingModel.getMoney();
					if(buildingModel.getUpgradeCost() > model.currency) {
						building.getButton().setEnabled(false);
					}
					else {
						building.getButton().setEnabled(true);
					}
				}
			}
		});
	}
	
	// getTimer()
	public Timer getTimer() {
		return timer;
	}
	
	// getFPS()
	public int getFPS() {
		return fps;
	}
}