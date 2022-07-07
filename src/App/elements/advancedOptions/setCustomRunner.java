package App.elements.advancedOptions;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import App.elements.switchButton;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;

public class setCustomRunner {

	public JLabel textArea = new JLabel();
	public static switchButton sb = new switchButton();
	JPanel panel;
	
    public Component CustomRunnerPanel() {
    	
    	textArea = new JLabel();
    	panel = new JPanel();
    	
    	panel.add(textArea);
    	panel.add(sb);
    	panel.setBackground(Theme.SecondaryColor);
    	panel.setVisible(true);
    	panel.setLayout(null);
    	panel.setBounds(0,30,240,30);
    	
    	textArea.setText("Set Custom Runfile:");
    	textArea.setBounds(0,0,150,20);
    	textArea.setVisible(true);
    	textArea.setForeground(Color.white);
    	textArea.setFont(Fonts.mainFont);
    	
        sb.setBounds(145,0,42,23);
   
        return panel;
    }
    
}