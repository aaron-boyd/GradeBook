package Organization;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Semester {
	private String myTitle;
	private double myGPA;
	private ArrayList<Class> myClasses;
	
	public Semester(){
		this.myTitle = "";
		this.myGPA = 0.0;
		this.myClasses = new ArrayList<Class>(0);
	}
	
	public Semester(String title ){
		this.myTitle = title;
		this.myGPA = 0.0;
		this.myClasses = new ArrayList<Class>(0);
	}
	
	public Semester(String title, ArrayList<Class> classes){
		this.myTitle= title;
		this.myClasses = new ArrayList<Class>(classes);
	}
	
	public void addClass(String title, ArrayList<Category> categories){
		this.myClasses.add(new Class(title,categories));
	}
	
	public void addClass(Class cls){
		this.myClasses.add(cls);
	}
	
	
	public String getTitle(){
		return myTitle;
	}
	
	public DefaultMutableTreeNode createNodes(){
		DefaultMutableTreeNode semesterNode = new DefaultMutableTreeNode(this.myTitle);
		for(Class c: myClasses){
			c.contructNodes(semesterNode);
	
		}
		return semesterNode;
	}
	
	public void openSemester(String homeDirectory){
		String directory = homeDirectory + "GradeBook\\" + myTitle;
		File f = new File(directory);
		List<String> classTitles = (List<String>)Arrays.asList(f.list());
		for(String c: classTitles){
			Class newClass = new Class(c);
			newClass.openClass(directory);
			myClasses.add(newClass);
			
		}
	}
	
	public String toString(){
		return myTitle + "\n" + myClasses.toString();
	}
}
