package App.imageCreator;

		import java.awt.Color;
		import java.awt.Cursor;
		import java.awt.Dimension;
		import java.awt.event.MouseEvent;
		import java.io.File;

		import javax.swing.JFileChooser;
		import javax.swing.JFrame;
		import javax.swing.JLabel;
		import javax.swing.JPanel;
		import javax.swing.JTextField;
		import javax.swing.SwingConstants;

import App.elements.advancedOptions.setFolderMode;
import App.settings.Borders;
		import App.settings.theme.Theme;
		import li.flor.nativejfilechooser.NativeJFileChooser;

		public class selectCustomAppRun {

			public static JLabel AppRunText;
			public static JLabel path = new JLabel();
			public static JTextField AppRunDir;
			public static JPanel customAppRun = new JPanel();
			public static String AppRunName;
			public static String Path;
			static int y = 50;
			public static int called = 0;
			public File output;
			
			@SuppressWarnings("static-access")
			public selectCustomAppRun(){
				
				called = 1;
				
				this.AppRunDir = new JTextField();
				this.AppRunText = new JLabel();

				customAppRun.setBackground(Theme.SecondaryColor);
				customAppRun.setBounds(10,y,450,50);
				customAppRun.setLayout(null);
				customAppRun.setVisible(true);
				customAppRun.add(path);
				customAppRun.add(AppRunDir);
				customAppRun.add(AppRunText);
				
				AppRunDir.setVisible(true);
				AppRunDir.setBounds(170,8,175,25);
				AppRunDir.setBackground(Color.DARK_GRAY);
				AppRunDir.setForeground(Color.white);
				AppRunDir.setOpaque(false);
				AppRunDir.setBorder(Borders.downBorder);
				
				AppRunText.setVisible(true);
				AppRunText.setBounds(0,15,130,15);
				AppRunText.setBackground(Color.GRAY);
				AppRunText.setPreferredSize(new Dimension(50,30));
				AppRunText.setForeground(Color.white);
				AppRunText.setText("Custom AppRun: ");
				
		        path.setVisible(true);
				path.setBounds(130,10,30,30);
				path.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/browse.png"))); // NOI1
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
			
			public static void updatePos(){
				if(setFolderMode.sb.isSelected()) {
					customAppRun.setBounds(10,95,450,50);
				} else {
					customAppRun.setBounds(10,50,450,50);
				}
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