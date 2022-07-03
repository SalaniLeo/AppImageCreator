package App.elements.settings.AppSettings;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;

import App.elements.switchButton;
import App.loader.SettingsLoader;

public class CreateCreatorLShortcut {
	
	public static File LShortcut = new File(System.getProperty("user.home") + "/.local/share/applications/" + "AppImage-Creator.desktop");
	public String IsGloballyAvailable;
	public JLabel text = new JLabel();
    public static LSButton sb = new LSButton();
	
    public CreateCreatorLShortcut() {
    	
    	this.text.setText("Add app launcher shortcut:");
    	this.text.setBounds(10,340,270,20);
    	this.text.setVisible(true);
    	text.setFont(new Font(null,Font.PLAIN, 14));
    	this.text.setForeground(Color.white);

    	if(SettingsLoader.launcherShorcut == true) {
    		if(LShortcut.exists()) {
    		sb.setSelected(true);
    		}
        }
    	
        sb.setBounds(205,340,42,23);
        
        if(sb.isSelected()) {
        	
        }

    }
    
    public static void createLShortcut() throws IOException {
    	
    BufferedWriter writer = new BufferedWriter(new FileWriter(LShortcut));
    		writer.write("[Desktop Entry]");
    		writer.newLine();
    		writer.write("Name=" + "AppImage Creator");
    		writer.newLine();
    		//TODO move the icon to .local/share/appimgae-creator/
    		writer.write("Icon=" + "");
    		writer.newLine();
    		writer.write("Exec=" + "");
    		writer.newLine();
    		writer.write("Type=" + "Application");
    		writer.newLine();
    		writer.write("Categories=" + "Utility");
    		writer.close();

    		}
    
    
    public static void removeLShortcut() {
 
    		 LShortcut.delete();
    	 
    }
   

    
}