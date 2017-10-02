package Organization;

import java.util.ArrayList;

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
	
	public Semester(String title, ArrayList<Class> classes){
		this.myTitle= title;
		this.myClasses = new ArrayList<Class>(classes);
	}
	
	public void addClass(String title, ArrayList<Category> categories){
		this.myClasses.add(new Class(title,categories));
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
	
	public String toString(){
		return myTitle + "\n" + myClasses.toString();
	}
}
