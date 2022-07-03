package App.elements.options;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import App.settings.Borders;
import App.settings.theme.Fonts;
import App.settings.theme.Theme;
import li.flor.nativejfilechooser.NativeJFileChooser;

public class setAppExe{
	
    String Path;
	public static JTextField directory = new JTextField();
	public static JLabel label = new JLabel();
	
	public File execFile;
	public static String execFullName;
	public static String execPath;
	public static String execName;
	public static File output;
	public static JLabel exeSelector;
	
	public setAppExe(){
		
		exeSelector = new JLabel();
		
		label.setText("Executable:");
		label.setBounds(10,10,100,20);
		label.setForeground(Theme.textColor);
		label.setFont(Fonts.mainFont);
		 
		directory.setPreferredSize(new Dimension(460,30));
    	directory.setBackground(Theme.SecondaryColor);
		directory.setVisible(true);
		directory.setForeground(Theme.textColor);
		directory.setBounds(150, 10, 280, 20);
		directory.setBorder(Borders.downBorder);
		
		exeSelector.setVisible(true);
		exeSelector.setBounds(110,2,30,30);
		exeSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/browse.png"))); // NOI1
		exeSelector.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exeSelector.setBorder(Borders.buttonReleased);
		exeSelector.setForeground(new Color(20, 20, 20));
		exeSelector.setHorizontalAlignment(SwingConstants.CENTER);
		exeSelector.setVerticalAlignment(SwingConstants.CENTER);
		exeSelector.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		exeSelector.setBackground(Theme.SecondaryButtonColor);
		exeSelector.setOpaque(true);
		exeSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exeSelectorMouseClicked(evt);
            }
            
            public void mousePressed(MouseEvent evt) {
                exeSelectorMousePressed(evt);
                
            }
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exeSelectorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exeSelectorMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
	}

	private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {  
		exeSelector.setBorder(Borders.buttonReleased);
		exeSelector.setBackground(Theme.mouseEntered);
  
    }     
	
	private void exeSelectorMousePressed(java.awt.event.MouseEvent evt) {
		exeSelector.setBorder(Borders.buttonPressed);
		exeSelector.setBackground(Theme.mouseExited);
	}

    private void exeSelectorMouseEntered(java.awt.event.MouseEvent evt) {                                     
    	exeSelector.setBackground(Theme.mouseEntered);
    	exeSelector.setOpaque(true);
    }                                    

    private void exeSelectorMouseExited(java.awt.event.MouseEvent evt) {                                    
    	exeSelector.setBackground(Theme.SecondaryButtonColor);
    	exeSelector.setOpaque(true);
    }
    

    private void exeSelectorMouseClicked(java.awt.event.MouseEvent evt) { 
    	
		exeSelector.setBackground(Theme.mouseEntered);
		   
   	 JFrame frame = new JFrame();
 	String userDir = System.getProperty("user.home");
   	    JFileChooser fileChooser = new NativeJFileChooser(userDir);
		    fileChooser.setDialogTitle("Select App Exe");
   	        fileChooser.showDialog(frame, "Open");
   		    
   		    
		    if(fileChooser.getSelectedFile() != null) {
   		    
   		 output = new File(fileChooser.getSelectedFile().getAbsolutePath());
   		execFullName = output.getName();
   		    	    	output = new File(fileChooser.getSelectedFile().getAbsolutePath());
   		    	    	File exe = new File(fileChooser.getSelectedFile().getAbsolutePath());
   		    	    	exe.setExecutable(true);
		    			   execPath = output.getAbsolutePath();
		    			directory.setText(execPath);
		    }
   		   			
                 }
   
	}
