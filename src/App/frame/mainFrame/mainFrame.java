package App.frame.mainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import App.Settings;
import App.elements.settings.SettingsPanel;
import App.frame.AppImagePanel;
import App.frame.sharedPanels.leftPanel;
import App.settings.Console;

@SuppressWarnings("serial")
public class mainFrame extends JFrame{

	public static JPanel frame;
	public static JPanel mainPanel = new JPanel();
	public static int windowState = 0;
	private JPanel mainAppPanel = new JPanel();
	private Panels Panels = new Panels();
	leftPanel leftPanel = new leftPanel();
	static SettingsPanel SettingsPanel = new SettingsPanel(); 
	App.imageCreator.AppLocation AppLocation = new App.imageCreator.AppLocation();
	static AppImagePanel AppImagePanel = new AppImagePanel();
	 ImageIcon icon = new ImageIcon(getClass().getResource("/Images/icon.png"));
	 Settings Settings = new Settings();
	 
	 public Component displayFrame() {

		 frame = new JPanel();

		 System.out.println("frame");
		 
		 this.setTitle("AppImage Creator");
		 this.setVisible(true);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setMinimumSize(new Dimension(400,300));
		 this.setSize(900,500);
		 this.setResizable(true);
		 this.add(frame);
		 this.setLocationRelativeTo(null);
		 this.setIconImage(icon.getImage());
		 this.addWindowListener(new WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                     if(mainFrame.windowState == 1) {
                    	 
                    	 try {
                    		 Settings.saveSettings();
						} catch (Exception e) {
							System.out.println(Console.error + "Could not save settings");
						}
                    	 
                     }
			    }
			});
		 
		 frame.setVisible(true);
		 frame.setLayout(new BorderLayout());
		 frame.add(mainPanel, BorderLayout.CENTER);
		 
		 mainPanel.setBackground(Color.DARK_GRAY);
		 mainPanel.setLayout(new BorderLayout());
		 mainPanel.add(Panels.centerPanel(), BorderLayout.CENTER);
		 mainPanel.add(leftPanel, BorderLayout.WEST);
		 mainPanel.add(Panels.topPanel(), BorderLayout.NORTH);
		return this;
	      
	 }
	 
	 
		public static void settingsWindow() {
	    	if(windowState == 2) {
		    	mainFrame.frame.remove(App.frame.AppImagePanel.AppImagePanel);
		    	windowState = 3;
	    	} else {
	    	windowState = 1;
	    	}
	    	mainFrame.frame.remove(mainFrame.mainPanel);
	    	mainFrame.frame.add(SettingsPanel.settingsPanel, BorderLayout.CENTER);
	    	mainFrame.frame.updateUI();
	    }
	    
	    public static void mainWindow() {
	    	if(windowState == 1) {
		    	mainFrame.frame.remove(SettingsPanel.settingsPanel);
	    	} else {
	    		
	     		if(windowState == 2) {
	    			
	    			mainFrame.frame.remove(App.frame.AppImagePanel.AppImagePanel);
	    			
	    		}
	    		
	    	}
	    	windowState = 0;
	    	mainFrame.frame.add(mainFrame.mainPanel);
	    	mainFrame.frame.updateUI();
	    }
	    
	    @SuppressWarnings("static-access")
		public static void AppImageWindow() {
	    	
	    	if(windowState == 3) {
	    		
	    		mainFrame.frame.remove(SettingsPanel.settingsPanel);
	    		
	    	}
	    	
	    	windowState = 2;
	    	mainFrame.frame.remove(mainFrame.mainPanel);
	    	mainFrame.frame.add(App.frame.AppImagePanel.AppImagePanel);
	    	AppImagePanel.AddElements();
	    	mainFrame.frame.updateUI();
	    }
}

	 
	 
