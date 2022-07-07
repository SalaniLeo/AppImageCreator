package App.frame.sharedPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import App.elements.settings.SettingsButton;
import App.settings.theme.Theme;

public class leftPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public leftPanel() {
		
		Component SettingsButton = new SettingsButton();
		FlowLayout layout = new FlowLayout();
		layout.setVgap(100);
				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setPreferredSize(new Dimension(65,65));
				panel.add(SettingsButton);
				panel.setBackground(Theme.MainColor);
				
			    this.setVisible(true);
			    this.setBackground(Theme.MainColor);
			    this.setLayout(new BorderLayout());
			    this.add(panel, BorderLayout.SOUTH);
			    this.setOpaque(true);
				this.setPreferredSize(new Dimension(80,40));
		
	}
	
}
