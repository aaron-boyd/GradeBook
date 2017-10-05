package Organization;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Class {
	private String myTitle;
	private ArrayList<Category> myCategories;

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

	public String getTitle() {
		return this.myTitle;
	}

	public void openClass(String dir) {
		String directory = dir + "\\" + this.myTitle;
		File f = new File(directory);
		List<String> categories = (List<String>)Arrays.asList(f.list());
		for(String s: categories){
			Category newCategory = new Category(s);
			newCategory.openCategory(directory);
			this.myCategories.add(newCategory);
		}
	}

	public String toString() {
		String categories = "";
		for (Category c : myCategories) {
			categories += c.toString() + "\n";
		}
		return "\n" + myTitle + "\n" + categories;
	}


	public double calculateGrade() {
		double totalGrade = 0.0;

		for (Category c : myCategories) {
			totalGrade += c.getCategoryGrade();
		}

		return totalGrade;
	}

	public void contructNodes(DefaultMutableTreeNode topNode) {
		DefaultMutableTreeNode classNode = new DefaultMutableTreeNode(this.myTitle);
		for (Category c : myCategories) {
			c.constructNodes(classNode);
		}
		topNode.add(classNode);

	}

}
