package Organization;

import java.util.ArrayList;

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
}
