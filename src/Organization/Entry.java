package Organization;

import javax.swing.tree.DefaultMutableTreeNode;

public class Entry {
	private String myTitle;
	private double myScore;
	private double myTotal;

	public Entry() {
		this.myTitle = "";
		this.myScore = 0.0;
		this.myTotal = 0.0;
	}
	
	public Entry(String title, double score, double total){
		this.myTitle = title;
		this.myScore = score;
		this.myTotal = total;
	}
	
	public Entry(Entry entry){
		this.myTitle = entry.getTitle();
		this.myScore = entry.getScore();
		this.myTotal = entry.getTotalPoints();
	}
	
	public void setTitle(String title){
		this.myTitle = title;
	}
	
	public void setScore(double score, double total){
		this.myScore = score;
		this.myTotal = total;
	}
	
	public String getTitle(){
		return this.myTitle;
	}
	
	public double getScore(){
		return this.myScore;
	}
	
	public double getTotalPoints(){
		return this.myTotal;
	}
	
	public String toString(){
		return this.myTitle + "           " + this.myScore + "/" + this.myTotal;
	}
	
	public void constructNode(DefaultMutableTreeNode topNode){
		topNode.add(new DefaultMutableTreeNode(this.toString()));
	}
}
