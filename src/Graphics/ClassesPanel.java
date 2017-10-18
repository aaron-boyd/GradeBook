package Graphics;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import Organization.Semester;

public class ClassesPanel extends JPanel {

	private JTree myTreeSem;
	private JScrollPane myTreePane;
	private Semester myCurrentSemester;

	public ClassesPanel(Semester currentSemester) {
		this.myCurrentSemester = currentSemester;
		this.createTree();
	}

	public void updateCurrrentSemester(Semester sem) {
		this.myCurrentSemester = sem;
		this.createTree();
	}

	public void createTree() {
		if (myCurrentSemester != null) {
			this.myTreeSem = new JTree(myCurrentSemester.createNodes());
			this.remove(myTreePane);
		} else {
			DefaultMutableTreeNode nullNode = new DefaultMutableTreeNode("Select or create a semester...");
			this.myTreeSem = new JTree(nullNode);
		}
		this.myTreePane = new JScrollPane(myTreeSem);
		this.myTreeSem.setFont(new Font("Courier New", Font.BOLD,24));
		this.myTreePane.setPreferredSize(new Dimension(750, 500));
		this.add(this.myTreePane);
		this.revalidate();
	}

}
