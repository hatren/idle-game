package gui;

import main.Clock;
import user.Player;

public class GUI {
	
	// Vars
	private Player user;
	private Clock clock;
	private TitleFrame titleFrame;
	private IdleFrame idleFrame;
//	private JFrame shopFrame;
	
	// Ctor
	public GUI(Player user, Clock clock) {
		this.user = user;
		this.clock = clock;
	}
	
	// setIdleFrame()
	public void setIdleFrame() {
		this.idleFrame = new IdleFrame(user, clock);
	}
	
	// getIdleFrame()
	public IdleFrame getIdleFrame() {
		return idleFrame;
	}
	
	// start();
	// show titleFrame
	public void start() {
		this.titleFrame = new TitleFrame(this);
		clock.getTimer().start();
	}
}
