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

	private static DirectoryManager directoryManager;
	private static GradeBookFrame gradeBookFrame;

	public static void main(String[] args) {
		directoryManager = new DirectoryManager();
		gradeBookFrame = new GradeBookFrame();
		if (directoryManager.checkIfNew()) {
			directoryManager.createNewDirectory("GradeBook");
			System.out.println("Welcome to GradeBook new user...");
		} else {
			System.out.println("Welcome back user...");
		}
		
	

	}
}
