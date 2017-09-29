import FileManipulation.DirectoryManager;
import Graphics.GradeBookFrame;

public class GradeBookTester {
	
	private static DirectoryManager directoryManager;
	private static GradeBookFrame gradeBookFrame;

	public static void main(String[] args) {
		directoryManager = new DirectoryManager();
		gradeBookFrame = new GradeBookFrame();
		if(directoryManager.checkIfNew()){
			directoryManager.createNewDirectory("GradeBook");
			System.out.println("Welcome to GradeBook new user...");
		}else{
			System.out.println("Welcome back user...");
		}
		
		
	}
}
