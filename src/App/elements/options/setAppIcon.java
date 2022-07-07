package App.elements.options;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import App.settings.Borders;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;
import li.flor.nativejfilechooser.NativeJFileChooser;

public class setAppIcon {

	public JLabel IconSelector;
	public JLabel IconText;
	public static JTextField iconDir;
	public static File IconFile;
	public static String IconName;
	JFileChooser fileChooser;
	public File output;
	
	public setAppIcon(){
		
		iconDir = new JTextField();
		this.IconText = new JLabel();
		this.IconSelector = new JLabel();
	            	
		
		IconSelector.setBounds(60,80,30,30);
		IconSelector.setVisible(true);
        IconSelector.setCursor(new Cursor(Cursor.HAND_CURSOR));
		IconSelector.setBorder(Borders.buttonReleased);
		IconSelector.setForeground(Color.black);
		IconSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/browse.png"))); // NOI18N
		IconSelector.setVerticalTextPosition(JLabel.CENTER);
		IconSelector.setHorizontalTextPosition(JLabel.CENTER);
		IconSelector.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		IconSelector.setBackground(Theme.SecondaryButtonColor);
		IconSelector.setOpaque(true);
		IconSelector.setHorizontalAlignment(SwingConstants.CENTER);
		IconSelector.setVerticalAlignment(SwingConstants.CENTER);
		IconSelector.addMouseListener(new java.awt.event.MouseAdapter() {
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
		
		
		 
		iconDir.setVisible(true);
		iconDir.setBounds(100,85,330,25);
		iconDir.setBackground(Theme.SecondaryColor);
		iconDir.setForeground(Theme.textColor);
		iconDir.setBorder(Borders.downBorder);
		
		IconText.setVisible(true);
		IconText.setBounds(10,90,70,20);
		IconText.setBackground(Theme.SecondaryColor);
		IconText.setPreferredSize(new Dimension(50,30));
		IconText.setForeground(Theme.textColor);
		IconText.setText("Icon: ");
		IconText.setFont(Fonts.mainFont);
		
		
	}
	
	private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {  
		IconSelector.setBorder(Borders.buttonReleased);
		IconSelector.setBackground(Theme.mouseEntered);
  
    }     
	
	private void thisMousePressed(java.awt.event.MouseEvent evt) {
		IconSelector.setBorder(Borders.buttonPressed);
		IconSelector.setBackground(Theme.mouseExited);
		
	}

    private void thisMouseEntered(java.awt.event.MouseEvent evt) {                                     
    	IconSelector.setBackground(Theme.mouseEntered);
    	IconSelector.setOpaque(true);
    }                                    

    private void thisMouseExited(java.awt.event.MouseEvent evt) {                                    
    	IconSelector.setBackground(Theme.SecondaryButtonColor);
    	IconSelector.setOpaque(true);
    }   
    private void thisMouseClicked(java.awt.event.MouseEvent evt) {                                    
    	IconSelector.setBackground(Theme.mouseEntered);
    	IconSelector.setOpaque(true);
    	
    	this.fileChooser = new NativeJFileChooser();
	    			   
    	 JFrame frame = new JFrame("Test");
    	 	String userDir = System.getProperty("user.home");
    	    JFileChooser fileChooser = new NativeJFileChooser(userDir);
    	    fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg"));
		    fileChooser.setDialogTitle("Select App Icon");; 
    	        fileChooser.showDialog(frame, "Open");
    		    
    		    if(fileChooser.getSelectedFile() != null) {
    		    	
        	    	this.output = new File(fileChooser.getSelectedFile().getAbsolutePath());
        	    	iconDir.setText("");
        		    			   iconDir.setText(output.getAbsolutePath());
        		       		       iconDir.updateUI();
        		    			   IconName = output.getName();
    		    	
    		    }
}
}
