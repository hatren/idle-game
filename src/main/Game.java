package main;

import java.io.File;
import java.io.FileWriter;

import gui.GUI;
import user.Player;

public class Game {
	
	// Vars
	private Player user = new Player();
	private Clock globalClock = new Clock(120);
	private GUI graphicUI = new GUI(user, globalClock);
	private File saveData;
	private FileWriter fileWriter;
	
	// saveData
	public void saveData() {

	}

	// loadData
	public void loadData() {

	}

	// start()
	// loadData to create Player
	// Make GUI with player and start globalClock
}
