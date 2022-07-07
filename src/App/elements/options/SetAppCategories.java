package App.elements.options;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import App.settings.Borders;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;

public class SetAppCategories extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public static JTextField categoriesSelector;
	public static JLabel categories;
	
	public SetAppCategories(){
		
		
		categories = new JLabel();
		categoriesSelector = new JTextField();
		 
		categoriesSelector.setBounds(100,0,200,20);
		categoriesSelector.setVisible(true);
		categoriesSelector.setBackground(Theme.SecondaryColor);
		categoriesSelector.setForeground(Theme.textColor);
		categoriesSelector.setBorder(Borders.downBorder);
		
		categories.setVisible(true);
		categories.setBounds(0,0,100,20);
	    categories.setBackground(new Color(189, 107, 0));
		categories.setPreferredSize(new Dimension(50,30));
		categories.setForeground(Theme.textColor);
	    categories.setText("Categories: ");
	    categories.setFont(Fonts.mainFont);

	    this.add(categories);
	    this.add(categoriesSelector);
	    this.setVisible(true);
	    this.setLayout(null);
	    this.setBounds(10,130,270,20);
	    this.setBackground(Theme.SecondaryColor);
	    this.setPreferredSize(new Dimension(250,40));
	    
       } 
	
	public static void giveError() {

    	categoriesSelector.setFont(new Font("", Font.ITALIC, 10));
    	categoriesSelector.setForeground(Theme.errorTextColor);
    	categoriesSelector.setText("The selected category is not valid!");
		
		categoriesSelector.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	categoriesSelectorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
            	categoriesSelectorFocusLost(evt);
            }
        });
		
	}
	
	
    private static void categoriesSelectorFocusLost(java.awt.event.FocusEvent evt) {
    	
    	if(categoriesSelector.getText().matches("")&&categoriesSelector.getBorder() == Borders.errorBorder) {
    		
        	categoriesSelector.setFont(new Font("", Font.ITALIC, 10));
        	categoriesSelector.setForeground(Theme.errorTextColor);
        	categoriesSelector.setText("The selected category is not valid!");
    		
    	} 
    	
    	
    	
     }                                     

    private static void categoriesSelectorFocusGained(java.awt.event.FocusEvent evt) {        
    	
    	if(categoriesSelector.getText().matches("The selected category is not valid!")) {
    	categoriesSelector.setText("");
    	}
    	
    	if(categoriesSelector.getBorder() == Borders.errorBorder) {
    		
    		categoriesSelector.setBorder(Borders.downBorder);
    		
    	}
    	
    	categoriesSelector.setFont(new Font("", Font.PLAIN, 12));
    	categoriesSelector.setForeground(Theme.textColor);
     }     
	
	
	
}
