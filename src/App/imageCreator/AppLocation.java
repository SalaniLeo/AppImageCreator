package App.imageCreator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import javax.swing.colorchooser.ColorSelectionModel;

import App.settings.Borders;
import App.settings.theme.Theme;
import li.flor.nativejfilechooser.NativeJFileChooser;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import App.loader.SettingsLoader;
import App.settings.Borders;
import App.settings.theme.Theme;
import li.flor.nativejfilechooser.NativeJFileChooser;

public class AppLocation {

	public static JTextField AppPath = new JTextField();
	public static JPanel LocationPanel = new JPanel();
	private JLabel SelectAppLocation = new JLabel();
	public static JLabel path;

	public File output;
	@SuppressWarnings("unused")
	private int response;
	public static String outputPath;
	
	public AppLocation(){

		this.path = new JLabel();
		
		if(SettingsLoader.defaultLocation != "") {
			
			AppPath.setText(SettingsLoader.defaultLocation);
			
		}
	
	
	AppPath.setPreferredSize(new Dimension(200,30));
	AppPath.setVisible(true);
	AppPath.setBounds(195,50,100,25);
	AppPath.setBackground(App.settings.theme.Theme.SecondaryColor);
	AppPath.setForeground(Color.white);
	
	AppPath.setBorder(Borders.downBorder);
	
	SelectAppLocation.setText("Select app location:");
	SelectAppLocation.setForeground(Color.white);
	SelectAppLocation.setVisible(true);
	SelectAppLocation.setPreferredSize(new Dimension(150,15));
	
	LocationPanel.setVisible(true);
	
	FlowLayout layout = new FlowLayout();
	
	layout.setAlignment(FlowLayout.LEADING);
	
	LocationPanel.setPreferredSize(new Dimension(200,50));
	LocationPanel.setBounds(5,10,500,50);
	LocationPanel.setBackground(App.settings.theme.Theme.SecondaryColor);
	LocationPanel.setLayout(layout);
	LocationPanel.add(SelectAppLocation);
	LocationPanel.add(path);
	LocationPanel.add(AppPath);
	
	        path.setVisible(true);
			path.setBounds(130,0,30,30);
			path.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/browse.png")));
			path.setCursor(new Cursor(Cursor.HAND_CURSOR));
			path.setBorder(Borders.buttonReleased);
	        path.setPreferredSize(new Dimension(30,30));
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
	   		    	    	AppPath.setText(output.getAbsolutePath());
			    }
	   		   			
	                 }
	   
		}



