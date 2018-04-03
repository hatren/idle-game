package main;

import gui.GUI;
import user.Player;

public class Main {
	public static void main(String[] args) {
		Player user = new Player();
		Clock clock = new Clock(120);
		GUI test = new GUI(user, clock);
		
		test.start();
	}
}
