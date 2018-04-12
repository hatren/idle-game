package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuildingView extends JPanel{
	// Variables
	private JLabel buildingInfo;
	private JButton upgradeButton;
	
	// Constructor
	public BuildingView(BuildingModel model) {
//		Building building = new Building(1, user.getScale());
		setLayout(new BorderLayout());
		
		// TextArea
		buildingInfo = new JLabel(model.getInfo());
		add(buildingInfo, BorderLayout.CENTER);

		// UpgradeButton
		upgradeButton = new JButton("Upgrade: " + model.getUpgradeCost());
		upgradeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				user.currency -= building.getUpgradeCost();
				model.upgrade(1);
				buildingInfo.setText(model.getInfo());
				upgradeButton.setText("Upgrade: " + Double.toString(model.getUpgradeCost()));
			}
		});
		add(upgradeButton, BorderLayout.SOUTH);
		
		
//		user.addBuilding(building);
//		idleFrame.add(buildingInfo);
//		idleFrame.add(upgradeButton);
	}
}
