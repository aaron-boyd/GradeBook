package Organization;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class Category {

	private String myTitle;
	private double myWeight;
	private ArrayList<Entry> myEntries;

	public Category() {
		this.myTitle = "";
		this.myWeight = 0.0;
		this.myEntries = new ArrayList<Entry>(0);
	}

	public Category(String title, double weight, ArrayList<Entry> entries) {
		this.myTitle = title;
		this.myWeight = weight;
		this.myEntries = new ArrayList<Entry>(entries);
	}

	public Category(String title, double weight) {
		this.myTitle = title;
		this.myWeight = weight;
		this.myEntries = new ArrayList<Entry>(0);
	}

	public void setTitle(String title) {
		this.myTitle = title;
	}

	public void setWeight(double weight) {
		this.myWeight = weight;
	}

	public void setAssignments(ArrayList<Entry> assignments) {
		this.myEntries = new ArrayList<Entry>(assignments);
	}

	public void addAssignment(Entry assignment) {
		this.myEntries.add(new Entry(assignment));
	}

	public void addAssignment(String title, double score, double total) {
		this.myEntries.add(new Entry(title, score, total));
	}

	public void removeEntry(int i) {
		this.myEntries.remove(i);
	}
	
	public String toString(){
		String entries ="";
		for(Entry e: myEntries){
			entries += e.toString() + "\n";
		}
		return myTitle + "\n" + entries;
	}

	public double getCategoryGrade() {
		double score = 0.0;
		double total = 0.0;
		
		if (!this.myEntries.isEmpty()) {
			for (Entry e : this.myEntries) {
				score += e.getScore();
				total += e.getTotalPoints();
			}

			return (score / total) * this.myWeight;
		} else {
			return this.myWeight;
		}
	}
	
	public void constructNodes(DefaultMutableTreeNode topNode){
		DefaultMutableTreeNode catNode = new DefaultMutableTreeNode(this.myTitle);
		for(Entry e: myEntries){
			e.constructNode(catNode);
		}
		topNode.add(catNode);
	}
}
