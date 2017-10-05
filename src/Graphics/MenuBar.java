package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import FileManipulation.DirectoryManager;
import Organization.Semester;

public class MenuBar extends JMenuBar {

	private JMenu myMenu;
	private ClassesPanel myClassesPanel; 
	private Semester myCurrentSemester;
	private ArrayList<JMenuItem> semesterItems;
	private DirectoryManager myDirectoryManager;

	public MenuBar(DirectoryManager directoryManager, Semester semester,ClassesPanel classesPanel) {
		super();
		myClassesPanel = classesPanel;
		myDirectoryManager = directoryManager;
		myCurrentSemester = semester;
		myMenu = new JMenu("Semester Menu");
		add(myMenu);
		populateExistingSemesters();

	}

	public void populateExistingSemesters() {
		List<String> semesters = myDirectoryManager.checkForSemesters();
		for (String s : semesters) {
			JMenuItem sem = new JMenuItem(s);
			sem.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					myCurrentSemester = new Semester(sem.getText());
					myCurrentSemester.openSemester(myDirectoryManager.getHomeDirectory());
					myClassesPanel.updateCurrrentSemester(myCurrentSemester);
				}

			});

			myMenu.add(sem);
		}
	}

}
