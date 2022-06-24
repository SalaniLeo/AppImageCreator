package App.frame.mainFrame;

import java.awt.Dimension;

import javax.swing.JPanel;

import App.elements.advancedOptions.setCustomRunner;
import App.elements.advancedOptions.setSystemIntegration;
import App.settings.theme.Theme;

public class AdvancedOptionsPanel{

	
	setCustomRunner setCustomRunner = new setCustomRunner();
	setSystemIntegration setSystemIntegration = new setSystemIntegration();
	public static JPanel jPanel = new JPanel();

	public AdvancedOptionsPanel() {
		
		jPanel.setVisible(true);
		jPanel.setPreferredSize(new Dimension(100,100));
		jPanel.setLayout(null);
		jPanel.setBackground(Theme.SecondaryColor);
		jPanel.add(setCustomRunner);
		jPanel.add(setCustomRunner.textArea);
		jPanel.add(setSystemIntegration);
		jPanel.add(setSystemIntegration.textArea);
	
	}

}
