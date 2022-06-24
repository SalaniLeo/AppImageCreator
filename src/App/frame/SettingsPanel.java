package App.frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import App.elements.settings.AutoEnableFolderMode;
import App.elements.settings.AutoIntegrateInSystem;
import App.elements.settings.AppLeanguage;
import App.elements.settings.AutoDesktopFile;
import App.elements.settings.backButton;
import App.settings.Borders;
import App.settings.theme.Theme;
import App.frame.sharedPanels.backPanel;
import App.frame.sharedPanels.leftPanel;
import App.elements.settings.DefaultAppLocation;
import App.elements.settings.RemoveAppDir;

public class SettingsPanel{
	
	public static leftPanel leftPanel = new leftPanel();
	
	backButton backButton = new backButton();
	AutoEnableFolderMode AutoEnableFolderMode = new AutoEnableFolderMode();
	public JPanel settingsPanel = new JPanel();
	static JPanel mainPanel = new JPanel();
	AutoIntegrateInSystem AutoIntegrateInSystem = new AutoIntegrateInSystem();
	static backPanel backPanel = new backPanel();
	AutoDesktopFile AutoDesktopFile = new AutoDesktopFile();
	DefaultAppLocation DefaultAppLocation = new DefaultAppLocation();
	RemoveAppDir RemoveAppDir = new RemoveAppDir();
    AppLeanguage AppLeanguage = new AppLeanguage();

	@SuppressWarnings("static-access")
	public SettingsPanel() {
		
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
		mainPanel.add(AutoEnableFolderMode);
		mainPanel.add(AutoEnableFolderMode.text);
		mainPanel.add(AutoIntegrateInSystem.text);
		mainPanel.add(AutoIntegrateInSystem);
		mainPanel.add(AutoDesktopFile);
		mainPanel.add(AutoDesktopFile.text);
		mainPanel.add(DefaultAppLocation.Location);
		mainPanel.add(DefaultAppLocation.LocationSelector);
		mainPanel.add(DefaultAppLocation.Browse);
		mainPanel.add(RemoveAppDir.text);
		mainPanel.add(RemoveAppDir);
//		mainPanel.add(AppLeanguage.jComboBox1);
		
 	}
		
		
}