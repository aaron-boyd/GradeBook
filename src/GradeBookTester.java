import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import FileManipulation.DirectoryManager;
import Graphics.GradeBookFrame;
import Organization.Category;
import Organization.Class;
import Organization.Entry;
import Organization.Semester;

public class GradeBookTester {


	public static void main(String[] args) {
		DirectoryManager directoryManager = new DirectoryManager();
		GradeBookFrame gradeBookFrame = new GradeBookFrame(directoryManager);
		
		if (directoryManager.checkIfNew()) {
			directoryManager.createNewDirectory("GradeBook");
			System.out.println("Welcome to GradeBook new user...");
		} else {
			System.out.println("Welcome back user...");
			directoryManager.checkForSemesters();
		}
		
	

	}
}
