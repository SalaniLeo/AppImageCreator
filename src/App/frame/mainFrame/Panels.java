package App.frame.mainFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

import App.settings.Borders;
import App.settings.theme.Theme;
import App.elements.confirmButton;
import App.elements.advancedOptions.*;
import App.elements.options.SetAppCategories;
import App.elements.options.optionsPanel;
import App.elements.options.setAppExe;
import App.elements.options.setAppIcon;
import App.elements.options.setAppName;

public class Panels{
	
	public static JPanel topPanel;
	public static JPanel leftPanel;
	public static JPanel centerPanel;
	public static JPanel infoPanel;
	public static JPanel thingsPanel;

	private setAppName setAppName = new setAppName();
	private setAppIcon setAppIcon = new setAppIcon();
	private setAppExe setAppExe = new setAppExe();
	JPanel confirmPanel = new JPanel();
	private optionsPanel optionsPanel =	new optionsPanel();
	public static JPanel southThingPanel = new JPanel();
	private ShowAdvancedOptions ShowAdvancedOptions = new ShowAdvancedOptions();
	public static JPanel centerThingsPanel = new JPanel();
	SetAppCategories SetAppCategories = new SetAppCategories();
	confirmButton confirm = new confirmButton();
	
	
	@SuppressWarnings("static-access")
	public Component centerPanel() {
		
		infoPanel = new JPanel(); 
		thingsPanel = new JPanel();
		centerPanel = new JPanel();
		
	    centerPanel.setVisible(true);
		centerPanel.setPreferredSize(new Dimension(80,40));
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBorder(Borders.leftTopBorder);
		
		centerPanel.add(infoPanel, BorderLayout.NORTH);
		centerPanel.add(thingsPanel);	
		
		//Adds components to central panel
		
		thingsPanel.setLayout(new BorderLayout());
		thingsPanel.setBackground(Theme.SecondaryColor);
		thingsPanel.add(confirmPanel, BorderLayout.EAST);
		thingsPanel.add(southThingPanel, BorderLayout.SOUTH);
		thingsPanel.add(optionsPanel.JPanel, BorderLayout.CENTER);
	
		southThingPanel.setVisible(true);
		southThingPanel.setBackground(Theme.MainColor);
	    southThingPanel.setPreferredSize(new Dimension(30,30));
		southThingPanel.setLayout(null);
		southThingPanel.add(ShowAdvancedOptions);
		southThingPanel.add(ShowAdvancedOptions.textArea);
	
		confirmPanel.setLayout(new BorderLayout());	
		confirmPanel.add(confirm.panel, BorderLayout.SOUTH);
		confirmPanel.setBackground(Theme.SecondaryColor);
		confirmPanel.setPreferredSize(new Dimension(80,80));
		
	    infoPanel.setBorder(Borders.downBorder);
		infoPanel.setBackground(Theme.SecondaryColor);
		infoPanel.setLayout(null);
		infoPanel.setPreferredSize(new Dimension(170,140));
	    infoPanel.add(setAppExe.directory);	
	    infoPanel.add(setAppExe.label);
	    infoPanel.add(setAppExe.exeSelector);
		infoPanel.add(setAppName.label);
		infoPanel.add(setAppName.nameSelector);
		infoPanel.add(setAppIcon.IconText);
		infoPanel.add(setAppIcon.IconSelector);
		infoPanel.add(setAppIcon.iconDir);
		
	 	return centerPanel;
		
	}
	
	public Component topPanel() {

		topPanel = new JPanel();
		
		topPanel.setVisible(true);
		topPanel.setPreferredSize(new Dimension(50,40));
	    topPanel.setBackground(Theme.MainColor);
	    
		return topPanel;
		
	}
	
}
