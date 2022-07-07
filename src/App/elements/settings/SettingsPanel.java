package App.elements.settings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import App.settings.Borders;
import App.settings.theme.Theme;
import App.elements.settings.AppImageSettings.DefaultAppLocation;
import App.elements.settings.AppImageSettings.AutoEnableFolderMode;
import App.elements.settings.AppImageSettings.AutoIntegrateInSystem;
import App.elements.settings.AppImageSettings.backButton;
import App.elements.settings.AppImageSettings.RemoveAppDir;
import App.elements.settings.AppSettings.CreateCreatorDShortcut;
import App.elements.settings.AppSettings.CreateCreatorLShortcut;
import App.elements.settings.AppImageSettings.AutoDesktopFile;
import App.frame.sharedPanels.backPanel;
import App.frame.sharedPanels.leftPanel;
import App.elements.settings.AppImageSettings.AppLeanguage;

public class SettingsPanel{
	
	public static JPanel AppSeparatorPanel;
	public static JPanel CreatorSeparatorPanel;
	
	public static leftPanel leftPanel = new leftPanel();
	
	CreateCreatorLShortcut CreateCreatorLShortcut = new CreateCreatorLShortcut();
	backButton backButton = new backButton();
	AutoEnableFolderMode AutoEnableFolderMode = new AutoEnableFolderMode();
	public JPanel settingsPanel = new JPanel();
	static JPanel mainPanel = new JPanel();
	AutoIntegrateInSystem AutoIntegrateInSystem = new AutoIntegrateInSystem();
	static backPanel backPanel = new backPanel();
	AutoDesktopFile AutoDesktopFile = new AutoDesktopFile();
	DefaultAppLocation DefaultAppLocation = new DefaultAppLocation();
	RemoveAppDir RemoveAppDir = new RemoveAppDir();
	CreateCreatorDShortcut CreateCreatorDShortcut = new CreateCreatorDShortcut();
    AppLeanguage AppLeanguage = new AppLeanguage();
 
	@SuppressWarnings("static-access")
	public SettingsPanel() {
		
		AppSeparatorPanel();
		CreatorSeparatorPanel();
		
		settingsPanel.setLayout(new BorderLayout());
		settingsPanel.setOpaque(true);
		settingsPanel.setVisible(true);
		settingsPanel.setBackground(Color.DARK_GRAY);
		settingsPanel.add(leftPanel, BorderLayout.WEST);
		settingsPanel.add(backPanel, BorderLayout.NORTH);
		settingsPanel.add(mainPanel, BorderLayout.CENTER);
		
		mainPanel.setBackground(Theme.SecondaryColor);
		mainPanel.setLayout(null);
		mainPanel.setBorder(Borders.leftTopBorder);
		mainPanel.add(AutoEnableFolderMode.sb);
		mainPanel.add(AutoEnableFolderMode.text);
		mainPanel.add(AutoIntegrateInSystem.text);
		mainPanel.add(AutoIntegrateInSystem.sb);
		mainPanel.add(AutoDesktopFile.sb);
		mainPanel.add(AutoDesktopFile.text);
		mainPanel.add(DefaultAppLocation.Location);
		mainPanel.add(DefaultAppLocation.LocationSelector);
		mainPanel.add(DefaultAppLocation.Browse);
		mainPanel.add(RemoveAppDir.text);
		mainPanel.add(RemoveAppDir.sb);
		mainPanel.add(CreateCreatorDShortcut.CreateDesktopShortcut());
		mainPanel.add(CreateCreatorLShortcut.sb);
		mainPanel.add(CreateCreatorLShortcut.text);
 	}
		
	public void AppSeparatorPanel() {
		JLabel l = new JLabel();
		
		l.setForeground(Theme.textColor);
		l.setText("App options");
		l.setVisible(true);
		l.setBounds(0,0,300,20);
		l.setFont(new Font(null,Font.BOLD,20));
		
		AppSeparatorPanel = new JPanel();
		AppSeparatorPanel.setBounds(10,260,300,30);
		AppSeparatorPanel.setBackground(Theme.SecondaryColor);
		AppSeparatorPanel.setVisible(true);
		AppSeparatorPanel.setBorder(Borders.BoldBorder);
		AppSeparatorPanel.setLayout(null);
		AppSeparatorPanel.add(l);
		
		mainPanel.add(AppSeparatorPanel);
		

	}
	
	public void CreatorSeparatorPanel() {
		JLabel l = new JLabel();
		
		l.setForeground(Theme.textColor);
		l.setText("Creator options");
		l.setVisible(true);
		l.setBounds(0,0,300,20);
		l.setFont(new Font(null,Font.BOLD,20));
		
		CreatorSeparatorPanel = new JPanel();
		CreatorSeparatorPanel.setBounds(10,10,300,30);
		CreatorSeparatorPanel.setBackground(Theme.SecondaryColor);
		CreatorSeparatorPanel.setVisible(true);
		CreatorSeparatorPanel.setBorder(Borders.BoldBorder);
		CreatorSeparatorPanel.setLayout(null);
		CreatorSeparatorPanel.add(l);
		
		mainPanel.add(CreatorSeparatorPanel);
		

	}
		
}