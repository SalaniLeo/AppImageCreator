/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package App.elements.settings;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import App.Settings;
import App.frame.mainFrame.mainFrame;
import App.settings.Borders;
import App.settings.Console;

/**  
 *
 * @author leo
 */
@SuppressWarnings("serial")
public class SettingsButton extends JLabel{

    public SettingsButton() {
        initComponents();
    }
    Settings Settings = new Settings();           
    private void initComponents() {

    	Border a = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY,
    	        Color.DARK_GRAY);
    	
    	
    	
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N
        this.setBorder(a);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(new Color(71, 71, 71));
        this.setOpaque(true);
		this.setBorder(Borders.buttonReleased);
        this.setFocusable(false);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
        this.setPreferredSize(new java.awt.Dimension(38, 38));
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
    
    private void thisMouseClicked(java.awt.event.MouseEvent evt) {   
        
        if(mainFrame.windowState == 0) {
        	
        	mainFrame.settingsWindow();
        } else {
        	
           	if(mainFrame.windowState == 2) {
        		
        		mainFrame.settingsWindow();
        		
        	} else {
        		
        		if(mainFrame.windowState == 3) {

        			mainFrame.AppImageWindow();
        			
        		} else {
        			
        			if(mainFrame.windowState == 1) {
        				try {
        					Settings.saveSettings();
						} catch (Exception e) {
							System.out.println(Console.error + "Could not save settings");
						}
        	               mainFrame.mainWindow();
        			}
        		}
        	}
        }
    }   
    

	private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {  
		this.setBorder(Borders.buttonReleased);
		this.setBackground(getBackground());
  
    }     
	
	private void thisMousePressed(java.awt.event.MouseEvent evt) {
		this.setBorder(Borders.buttonPressed);
		this.setBackground(new Color(71, 71, 71));
		
	}

    private void thisMouseEntered(java.awt.event.MouseEvent evt) {                                     
       this.setBackground(new Color(87, 87, 87));
       this.setOpaque(true);
    }                                    

    private void thisMouseExited(java.awt.event.MouseEvent evt) {                                    
        this.setBackground(new Color(71, 71, 71));
        this.setOpaque(true);
    }                                                
}
