package Graphics;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Organization.Category;
import Organization.Class;
import Organization.Entry;
import Organization.Semester;

public class AssignmentPanel extends JPanel {

	private JComboBox<String> myCmbClasses;
	private JComboBox<String> myCmbCategory;
	private JButton myCmdAdd;
	private JTextField myTxtScore;
	private JTextField myTxtPoints;
	private JTextField myTxtTitle;
	private JLabel myLblGrade;
	private ClassesPanel myClassesPanel;
	private Semester myCurrentSemester;
	private Font myFont= new Font("Courier New", Font.BOLD,24);

	public AssignmentPanel(Semester currentSemester, ClassesPanel classesPanel) {
		this.myCurrentSemester = currentSemester;
		this.myClassesPanel = classesPanel;
		this.setup();

		myCmbClasses.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0){
				int index=myCmbClasses.getSelectedIndex();
				updateCmbCategory(index);
				updateGradeLabel(index);
			}

		});
		
		myCmdAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Entry newEntry = new Entry();
				int classIndex = myCmbClasses.getSelectedIndex();
				int categoryIndex = myCmbCategory.getSelectedIndex();
				newEntry.setTitle(myTxtTitle.getText());
				newEntry.setScore(Integer.parseInt(myTxtScore.getText()), Integer.parseInt(myTxtPoints.getText()));
				Category selectedCategory = myCurrentSemester.getClass(classIndex).getCategory(categoryIndex);
				selectedCategory.addAssignment(newEntry);
				myClassesPanel.createTree();
				updateGradeLabel(classIndex);
				myClassesPanel.revalidate();
			}
			
		});

	}

	public void updateCurrentSemester(Semester currentSemester) {
		this.myCurrentSemester = currentSemester;
		this.myCmbClasses.removeAllItems();
		for (Class c : this.myCurrentSemester.getClasses()) {
			this.myCmbClasses.addItem(c.getTitle());
		}
		this.revalidate();
	}
	
	private void updateCmbCategory(int index){
		if(index >= 0){
		this.myCmbCategory.removeAllItems();
		for (Category c : this.myCurrentSemester.getClass(index).getCategories()) {
			this.myCmbCategory.addItem(c.getTitle());
		}
		this.revalidate();
		}
	}

	private void setup() {
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		myCmbClasses = new JComboBox<String>(new String[] { "Classes..." });
		myCmbCategory = new JComboBox(new String[] { "Categories..." });
		myCmdAdd = new JButton("Add");
		myTxtScore = new JTextField("10");
		myTxtPoints = new JTextField("10");
		myLblGrade = new JLabel("Current grade: N/A");
		myTxtTitle = new JTextField("Assn. Title...");

		this.setFonts(myFont);

		c.insets = new Insets(10, 10, 10, 10);
		c.gridwidth = 3;
		add(myLblGrade,c);
		
		c.gridwidth = 2;
		c.gridy =1;
		myCmbClasses.setPreferredSize(new Dimension(300, 30));

		add(myCmbClasses, c);

		c.gridy = 2;
		myCmbCategory.setPreferredSize(new Dimension(300, 30));

		add(myCmbCategory, c);

		c.gridy = 3;
		c.gridwidth = 1;
		myTxtScore.setPreferredSize(new Dimension(125, 30));
		add(myTxtScore, c);

		c.gridx = 1;
		c.anchor =GridBagConstraints.EAST;
		myTxtPoints.setPreferredSize(new Dimension(125, 30));

		add(myTxtPoints, c);
	

		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 2;
		myTxtTitle.setPreferredSize(new Dimension(300,30));

		add(myTxtTitle,c);
		
		c.gridy = 5;
		c.anchor =GridBagConstraints.CENTER;
		myCmdAdd.setPreferredSize(new Dimension(200, 50));

		add(myCmdAdd, c);

	}
	
	private void updateGradeLabel(int index){
		if(index > -1){
		myLblGrade.setText("Current Grade: " + String.format("%.2f%%",myCurrentSemester.getClass(index).calculateGrade()));
		}
	}
	
	public void setFonts(Font font){
		myCmbClasses.setFont(font);
		myCmbCategory.setFont(font);
		myTxtPoints.setFont(font);
		myTxtScore.setFont(font);
		myCmdAdd.setFont(font);
		myLblGrade.setFont(font);
		myTxtTitle.setFont(font);
	}

}
