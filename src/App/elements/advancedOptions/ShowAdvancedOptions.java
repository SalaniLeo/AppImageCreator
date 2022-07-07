package App.elements.advancedOptions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import App.settings.theme.Fonts;
import App.settings.theme.Theme;
import App.elements.options.optionsPanel;
import App.frame.mainFrame.AdvancedOptionsPanel;

@SuppressWarnings("serial")
public class ShowAdvancedOptions extends JCheckBox {

	@SuppressWarnings("unused")
	private int IsOn;
	public static int isOn;
    private final int border = 4;
	public JLabel textArea;
	
    public ShowAdvancedOptions() {
		new AdvancedOptionsPanel();
    	textArea = new JLabel();
    	
        textArea.setText("Show Advanced Options");    	
        textArea.setFont(Fonts.mainFont);
    	textArea.setBounds(25,7,200,15);
    	textArea.setForeground(Color.white);
    	textArea.setBackground(Theme.darkerGray);
    	textArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	textArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(MouseEvent me) {

                    if (SwingUtilities.isLeftMouseButton(me)) {
                        
                     	if(AdvancedOptionsPanel.jPanel.isDisplayable() != true) {
                    		optionsPanel.JPanel.add(AdvancedOptionsPanel.jPanel);  
                    		optionsPanel.JPanel.updateUI(); 
                    	} else {
                    		optionsPanel.JPanel.remove(AdvancedOptionsPanel.jPanel); 
                    		optionsPanel.JPanel.updateUI(); 
                    	}
                    	
                    	if(ShowAdvancedOptions.this.isSelected() != true) {
                    		
                    		ShowAdvancedOptions.this.setSelected(true);
                    		ShowAdvancedOptions.this.setEnabled(true);
                    		
                    	} else {
                    		
                    		ShowAdvancedOptions.this.setSelected(false);
                    		ShowAdvancedOptions.this.setEnabled(false);
                    		
                    	}
                    	
                     }
                 }
             });
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        setBounds(5,5,20,20);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(MouseEvent me) {

                    if (SwingUtilities.isLeftMouseButton(me)) {
                        
                    	if(AdvancedOptionsPanel.jPanel.isDisplayable() != true) {
                    		optionsPanel.JPanel.add(AdvancedOptionsPanel.jPanel, BorderLayout.CENTER);  
                    		optionsPanel.JPanel.updateUI(); 
                    	} else {
                    		optionsPanel.JPanel.remove(AdvancedOptionsPanel.jPanel); 
                    		optionsPanel.JPanel.updateUI(); 
                    	}	
                     }
                 }
             });
         }
     

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int ly = (getHeight() - 16) / 2;
        
        if (isSelected()) {
            if (isEnabled()) {
            	
                setBackground(Theme.switchColor);
                g2.setColor(getBackground());    
            }
            
            g2.fillRoundRect(1, ly, 16, 16, border, border);
            //  Draw Check icon
            int px[] = {4, 8, 14, 12, 8, 6};
            int py[] = {ly + 8, ly + 14, ly + 5, ly + 3, ly + 10, ly + 6};
            g2.setColor(Color.WHITE);
            g2.fillPolygon(px, py, px.length);
        } else {
        	setBackground(Color.white);
            g2.setColor(Color.GRAY);
            g2.fillRoundRect(1, ly, 16, 16, border, border);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(2, ly + 1, 14, 14, border, border);
        }
        g2.dispose();  
    }
}