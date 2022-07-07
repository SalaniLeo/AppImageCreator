package App.elements.options;

import java.awt.Dimension;
import javax.swing.JPanel;

import App.elements.settings.AppImageSettings.AppLeanguage;
import App.settings.theme.Theme;


public class optionsPanel{
	
	setAppShortcut setAppShortcut = new setAppShortcut();
	setAppType setAppType = new setAppType();
	SetAppCategories SetAppCategories = new SetAppCategories();
	public static JPanel JPanel = new JPanel();
	AppLeanguage AppLeanguage = new AppLeanguage();
	setLauncherShortcut setLauncherShortcut = new setLauncherShortcut();
	
	public optionsPanel(){
	    
		JPanel.setVisible(true);
		JPanel.setLayout(null);
		JPanel.setPreferredSize(new Dimension(300,300));
		JPanel.setBackground(Theme.SecondaryColor);  
		
		JPanel.add(setAppShortcut.AppShortcutPanel());
		JPanel.add(setLauncherShortcut.launcherShortcutPanel());
		JPanel.add(setAppType.typePanel());
		JPanel.add(SetAppCategories.categoriesPanel());
	}
	
	
}
