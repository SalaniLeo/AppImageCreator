package App.elements.options;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import App.elements.settings.AppImageSettings.AppLeanguage;
import App.settings.theme.Theme;


public class OptionsPanel{
	
	setAppShortcut setAppShortcut = new setAppShortcut();
	setAppType setAppType = new setAppType();
	SetAppCategories SetAppCategories = new SetAppCategories();
	public static JPanel mainPanel = new JPanel();
	public static JPanel JPanel = new JPanel();
	AppLeanguage AppLeanguage = new AppLeanguage();
	setLauncherShortcut setLauncherShortcut = new setLauncherShortcut();
	
	@SuppressWarnings("static-access")
	public OptionsPanel(){
		
		JPanel.setVisible(true);
		JPanel.setLayout(new BorderLayout());
		JPanel.setBackground(Theme.SecondaryColor);
		JPanel.setPreferredSize(new Dimension(1000,1000));
		JPanel.add(mainPanel, BorderLayout.WEST);
	    
	    mainPanel.setVisible(true);
	    mainPanel.setLayout(new GroupLayout(mainPanel));
	    mainPanel.setPreferredSize(new Dimension(300,300));
	    mainPanel.setBackground(Theme.SecondaryColor);  
	    mainPanel.add(setAppShortcut.sb);
		mainPanel.add(setAppShortcut.askShortcut);
		mainPanel.add(setLauncherShortcut.textArea);
		mainPanel.add(setLauncherShortcut.sb);
		mainPanel.add(setAppType.type);
		mainPanel.add(setAppType.typeSelector);
		mainPanel.add(SetAppCategories);
//		mainPanel.add(AppLeanguage.cb);
	}
	
	
}
