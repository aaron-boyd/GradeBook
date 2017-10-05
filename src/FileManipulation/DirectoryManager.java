package FileManipulation;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import Organization.Semester;

public class DirectoryManager {

	private final String myHomeDirectory = System.getProperty("user.home") + "\\";

	public DirectoryManager() {

	}

	public boolean checkIfNew() {
		File f = new File(myHomeDirectory + "GradeBook");
		if (!f.exists()) {
			return true;
		}
		return false;
	}

	public boolean createNewDirectory(String directory) {
		File f = new File(this.myHomeDirectory + directory);
		if(f.mkdir()){
			return true;
		}
		return false;
	}
	
	public List<String> checkForSemesters(){
		File f = new File(myHomeDirectory + "GradeBook");
		return (List<String>)Arrays.asList(f.list());
	}
	
	
	public String getHomeDirectory(){
		return this.myHomeDirectory;
	}

}
