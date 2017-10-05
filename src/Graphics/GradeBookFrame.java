package Graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

import FileManipulation.DirectoryManager;
import Organization.Semester;

public class GradeBookFrame extends JFrame {
	
	private Semester myCurrentSemester;
	private DirectoryManager myDirectoryManager;
	private ClassesPanel myClassesPanel;
	private MenuBar myMenuBar;

	public GradeBookFrame(DirectoryManager directoryManager) {
		this.myClassesPanel = new ClassesPanel(myCurrentSemester,this);
		this.myMenuBar = new MenuBar(directoryManager,myCurrentSemester,myClassesPanel);
		this.setJMenuBar(this.myMenuBar);
		setSize(new Dimension(1000,1000));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("GradeBook");
		setVisible(true);
		this.getContentPane().add(this.myClassesPanel);
		
	}
	

}
