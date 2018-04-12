package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TitleFrame {
	// Vars
	private JFrame titleFrame = new JFrame();
	private JTextArea title = new JTextArea("Idle Game");
	private JButton startButton = new JButton("Start");
	
	// Ctor
	public TitleFrame(GUI graphicUI) {
		// Initialize Frame
		titleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		titleFrame.pack();
		titleFrame.setSize(new Dimension(500,500));
		titleFrame.setLayout(new FlowLayout());
		
		// Initialize TextArea
		title.setEditable(false);
		
		// Initialize Button
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graphicUI.setIdleFrame();
				titleFrame.setVisible(false);
			}
		});
		
		// Add Components
		titleFrame.add(title);
		titleFrame.add(startButton);
		
		// Make Visible
		titleFrame.setVisible(true);
	}
	
	// getFrame
	public JFrame getFrame() {
		return titleFrame;
	}
}
