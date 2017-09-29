package Graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GradeBookFrame extends JFrame {

	public GradeBookFrame() {
		MenuBar menuBar = new MenuBar();
		//this.setJMenuBar(menuBar);
		setSize(new Dimension(500,500));
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("GradeBook");
		setVisible(true);
	}
}
