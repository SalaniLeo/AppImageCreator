package App.elements.settings.AppImageSettings;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import App.Settings;
import App.settings.Borders;
import App.settings.theme.Theme;
import li.flor.nativejfilechooser.NativeJFileChooser;

public class DefaultAppLocation {

	public static JTextField LocationSelector;
	public JLabel Location;
	public JLabel Browse;
	public static String dir = null;

	public DefaultAppLocation(){
		
		Browse = new JLabel();
		Location = new JLabel();
		LocationSelector = new JTextField();
		
		if(Settings.defaultLocationOn == true) {
			
			LocationSelector.setText(Settings.defaultLocation);
			
		}
		LocationSelector.setBounds(260,170,188,20);
		LocationSelector.setVisible(true);
	    LocationSelector.setPreferredSize(new Dimension(300,20));
	    LocationSelector.setBorder(null);
	    LocationSelector.setBackground(Theme.SecondaryColor);
		LocationSelector.setForeground(Theme.textColor);
		LocationSelector.setBorder(Borders.downBorder);
		
		Location.setVisible(true);
		Location.setBounds(10,170,220,20);
		Location.setBackground(new Color(189, 107, 0));
		Location.setPreferredSize(new Dimension(50,30));
		Location.setForeground(Theme.textColor);
		Location.setText("Default AppImages location: ");
		Location.setFont(new Font(null,Font.PLAIN, 14));
		
		Browse.setPreferredSize(new Dimension(30,30));
		Browse.setBounds(220,170,27,27);
		Browse.setVisible(true);
		Browse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Browse.setBorder(Borders.buttonReleased);
		Browse.setForeground(new Color(20, 20, 20));
		Browse.setText(" ...");
		Browse.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        Browse.setBackground(Theme.SecondaryButtonColor);
		Browse.setOpaque(true);
		Browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrowseMouseClicked(evt);
            }
            
            public void mousePressed(MouseEvent evt) {
                BrowseMousePressed(evt);
                
            }
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BrowseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BrowseMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
	}

	private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {  
		Browse.setBorder(Borders.buttonReleased);
		Browse.setBackground(Theme.mouseEntered);
  
    }     
	
	private void BrowseMousePressed(java.awt.event.MouseEvent evt) {
		Browse.setBorder(Borders.buttonPressed);
		Browse.setBackground(Theme.mouseExited);
	}

    private void BrowseMouseEntered(java.awt.event.MouseEvent evt) {                                     
    	Browse.setBackground(Theme.mouseEntered);
    	Browse.setOpaque(true);
    }                                    

    private void BrowseMouseExited(java.awt.event.MouseEvent evt) {                                    
    	Browse.setBackground(Theme.SecondaryButtonColor);
    	Browse.setOpaque(true);
    }
    
    private void BrowseMouseClicked(java.awt.event.MouseEvent evt) { 
    	
		Browse.setBackground(Theme.mouseEntered);
		   
   	 JFrame frame = new JFrame("Test");
 	String userDir = System.getProperty("user.home");
   	    JFileChooser fileChooser = new NativeJFileChooser(userDir);
		    fileChooser.setDialogTitle("Set Default App Location");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
   	        fileChooser.showDialog(frame, "Open");
   		 dir = new String(fileChooser.getSelectedFile().getAbsolutePath());
   		   			LocationSelector.setText(dir);
           }
	}

