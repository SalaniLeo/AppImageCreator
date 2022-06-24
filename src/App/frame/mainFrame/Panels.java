package App.frame.mainFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import App.settings.Borders;
import App.settings.theme.Theme;
import App.elements.confirmButton;
import App.elements.advancedOptions.*;
import App.elements.options.SetAppCategories;
import App.elements.options.setAppExe;
import App.elements.options.setAppIcon;
import App.elements.options.setAppName;
import App.elements.options.OptionsPanel;

public class Panels{
	
	public static JPanel topPanel;
	public static JPanel leftPanel;
	public static JPanel centerPanel;
	public static JPanel infoPanel;
	public static JPanel thingsPanel;

	private FlowLayout centerPanelLayout; 
	public static 	JPanel southThingPanel = new JPanel();
	private ShowAdvancedOptions ShowAdvancedOptions = new ShowAdvancedOptions();
	public static JPanel centerThingsPanel = new JPanel();
	SetAppCategories SetAppCategories = new SetAppCategories();
	confirmButton confirm = new confirmButton();
	
	
	@SuppressWarnings("static-access")
	public Component centerPanel() {
		
		this.centerPanelLayout = new FlowLayout();
		Panels.infoPanel = new JPanel(); 
		Panels.thingsPanel = new JPanel();
        this.centerPanelLayout.setHgap(10);
        this.centerPanelLayout.setAlignment(FlowLayout.LEFT);
		Panels.centerPanel = new JPanel();
		
	    centerPanel.setVisible(true);
		centerPanel.setPreferredSize(new Dimension(80,40));
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBorder(Borders.leftTopBorder);
		
		centerPanel.add(infoPanel, BorderLayout.NORTH);
		centerPanel.add(thingsPanel);	
		
		//Adds components to central panel
		
		thingsPanel.setLayout(new BorderLayout());
		thingsPanel.setBackground(Theme.SecondaryColor);
	
		southThingPanel.setVisible(true);
		southThingPanel.setBackground(Theme.MainColor);
	    southThingPanel.setPreferredSize(new Dimension(30,30));
		southThingPanel.setLayout(null);
		southThingPanel.add(ShowAdvancedOptions);
		southThingPanel.add(ShowAdvancedOptions.textArea);
	
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());	
		panel.add(confirm.panel, BorderLayout.SOUTH);
		panel.setBackground(Theme.SecondaryColor);
		panel.setPreferredSize(new Dimension(80,80));
		
		thingsPanel.add(panel, BorderLayout.EAST);
		thingsPanel.add(southThingPanel, BorderLayout.SOUTH);
		new OptionsPanel();
		thingsPanel.add(OptionsPanel.JPanel, BorderLayout.CENTER);
		
		   infoPanel.setBorder(Borders.downBorder);
		infoPanel.setBackground(Theme.SecondaryColor);
		infoPanel.setLayout(null);
		infoPanel.setPreferredSize(new Dimension(170,140));
		@SuppressWarnings("unused")
		setAppName setAppName = new setAppName();
		setAppIcon setAppIcon = new setAppIcon();
		new setAppExe();
	    infoPanel.add(setAppExe.directory);	
	    infoPanel.add(setAppExe.label);
	    infoPanel.add(setAppExe.exeSelector);
		infoPanel.add(App.elements.options.setAppName.label);
		infoPanel.add(App.elements.options.setAppName.nameSelector);
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
