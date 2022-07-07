package App.elements.options;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import App.elements.switchButton;
import App.Settings;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;

public class setLauncherShortcut {
	
	public String buttonOn;
	public JLabel textArea = new JLabel();
	public static int isOn;
	public static switchButton sb = new switchButton();
	public JPanel typePanel;
	
    public Component launcherShortcutPanel() {
    	
    	textArea = new JLabel();
    	typePanel = new JPanel();
    	
    	typePanel.setLayout(null);
    	typePanel.add(sb);
    	typePanel.add(textArea);
    	typePanel.setBackground(Theme.SecondaryColor);
    	typePanel.setBounds(10,50,250,30);
    	
    	textArea.setText("Create launcher shortcut:");
    	textArea.setBounds(0,0,300,20);
    	textArea.setVisible(true);
    	textArea.setForeground(Color.white);
    	textArea.setFont(Fonts.mainFont);
    	
    	if(Settings.integrateMode == true) {
    		sb.setSelected(true);
    	}
    	
    	sb.setBounds(195,0,42,23);
    	
    	return typePanel;
    }
}