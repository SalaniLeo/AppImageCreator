package App.elements.options;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import App.elements.switchButton;
import App.loader.SettingsLoader;
import App.settings.theme.Fonts;

public class setLauncherShortcut {
	
	public String buttonOn;
	public JLabel textArea = new JLabel();
	public static int isOn;
	public static switchButton sb = new switchButton();
	
    public setLauncherShortcut() {
    	
    	textArea = new JLabel();
    	
    	textArea.setText("Create launcher shortcut:");
    	textArea.setBounds(10,50,300,20);
    	textArea.setVisible(true);
    	textArea.setForeground(Color.white);
    	textArea.setFont(Fonts.mainFont);
    	
    	if(SettingsLoader.integrateMode == true) {
    		sb.setSelected(true);
    	}
    	
    	sb.setBounds(195,50,42,23);
    }
}