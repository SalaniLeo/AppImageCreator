package App.imageCreator.waitingWindow;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import App.settings.Borders;
import App.settings.theme.Theme;

public class WaitingOkButton extends JLabel{
	
    private static final long serialVersionUID = 1L;
	
	public WaitingOkButton() {

		this.setVisible(true);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBorder(Borders.buttonReleased);
		this.setText("ok");
		this.setForeground(new Color(20, 20, 20));
		this.setFont(new Font("", Font.BOLD, 14));
		this.setHorizontalTextPosition(SwingConstants.LEFT);
		this.setIcon(new ImageIcon(getClass().getResource("/Images/okButton.png")));
		this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBackground(Theme.SecondaryButtonColor);
		this.setOpaque(true);
		this.setHorizontalTextPosition(SwingConstants.RIGHT);
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

	public void thisMouseClicked(java.awt.event.MouseEvent evt) {    

		WaitingWindow WaitingWindow = new WaitingWindow();
		
		WaitingWindow.resetDialog();
		}

}
 
     		    
 
		    
		


