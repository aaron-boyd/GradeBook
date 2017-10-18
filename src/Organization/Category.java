package Organization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class Category {

	private String myTitle;
	private double myWeight;
	private ArrayList<Entry> myEntries;

	public Category() {
		this.myTitle = "";
		this.myWeight = 0.0;
		this.myEntries = new ArrayList<Entry>(0);
	}

	public Category(String title) {
		this.myTitle = title;
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

	public String getTitle() {
		return this.myTitle;
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

	public void openCategory(String dir) {
		String directory = dir + "\\" + this.myTitle + "\\Entries.txt";
		File f = new File(directory);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String line;
			line = reader.readLine();
			this.myWeight = Double.parseDouble(line);
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("_");
				Entry newEntry = new Entry(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
				//System.out.println(newEntry.toString());
				this.myEntries.add(newEntry);
			}
		} catch (Exception e) {

		}

	}

	public String toString() {
		String entries = "";
		for (Entry e : myEntries) {
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
			double grade = (score / total) * this.myWeight;
			System.out.println(myTitle + " " + grade);
			return grade;

		} else {
			System.out.println(myTitle + " " + myWeight);
			return this.myWeight;
		}
	}

	public void constructNodes(DefaultMutableTreeNode topNode) {
		DefaultMutableTreeNode catNode = new DefaultMutableTreeNode(String.format("%-15s %s%%", myTitle, myWeight));
		for (Entry e : myEntries) {
			e.constructNode(catNode);
		}
		if (myEntries.isEmpty()) {
			catNode.add(new DefaultMutableTreeNode("N/A"));
		}
		topNode.add(catNode);

	}
}
