package App.elements.settings;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import App.frame.mainFrame.mainFrame;
import App.saver.SettingsSaver;
import App.settings.Borders;
import App.settings.Console;


public class backButton {

	public JLabel jLabel1 = new JLabel();

	public backButton() {
	
    jLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    jLabel1.setBackground(new Color(71, 71, 71));
    jLabel1.setOpaque(true);
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setPreferredSize(new Dimension(60,30));
    jLabel1.setBounds(5,5,70,30);
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backArrow.png"))); // NOI18N
    jLabel1.setText("back");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	jLabel1.setVerticalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(Borders.buttonBorder);
    jLabel1.setFocusable(false);
	jLabel1.setPreferredSize(new Dimension(10, 10));
    jLabel1.addMouseListener(new MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jLabel1MousePressed(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabel1MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabel1MouseExited(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jLabel1MouseReleased(evt);
        }  
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            try {
				jLabel1MouseClicked(evt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {   
    jLabel1.setBorder(Borders.buttonPressed);
	jLabel1.setBackground(new Color(71, 71, 71));
}   

private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {  
	   jLabel1.setBorder(Borders.buttonReleased);
	   jLabel1.setBackground(new Color(71, 71, 71));
}        

private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {                                     
   jLabel1.setBackground(new Color(87, 87, 87));
   jLabel1.setOpaque(true);
}                                    

private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {                                    
    jLabel1.setBackground(new Color(71, 71, 71));
    jLabel1.setOpaque(true);

}
private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {   
	if(mainFrame.windowState == 1) {

		try {
			new SettingsSaver();
		} catch (Exception e) {
			System.out.println(Console.error + "Could not save settings");
		}

	
}
	mainFrame.mainWindow();
	
	
                }
           }); 
     }
}