package Organization;
import java.util.ArrayList;
import java.util.Collections;

public class Class {
	private String myTitle;
	private ArrayList<Category> myCategories;
	private ArrayList<Integer> myGradingScale;

	public Class() {
		this.myTitle = "";
		this.myCategories = new ArrayList<Category>(0);
	}

	public Class(String title) {
		this.myTitle = title;
		this.myCategories = new ArrayList<Category>(0);
	}
	
	public Class(String title, ArrayList<Category> categories) {
		this.myTitle = title;
		this.myCategories = new ArrayList<Category>(categories);
	}
	

	public void addCategory(String title, double weight, ArrayList<Entry> entries) {
		this.myCategories.add(new Category(title, weight, entries));
	}

	public void addCategory(String title, double weight) {
		this.myCategories.add(new Category(title, weight));
	}

	public void removeCategory(int i) {
		this.myCategories.remove(i);
	}

	public void addToGradingScale(int num) {
		this.myGradingScale.add(num);
		Collections.sort(this.myGradingScale);
	}

	public double calculateGrade() {
		double totalGrade = 0.0;

		for (Category c : myCategories) {
			totalGrade += c.getCategoryGrade();
		}
		
		return totalGrade;
	}

}
