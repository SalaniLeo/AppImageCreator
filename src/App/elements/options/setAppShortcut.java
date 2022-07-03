package App.elements.options;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.Timer;

import App.elements.switchButton;
import App.loader.SettingsLoader;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;

public class setAppShortcut {
	
	public String IsGloballyAvailable;
    private Timer timer;
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        timer.start();
    }

    private boolean selected;
	public JLabel askShortcut= new JLabel();
    public static switchButton sb = new switchButton();
	
	
    public setAppShortcut() {
    	
    	askShortcut = new JLabel();
    	
    	askShortcut.setText("Create desktop shortcut:");
    	askShortcut.setBounds(10,10,300,20);
    	askShortcut.setVisible(true);
    	askShortcut.setForeground(Theme.textColor);
    	askShortcut.setFont(Fonts.mainFont);
    	
    	if(SettingsLoader.desktopFileMode == true) {
    		
    		sb.setSelected(true);
    		
    	}
    	
    	sb.setBounds(190,10,42,23);
   
    }
}