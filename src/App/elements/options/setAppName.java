package App.elements.options;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import App.settings.Borders;
import App.settings.theme.Theme;

public class setAppName extends JTextField{
	
	private static final long serialVersionUID = 1L;
	public static JTextField nameSelector;
	public static String name;
	public static JLabel label;
	
	public setAppName(){
		
		
		setAppName.name = new String();
		setAppName.label = new JLabel();
		nameSelector = new JTextField();
		
		nameSelector.setBounds(90,50,340,20);
		nameSelector.setVisible(true);
		nameSelector.setPreferredSize(new Dimension(300,20));
		nameSelector.setBorder(Borders.downBorder);
		nameSelector.setOpaque(false);
		nameSelector.setBackground(Theme.SecondaryColor);
		nameSelector.setForeground(Theme.textColor);
		
		setAppName.label.setVisible(true);
		setAppName.label.setBounds(10,50,70,20);
		setAppName.label.setBackground(new Color(189, 107, 0));
		setAppName.label.setPreferredSize(new Dimension(50,30));
		setAppName.label.setForeground(Theme.textColor);
		setAppName.label.setText("Name: ");
		
	}
	
}
