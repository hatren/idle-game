package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import assets.Building;
import main.Clock;
import user.Player;

public class IdleView extends JPanel{
	
	// Vars
	private Player user;
//	private Clock clock;
	private JFrame idleFrame = new JFrame();
	private JTextArea currencyTextArea;
	private JButton buyButton;
	private DecimalFormat decimalFormat = new DecimalFormat("#.##");
	
	public JTextArea getCurrencyTextArea() {
		return currencyTextArea;
	}
	
	public DecimalFormat getFormat() {
		return decimalFormat;
	}
	
	public JButton getBuyButton() {
		return buyButton;
	}
	
	// Ctor
	public IdleView(Player user, Clock clock) {
		// Initialize
		this.user = user;
		idleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		idleFrame.pack();
		idleFrame.setSize(new Dimension(500,500));
		
		setLayout(new FlowLayout());
		
		// currencyTextArea
		currencyTextArea = new JTextArea("Currency: " + user.getCurrency());
		clock.getTimer().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Update Currency Text
				currencyTextArea.setText("Currency: " + user.getCurrency() + "\n" + 
										decimalFormat.format(user.getIncome()) + " per sec");
				
				// Check Buy Button
				if(user.getBuyCost() > user.currency) {
					buyButton.setEnabled(false);
				}
				else {
					buyButton.setEnabled(true);
				}
				
				// Check Upgrade Buttons
				for(Building building: user.getBuildingList()) {
					building.elapsed += clock.getTime();
					user.currency += building.getMoney();
					if(building.getUpgradeCost() > user.currency) {
						building.getButton().setEnabled(false);
					}
					else {
						building.getButton().setEnabled(true);
					}
				}
			}
		});
		idleFrame.add(currencyTextArea);
		
		// buyButton
		buyButton = new JButton("Buy: " + user.getBuyCost());
		buyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				user.currency -= user.getBuyCost();
				buyBuilding();
				buyButton.setText("Buy: " + user.getBuyCost());
			}
		});
		idleFrame.add(buyButton);
		
		idleFrame.setVisible(true);
	}
	
	// buyBuilding()
	public void buyBuilding() {
		Building building = new Building(1, user.getScale());
		
		// TextArea
		JTextArea buildingInfo = new JTextArea(building.getInfo());

		// UpgradeButton
		JButton upgradeButton = new JButton("Upgrade: " + building.getUpgradeCost());
		upgradeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				user.currency -= building.getUpgradeCost();
				building.upgrade(1);
				buildingInfo.setText(building.getInfo());
				upgradeButton.setText("Upgrade: " + Double.toString(building.getUpgradeCost()));
			}
		});
		
		// Add
		building.setButton(upgradeButton);
		user.addBuilding(building);
		idleFrame.add(buildingInfo);
		idleFrame.add(upgradeButton);
	}
	
	// getFrame()
	public JFrame getFrame() {
		return idleFrame;
	}
}