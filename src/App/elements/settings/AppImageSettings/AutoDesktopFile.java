package App.elements.settings.AppImageSettings;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import App.elements.switchButton;
import App.loader.SettingsLoader;

public class AutoDesktopFile {
	
	static int endLocation;
    public static boolean selected = false;
	public JLabel text = new JLabel();
    public static switchButton sb = new switchButton();
	
    public AutoDesktopFile() {
    	
    	this.text.setText("Auto desktop shortcut:");
    	text.setFont(new Font(null,Font.PLAIN, 14));
    	this.text.setBounds(10,90,270,20);
    	this.text.setVisible(true);
    	this.text.setForeground(Color.white);
    	
    	if(SettingsLoader.desktopFileMode == true) {
    		
    		sb.setSelected(true);
    		
    	}
    	
        sb.setBounds(180,90,42,23);

    }
   

    
}