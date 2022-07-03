package App.frame.mainFrame;

import java.awt.Dimension;

import javax.swing.JPanel;

import App.elements.advancedOptions.setFolderMode;
import App.elements.advancedOptions.setCustomRunner;
import App.elements.options.setLauncherShortcut;
import App.settings.theme.Theme;

public class AdvancedOptionsPanel{

	
	setCustomRunner setCustomRunner = new setCustomRunner();
	setLauncherShortcut setLauncherShortcut = new setLauncherShortcut();
	public static JPanel jPanel = new JPanel();
	setFolderMode setFolderMode = new setFolderMode();

	@SuppressWarnings("static-access")
	public AdvancedOptionsPanel() {
		
		jPanel.setVisible(true);
		jPanel.setPreferredSize(new Dimension(100,100));
		jPanel.setLayout(null);
		jPanel.setBackground(Theme.SecondaryColor);
		jPanel.add(setCustomRunner.sb);
		jPanel.add(setCustomRunner.textArea);
		jPanel.add(setFolderMode.folderMode);
	
	}

}
