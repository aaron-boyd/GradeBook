package Graphics;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import Organization.Semester;

public class ClassesPanel extends JPanel {

	private GradeBookFrame myGradeBookFrame;
	private JTree myTreeSem;
	private JScrollPane myTreePane;
	private Semester myCurrentSemester;

	public ClassesPanel(Semester currentSemester, GradeBookFrame frame) {
		this.myGradeBookFrame = frame;
		this.myCurrentSemester = currentSemester;
		this.myTreeSem = new JTree(new DefaultMutableTreeNode("Select or create and new semester..."));
		this.myTreePane = new JScrollPane(myTreeSem);
		this.myTreePane.setPreferredSize(new Dimension(500,500));
		this.add(myTreePane);
		
	}
	
	public void updateCurrrentSemester(Semester sem){
		this.myCurrentSemester = sem;
		this.remove(myTreePane);
		this.createTree();
		this.add(myTreePane);
		this.myGradeBookFrame.revalidate();
	}
	
	public void createTree(){
		this.myTreeSem = new JTree(myCurrentSemester.createNodes());
		this.myTreePane = new JScrollPane(myTreeSem);
		this.myTreePane.setPreferredSize(new Dimension(500,500));
		
	}

	
}
