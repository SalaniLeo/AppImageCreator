package App.elements;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import App.elements.options.SetAppCategories;
import App.elements.options.setAppExe;
import App.frame.mainFrame.mainFrame;
import App.imageCreator.initializer;
import App.settings.Borders;
import App.settings.Console;
import App.settings.theme.Theme;
import App.elements.options.setAppIcon;
import App.elements.options.setAppName;
import App.elements.options.setAppType;

@SuppressWarnings("serial")
public class confirmButton extends JLabel{
	
	public static int category;
	public static int type;
	ArrayList<String> ValidCategories = new ArrayList<String>();
	ArrayList<String> ValidTypes = new ArrayList<String>();
    private boolean isNameValid = false;
    public JPanel panel = new JPanel();
	
	public confirmButton() {
		
   		category = 0;
		type = 0;
		
		panel.setPreferredSize(new Dimension(70,70));
		panel.setBackground(Theme.SecondaryColor);
		panel.setVisible(true);
		panel.setLayout(null);
		panel.add(this);
		
//		this.setPreferredSize(new Dimension(60,40));
		this.setVisible(true);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBorder(Borders.buttonReleased);
		this.setForeground(new Color(20, 20, 20));
		this.setBounds(0,20,70,40);
		this.setText("next");
		this.setFont(new Font("", Font.BOLD, 14));
		this.setHorizontalTextPosition(SwingConstants.LEFT);
		this.setIcon(new ImageIcon(getClass().getResource("/Images/next1.png"))); // NOI18N
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.setBackground(Theme.SecondaryButtonColor);
		this.setOpaque(true);
		this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thisMouseClicked(evt);
            }
            
            public void mousePressed(MouseEvent evt) {
                thisMousePressed(evt);
            }
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                thisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                thisMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
		
	}

	private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {  
		this.setBorder(Borders.buttonReleased);
	    this.setBackground(Theme.mouseEntered);
    }     
	
	private void thisMousePressed(java.awt.event.MouseEvent evt) {
		this.setBorder(Borders.buttonPressed);
		this.setBackground(Theme.SecondaryButtonColor);
	}

    private void thisMouseEntered(java.awt.event.MouseEvent evt) {                                     
    	this.setBackground(Theme.mouseEntered);
    	this.setOpaque(true);
    }                                    

    private void thisMouseExited(java.awt.event.MouseEvent evt) {                                    
    	this.setBackground(Theme.SecondaryButtonColor);
    	this.setOpaque(true);
    }

	private void thisMouseClicked(java.awt.event.MouseEvent evt) {    

		UIManager.put("ToolTip.border", Borders.leftBorder);
		UIManager.put("ToolTip.foreground", Color.black);
	    UIManager.put("ToolTip.background", Theme.ButtonColor);
	    
		String exePath = setAppExe.directory.getText();
		String iconPath = setAppIcon.iconDir.getText();
	    String type = setAppType.typeSelector.getText();
	    String Category = SetAppCategories.categoriesSelector.getText();
 	    String name = setAppName.nameSelector.getText();
 	    
 	    //gives error feedback if textfield is empty
			if(exePath.equals("")) {setAppExe.directory.setBorder(Borders.errorBorder);} else {setAppExe.directory.setBorder(Borders.downBorder);}
			if(iconPath.equals("")) {setAppIcon.iconDir.setBorder(Borders.errorBorder);} else {setAppIcon.iconDir.setBorder(Borders.downBorder);}
			if(type.equals("")) {setAppType.typeSelector.setBorder(Borders.errorBorder);}
			if(Category.equals("")) {SetAppCategories.categoriesSelector.setBorder(Borders.errorBorder);}
			if(name.equals("")) {setAppName.nameSelector.setBorder(Borders.errorBorder);}
			else {
					if(setAppName.nameSelector.getText().contains(" ")) {setAppName.name = setAppName.nameSelector.getText().replaceAll(" ", "-").toLowerCase();
					} else {setAppName.name = setAppName.nameSelector.getText();}
					isNameValid = true; 
					setAppName.nameSelector.setBorder(Borders.downBorder);
				}

		  //checks if typed type is a valid type
		    if(type.matches("^[a-zA-Z]+$")){
		    	ValidTypes.add("Application");
		    	ValidTypes.add("Link");
		    	ValidTypes.add("Directory");
	        	
		    	if(!ValidTypes.contains(type)) {
		    		
	        		System.out.println(Console.error + "The selected type is not valid");
	        		setAppType.typeSelector.setBorder(Borders.errorBorder);
	        		setAppType.giveError();

	        		setAppType.type.setToolTipText(ValidTypes.toString());
	        		} else {
	        			confirmButton.type = 1;
		        		setAppType.typeSelector.setBorder(Borders.downBorder);
	        		
	        		}
	        	}
		
			  //checks if typed category is a valid type
		    if(Category.matches("^[a-zA-Z]+$")){
			    ValidCategories.add("AudioVideo");
			    ValidCategories.add("Audio");
			    ValidCategories.add("Video");
			    ValidCategories.add("Development");
			    ValidCategories.add("Education");
			    ValidCategories.add("Game");
			    ValidCategories.add("Graphics");
			    ValidCategories.add("Network");
			    ValidCategories.add("Office");
			    ValidCategories.add("Science");
			    ValidCategories.add("Settings");
			    ValidCategories.add("System");
			    ValidCategories.add("Utility");       
			        	
			        	if(!ValidCategories.contains(Category)) {	
			        		
			        		System.out.println(Console.error + "The selected category is not valid");
			        		SetAppCategories.categoriesSelector.setBorder(Borders.errorBorder);
			        		SetAppCategories.giveError();
			        		
			        		
			                List<String> categories = ValidCategories.stream().distinct().collect(Collectors.toList());
			        		SetAppCategories.categories.setToolTipText(categories.toString());
			       	} else {
			       		confirmButton.category = 1;
			       		SetAppCategories.categoriesSelector.setBorder(Borders.downBorder);
			       	}
		    }

		    if(ValidCategories.contains(Category)&&ValidTypes.contains(type)&&isNameValid == true&&!exePath.matches("")&&!iconPath.matches("")) {

			    mainFrame.AppImageWindow();
			    
		    }
		    
		}

}
 
     		    
 
		    
		


