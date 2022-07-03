package App.elements.settings.AppImageSettings;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import App.elements.switchButton;
import App.loader.SettingsLoader;

public class AutoEnableFolderMode {
	
	public String IsGloballyAvailable;
	public JLabel text = new JLabel();
    public static switchButton sb = new switchButton();
	
    public AutoEnableFolderMode() {
    	
    	this.text.setText("Auto folder mode:");
    	this.text.setBounds(10,50,270,20);
    	this.text.setVisible(true);
    	text.setFont(new Font(null,Font.PLAIN, 14));
    	this.text.setForeground(Color.white);

    	if(SettingsLoader.folderMode == true) {
    		sb.setSelected(true);
    	}
    	
        sb.setBounds(145,50,42,23);

    }
   

    
}