package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{
	
	private JMenu menu;
	private JMenuItem menuItem;
	
	public MenuBar(){
		super();
		menu = new JMenu("A menu");
		add(menu);
		menuItem = new JMenuItem("A text-only item",new ImageIcon("plusIcon.ico"));
		menu.add(menuItem);
		
		
	}
	
}
