package App.elements.advancedOptions;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import App.elements.switchButton;
import App.settings.theme.Fonts;

public class setCustomRunner {

	public JLabel textArea = new JLabel();
	public static switchButton sb = new switchButton();
	
    public setCustomRunner() {
    	
    	textArea = new JLabel();
    	
    	textArea.setText("Set Custom Runfile:");
    	textArea.setBounds(10,50,300,20);
    	textArea.setVisible(true);
    	textArea.setForeground(Color.white);
    	textArea.setFont(Fonts.mainFont);
    	
        sb.setBounds(160,50,42,23);
   
    }
    
}