package Graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

import Organization.Semester;

public class GradeBookFrame extends JFrame {
	
	private Semester currentSem;
	

	public GradeBookFrame() {
		MenuBar menuBar = new MenuBar();
		this.setJMenuBar(menuBar);
		setSize(new Dimension(500,500));
	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("GradeBook");
		setVisible(true);
		
		ClassesPanel panel = new ClassesPanel();
		panel.contructTree();
		
		this.add(panel);
	}
}
