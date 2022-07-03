package App.elements.settings.AppImageSettings;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import App.elements.switchButton;
import App.loader.SettingsLoader;


public class RemoveAppDir {

	public JLabel text = new JLabel();
    public static switchButton sb = new switchButton();
	
    public RemoveAppDir() {
    	
    	text.setText("Remove AppDir folders:");
    	text.setBounds(10,210,170,20);
    	text.setVisible(true);
    	text.setForeground(Color.white);
    	text.setFont(new Font(null,Font.PLAIN, 14));
    	
    	if(SettingsLoader.removeAppDirs == true) {
    		sb.setSelected(true);
    		
    	}
    	
        sb.setBounds(180,210,42,23);

    }
   

    
}