package App.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import App.elements.AppImageConfiguration.folderMode.folderModePanel;
import App.elements.AppImageConfiguration.folderMode.setParentDirectory;
import App.elements.advancedOptions.setCustomRunner;
import App.elements.options.selectCustomAppRun;
import App.imageCreator.AppLocation;
import App.imageCreator.confirmButton;
import App.settings.Borders;
import App.settings.theme.Theme;
import App.frame.sharedPanels.*;

public class AppImagePanel{

	public static JPanel AppImagePanel = new JPanel();
	public JPanel AppImageCenterPanel = new JPanel();
	public static JPanel AppImageBottomPanel = new JPanel();
	public static backPanel backPanel = new backPanel();
	leftPanel leftPanel = new leftPanel();
	 static JPanel panel = new JPanel();

	public AppImagePanel() {

		 AppImagePanel.setVisible(true);
		 AppImagePanel.setLayout(new BorderLayout());
		 AppImagePanel.setBackground(Color.DARK_GRAY);
         AppImagePanel.add(backPanel, BorderLayout.NORTH);
         AppImagePanel.add(AppImageCenterPanel, BorderLayout.CENTER);
		 AppImagePanel.add(leftPanel, BorderLayout.WEST);
		 
		 AppImageCenterPanel.setLayout(new BorderLayout());
		 AppImageCenterPanel.setVisible(true);
		 AppImageCenterPanel.add(leftPanel, BorderLayout.WEST);
		 AppImageCenterPanel.add(panel, BorderLayout.CENTER);
		 AppImageCenterPanel.add(AppImageBottomPanel, BorderLayout.EAST);
		 
         FlowLayout layout1 = new FlowLayout();	
      JPanel buttonPanel = new JPanel();
layout1.setAlignment(FlowLayout.CENTER);

AppImageBottomPanel.setVisible(true);
AppImageBottomPanel.setLayout(new BorderLayout());
AppImageBottomPanel.setPreferredSize(new Dimension(100,100));
AppImageBottomPanel.setBackground(Theme.SecondaryColor);
AppImageBottomPanel.add(buttonPanel, BorderLayout.SOUTH); 

new confirmButton();
buttonPanel.add(confirmButton.jLabel1);
buttonPanel.setLayout(layout1);
buttonPanel.setVisible(true);
buttonPanel.setBackground(Theme.SecondaryColor);
buttonPanel.setPreferredSize(new Dimension(80,60));

		 panel.setLayout(null);
		 panel.setVisible(true);
		 panel.setBorder(Borders.leftTopBorder);
		 panel.setBackground(Theme.SecondaryColor);
		 panel.add(AppLocation.LocationPanel);		 
				 
	}
	
	public static void AddElements(){
		 if(setCustomRunner.IsOn == 1) {
			 new selectCustomAppRun();
			 panel.add(selectCustomAppRun.customAppRun);
	 		 }
		 if(folderModePanel.IsOn == 1) {
			 panel.add(setParentDirectory.ParentDir); 
			 }
	}
	
}
