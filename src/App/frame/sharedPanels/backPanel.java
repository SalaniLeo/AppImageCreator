package App.frame.sharedPanels;

import java.awt.Dimension;

import javax.swing.JPanel;

import App.elements.settings.AppImageSettings.backButton;
import App.settings.theme.Theme;

public class backPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	backButton backButton = new backButton();
	
	public backPanel(){

		this.setPreferredSize(new Dimension(40,40));
		this.setVisible(true);
		this.setBackground(Theme.MainColor);
		this.setLayout(null);
		this.add(backButton.jLabel1);
		
	}
	
}
