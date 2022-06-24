package App.elements.AppImageConfiguration.folderMode;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import App.settings.Borders;
import App.settings.theme.Theme;
import li.flor.nativejfilechooser.NativeJFileChooser;

public class setParentDirectory {

	public JLabel AppRunText;
	public static JTextField AppRunDir;
	public static JPanel ParentDir = new JPanel();
	public File output;
	public static String FolderName;
	public static JLabel path;
	
	public setParentDirectory(){
		
		AppRunDir = new JTextField();
		this.AppRunText = new JLabel();
		path = new JLabel();
		
		AppRunDir.setVisible(true);
		AppRunDir.setBounds(160,13,175,25);
		AppRunDir.setBackground(Theme.SecondaryColor);
		AppRunDir.setForeground(Color.white);
		AppRunDir.setBorder(Borders.downBorder);
		
		AppRunText.setVisible(true);
		AppRunText.setBounds(0,17,130,15);
		AppRunText.setBackground(Color.GRAY);
		AppRunText.setPreferredSize(new Dimension(50,30));
		AppRunText.setForeground(Color.white);
		AppRunText.setText("Set app folder: ");
		
		ParentDir.setBackground(Theme.SecondaryColor);
		ParentDir.setBounds(10,50,450,40);
		ParentDir.setLayout(null);
		ParentDir.setVisible(true);
		ParentDir.add(path);
		ParentDir.add(AppRunDir);
		ParentDir.add(AppRunText);
		
        path.setVisible(true);
		path.setBounds(120,10,30,30);
		path.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/browse.png")));
		path.setCursor(new Cursor(Cursor.HAND_CURSOR));
		path.setBorder(Borders.buttonReleased);
		path.setForeground(new Color(20, 20, 20));
		path.setHorizontalAlignment(SwingConstants.CENTER);
		path.setVerticalAlignment(SwingConstants.CENTER);
		path.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		path.setBackground(Theme.SecondaryButtonColor);
		path.setOpaque(true);
		path.addMouseListener(new java.awt.event.MouseAdapter() {
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
		path.setBorder(Borders.buttonReleased);
		path.setBackground(Theme.mouseEntered);
  
    }     
	
	private void exeSelectorMousePressed(java.awt.event.MouseEvent evt) {
		path.setBorder(Borders.buttonPressed);
		path.setBackground(Theme.mouseExited);
	}

    private void exeSelectorMouseEntered(java.awt.event.MouseEvent evt) {                                     
    	path.setBackground(Theme.mouseEntered);
    	path.setOpaque(true);
    }                                    

    private void exeSelectorMouseExited(java.awt.event.MouseEvent evt) {                                    
    	path.setBackground(Theme.SecondaryButtonColor);
    	path.setOpaque(true);
    }
    

    private void exeSelectorMouseClicked(java.awt.event.MouseEvent evt) { 
    	
     path.setBackground(Theme.mouseEntered);
		   
   	 JFrame frame = new JFrame();
 	String userDir = System.getProperty("user.home");
   	    JFileChooser fileChooser = new NativeJFileChooser(userDir);
		    fileChooser.setDialogTitle("Select App Exe");
   			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
   	        fileChooser.showDialog(frame, "Open");
   		    
		    if(fileChooser.getSelectedFile() != null) {
   		    
   		 output = new File(fileChooser.getSelectedFile().getAbsolutePath());
   		    	   	output = new File(fileChooser.getSelectedFile().getAbsolutePath());
   		    	    	File exe = new File(fileChooser.getSelectedFile().getAbsolutePath());
   		    	    	exe.setExecutable(true);
   		    	    	AppRunDir.setText(output.getAbsolutePath());
		    }
   		   			
                 }
   
	}

