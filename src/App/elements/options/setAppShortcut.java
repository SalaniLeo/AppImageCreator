package App.elements.options;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import App.elements.switchButton;
import App.Settings;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;

public class setAppShortcut {
	
	public String IsGloballyAvailable;
    private Timer timer;
    public JPanel panel;
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
	
	
    public Component AppShortcutPanel() {
    	
    	askShortcut = new JLabel();
    	panel = new JPanel();
    	
    	panel.add(askShortcut);
    	panel.add(sb);
    	panel.setLayout(null);
    	panel.setBackground(Theme.SecondaryColor);
    	panel.setBounds(10,10,230,30);
    	
    	askShortcut.setText("Create desktop shortcut:");
    	askShortcut.setBounds(0,0,180,20);
    	askShortcut.setVisible(true);
    	askShortcut.setForeground(Theme.textColor);
    	askShortcut.setFont(Fonts.mainFont);
    	
    	if(Settings.desktopFileMode == true) {
    		
    		sb.setSelected(true);
    		
    	}
    	
    	sb.setBounds(180,0,42,23);
        
    	return panel;
    }
}