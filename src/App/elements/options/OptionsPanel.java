package App.elements.options;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import App.elements.AppImageConfiguration.folderMode.folderModePanel;
import App.elements.AppImageConfiguration.folderMode.setParentDirectory;
import App.elements.settings.AppLeanguage;
import App.settings.theme.Theme;


public class OptionsPanel{
	
	setAppShortcut setAppShortcut = new setAppShortcut();
	setAppType setAppType = new setAppType();
	SetAppCategories SetAppCategories = new SetAppCategories();
	folderModePanel folderModePanel = new folderModePanel();
	public static JPanel mainPanel = new JPanel();
	setParentDirectory setParentDirectory = new setParentDirectory();
	public static JPanel JPanel = new JPanel();
	AppLeanguage AppLeanguage = new AppLeanguage();
	
	public OptionsPanel(){
		
		JPanel.setVisible(true);
		JPanel.setLayout(new BorderLayout());
		JPanel.setBackground(Theme.SecondaryColor);
		JPanel.setPreferredSize(new Dimension(1000,1000));
		JPanel.add(folderModePanel.folderMode, BorderLayout.NORTH); 
		JPanel.add(mainPanel, BorderLayout.WEST);
	    
	    mainPanel.setVisible(true);
	    mainPanel.setLayout(new GroupLayout(mainPanel));
	    mainPanel.setPreferredSize(new Dimension(300,300));
	    mainPanel.setBackground(Theme.SecondaryColor);  
	    mainPanel.add(setAppShortcut);
		mainPanel.add(setAppShortcut.askShortcut);
		mainPanel.add(App.elements.options.setAppType.type);
		mainPanel.add(App.elements.options.setAppType.typeSelector);
		mainPanel.add(SetAppCategories);
		mainPanel.add(AppLeanguage.cb);
	}
	
	
}
