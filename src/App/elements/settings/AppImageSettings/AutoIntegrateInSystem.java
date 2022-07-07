package App.elements.settings.AppImageSettings;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import App.Settings;
import App.elements.switchButton;

public class AutoIntegrateInSystem {

	public String IsGloballyAvailable;
	public JLabel text = new JLabel();
    public static switchButton sb = new switchButton();
    
    public AutoIntegrateInSystem() {
    	
    	text.setText("Auto launcher shortcut:");
    	text.setBounds(10,130,190,20);
    	text.setVisible(true);
    	text.setForeground(Color.white);
    	text.setFont(new Font(null,Font.PLAIN, 14));
    	
    	if(Settings.integrateMode == true) {
    		sb.setSelected(true);
    	}
    	
        sb.setBounds(185,130,42,23);
        
    }
   

    
}