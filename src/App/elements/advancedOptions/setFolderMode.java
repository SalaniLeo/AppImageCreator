package App.elements.advancedOptions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import App.elements.switchButton;
import App.loader.SettingsLoader;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;

public class setFolderMode {
	
	public String IsGloballyAvailable;
    public JPanel folderMode = new JPanel();
	public static switchButton sb = new switchButton();
    
    JLabel ask = new JLabel();
    public setFolderMode() {
    	
    	this.ask = new JLabel();
     	
    	ask.setText("Folder mode:");
    	ask.setBounds(10,10,100,20);
    	ask.setVisible(true);
    	ask.setForeground(Color.white);
    	ask.setFont(Fonts.mainFont);
    	
    	
    	folderMode.setVisible(true);
    	folderMode.setBounds(0,0,200,50);
    	folderMode.setBackground(Theme.SecondaryColor);
    	folderMode.setPreferredSize(new Dimension(50,40));
    	folderMode.setOpaque(true);
    	folderMode.setLayout(null);
    	folderMode.add(ask);
    	folderMode.add(sb);
    	
    	if(SettingsLoader.folderMode == true) {
    		
    		sb.setSelected(true);
    		
    	}
    	
    	
        sb.setBounds(110,10,42,23);
    }
}