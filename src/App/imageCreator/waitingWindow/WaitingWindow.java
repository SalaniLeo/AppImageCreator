package App.imageCreator.waitingWindow;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

import App.elements.ScrollBarCustom;
import App.settings.theme.Theme;

public class WaitingWindow extends Component implements ActionListener {
	
	private WaitingOkButton WaitingOkButton = new WaitingOkButton();
	public JScrollBar sc = new ScrollBarCustom();
	private Timer timer = new Timer(7, this);
    private int posX;
    private int xVelocity = 1;
    private int width = 50;
	public JTextArea ta = new JTextArea();
	public JPanel mainPanel = new JPanel(); 
	
	private static final long serialVersionUID = 1L;
	public static JFrame frame = new JFrame();
	public static JDialog d = new JDialog(frame, "AppImage Creator"); 
	public JLabel feedbackLabel = new JLabel();
	
	public boolean loaded = false;
    public boolean isfinalPanel = false;
    public JScrollPane s = new JScrollPane(ta , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
	public Component WaitingFrame(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		d.setLocationRelativeTo(null);

		WaitingOkButton.setBounds(150,120,60,30);
        
		feedbackLabel.setBackground(Theme.SecondaryColor);
		feedbackLabel.setForeground(Theme.textColor);
		feedbackLabel.setBounds(100,110,200,20);
		feedbackLabel.setVisible(true);
		feedbackLabel.setOpaque(true);
        
        s.setBounds(25,20,300,80);
        s.setBorder(null);
        s.setVisible(true);
        s.setBackground(Theme.MainColor);
        s.setForeground(Theme.MainColor);
        s.setVerticalScrollBar(sc);
        
        ta.setEditable(false);
        ta.setBounds(25,40,275,65);
        ta.setVisible(true);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(new Font(null, Font.PLAIN, 9));
        ta.setBackground(Theme.MainColor);
        ta.setForeground(Theme.textColor);
        ta.setBorder(new javax.swing.border.SoftBevelBorder(BevelBorder.RAISED, new Color(51, 51, 51), new Color(51, 51, 51), new Color(51, 51, 51), new Color(51, 51, 51)));
        
        d.setResizable(false);
        d.add(mainPanel); 
        d.setBackground(Theme.SecondaryColor);
        d.setSize(350, 200); 
        d.setVisible(true); 
    	timer.start();
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                timer.stop();
            }

        });
    	
    	this.setBounds(50,145,250,5);
    	this.setVisible(true);
    	
    	mainPanel.setPreferredSize(new Dimension(300,150));
    	mainPanel.setBackground(Theme.SecondaryColor);
    	mainPanel.setLayout(null);
    	mainPanel.add(this);
    	mainPanel.add(s);
    	mainPanel.add(feedbackLabel);
    	
		return mainPanel;

	}
	
	@Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setColor(Color.white);
        g2.fillRoundRect(0, 0, width, height, 8, 8);
        g2.setColor(Theme.switchColor);
        g2.fillRoundRect(posX, 0, this.width, height,10,10);
        super.paint(grphcs);
        
	}		

	@Override
	public void actionPerformed(ActionEvent e) {
			if(posX>=this.getWidth()-width || posX<0) {
				xVelocity = xVelocity * -1;
			}
			posX = posX + xVelocity;
			repaint();
	}
	
	public void changePanel() {
		mainPanel.remove(this);
		mainPanel.remove(feedbackLabel);
		
		mainPanel.add(WaitingOkButton);
	    
		
		
		mainPanel.updateUI();
	}
	
	public void resetDialog() {
		frame.dispose();
		mainPanel.remove(ta);
	}
	
}
