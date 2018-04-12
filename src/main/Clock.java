package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Clock {
	// Vars
	private int time;
	private Timer timer;
	
	// Ctor
	public Clock(int fps) {
		this.time = (1000/fps);
		// Timer
		timer = new Timer(time, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
	
	// getTimer()
	public Timer getTimer() {
		return timer;
	}
	
	// getFPS()
	public int getTime() {
		return time;
	}
}
