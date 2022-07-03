package App.elements.settings.AppSettings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import App.frame.mainFrame.mainFrame;
import App.imageCreator.waitingWindow.WaitingWindow;
import App.loader.SettingsLoader;
import App.settings.theme.Theme;

public class CreateCreatorDShortcut {
	
 public static File DShortcut = new File(System.getProperty("user.home") + "/Desktop", "AppImage Creator" + ".desktop");
	public String IsGloballyAvailable;
	JLabel text = new JLabel();
    public static DSButton sb = new DSButton();
	public JPanel CreateDShortcut;
	
	//warning window elements
	private JFrame frame = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JDialog warningWindow = new JDialog(frame,"warning");
	//warning window elements
    
    public Component CreateDesktopShortcut() {
    	
    	CreateDShortcut = new JPanel();
    	
    	text.setText("Add app desktop shortcut:");
    	text.setBounds(0,0,270,20);
    	text.setVisible(true);
    	text.setFont(new Font(null,Font.PLAIN, 14));
    	text.setForeground(Theme.textColor);
    	 
    	if(SettingsLoader.desktopShorcut == true) {
    		if(DShortcut.exists()) {
    		sb.setSelected(true);
    		}
    	}
    	
        sb.setBounds(192,0,42,23);
       
        CreateDShortcut.setBounds(10,300,400,30);
        CreateDShortcut.setBackground(Theme.SecondaryColor);
        CreateDShortcut.setLayout(null);
        CreateDShortcut.add(sb);
        CreateDShortcut.add(text);
        
        return CreateDShortcut;
    }
    
    public void createDShortcut() throws IOException {
    	
    BufferedWriter writer = new BufferedWriter(new FileWriter(DShortcut));
    				
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
    
    
    public void removeDShortcut() {
 
    	 if(DShortcut.exists()) {
    		 DShortcut.delete();
    	 }
    }
    
    public Component warningWindow() {
    	
    	
    	
    	frame.setLocationRelativeTo(mainFrame.frame);
    	
    	mainPanel.setBackground(Theme.SecondaryColor);
    	mainPanel.setLayout(null);
    	mainPanel.setVisible(true);
    	
    	warningWindow.setSize(300,120);
    	warningWindow.setVisible(true);
    	warningWindow.setLocationRelativeTo(null);
    	warningWindow.add(mainPanel);
    	
    	return warningWindow;
    }
    
}