package Graphics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Organization.Semester;

public class MainPanel extends JPanel {
	
	private GradeBookFrame myGradeBookFrame;
	private ClassesPanel myClassesPanel;
	private AssignmentPanel myAssignmentPanel;
	private Semester myCurrentSemester;
	
	public MainPanel(Semester currentSemester, GradeBookFrame gradeBookFrame){
		this.myClassesPanel = new ClassesPanel(currentSemester);
		this.myCurrentSemester= currentSemester;
		this.myAssignmentPanel = new AssignmentPanel(currentSemester,myClassesPanel);
		this.setup();
		
		
	}
	
	public void updateCurrentSemester(Semester currentSemester){
		myCurrentSemester = currentSemester;
		this.myClassesPanel.updateCurrrentSemester(currentSemester);
		this.myAssignmentPanel.updateCurrentSemester(currentSemester);
	}
	
	private void setup(){
		GridBagConstraints c= new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.add(myClassesPanel, c);
		c.gridx = 1;
		this.add(myAssignmentPanel, c);
		
	}

}
