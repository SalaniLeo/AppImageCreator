package App.elements.options;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import App.settings.Borders;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;

public class setAppType extends JTextField{
	
	private static final long serialVersionUID = 1L;
	public static JTextField typeSelector;
	public static JLabel type;

	public setAppType(){
		
		
		type = new JLabel();
		typeSelector = new JTextField();
		
		typeSelector.setBounds(70,90,210,20);
		typeSelector.setVisible(true);
	    typeSelector.setBorder(Borders.downBorder);
	    typeSelector.setBackground(Theme.SecondaryColor);
		typeSelector.setForeground(Theme.textColor);
		
		type.setVisible(true);
		type.setBounds(10,90,50,20);
		type.setBackground(new Color(189, 107, 0));
		type.setPreferredSize(new Dimension(50,30));
		type.setForeground(Theme.textColor);
		type.setText("Type: ");
		type.setFont(Fonts.mainFont);
		
	}
	
	public static void giveError() {

		typeSelector.setFont(new Font("", Font.ITALIC, 10));
		typeSelector.setForeground(Theme.errorTextColor);
		typeSelector.setText("The selected type is not valid!");
		
		typeSelector.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	typeSelectorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
            	typeSelectorFocusLost(evt);
            }
        });
		
	}
	
	
    private static void typeSelectorFocusLost(java.awt.event.FocusEvent evt) {
    	
    	if(typeSelector.getText().matches("")&&typeSelector.getBorder() == Borders.errorBorder) {
    		
        	typeSelector.setFont(new Font("", Font.ITALIC, 10));
        	typeSelector.setForeground(Theme.errorTextColor);
        	typeSelector.setText("The selected type is not valid!");
    		
    	} 
    	
    	
    	
     }                                     

    private static void typeSelectorFocusGained(java.awt.event.FocusEvent evt) {        
    	
    	typeSelector.setFont(new Font("", Font.PLAIN, 12));
    	typeSelector.setForeground(Theme.textColor);
    	
    	if(typeSelector.getText().matches("The selected type is not valid!")) {
    	typeSelector.setText("");
    	}
    	
    	if(typeSelector.getBorder() == Borders.errorBorder) {
    		typeSelector.setBorder(Borders.downBorder);
    	}

     } 
	
}
