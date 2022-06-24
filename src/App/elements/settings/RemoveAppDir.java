package App.elements.settings;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import App.loader.SettingsLoader;
import App.settings.theme.Theme;

@SuppressWarnings("serial")
public class RemoveAppDir extends Component {
	
	public static boolean IsOn;
	static int endLocation;
	public String IsGloballyAvailable;
    private Timer timer;
    private float location;
    public static boolean selected = false;
    private boolean mouseOver;
    private float speed = 0.1f;
	public JLabel text = new JLabel();

    public boolean isSelected() {
        return selected;
    }

    public void setSelected() {
        selected = true;
        timer.start();
    }
	
    public RemoveAppDir() {
    	
    	text.setText("Remove AppDir folders:");
    	text.setBounds(10,170,170,20);
    	text.setVisible(true);
    	text.setForeground(Color.white);
    	
        setBackground(Theme.switchColor);
        setBounds(180,170,42,23);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        location = 2;
        timer = new Timer(0, new ActionListener() {
            
        	@Override
            public void actionPerformed(ActionEvent ae) {
               
            	if (isSelected()) {
                    endLocation = getWidth() - getHeight() + 2;
                    if (location < endLocation) {
                        location += speed;
                        repaint();
                    } else {
                        timer.stop();
                        location = endLocation;
                        repaint();
                        IsOn();
                    }
                } else {
                    int endLocation = 2;
                    if (location > endLocation) {
                        location -= speed;
                        repaint();
                    } else {
                        timer.stop();
                        location = endLocation;
                        repaint();
                        IsOff();

                        }
                    
                    }
                
            }

			private void IsOff() {
				
				IsOn = false;
				
			}

			public void IsOn() {
				
				IsOn = true;
				
			}
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver = false;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if (mouseOver) {
                        selected = !selected;
                        timer.start();
                    }
                }
            }
            
        });
    	if(SettingsLoader.removeAppDirs == true) {
    		
    		IsOn = true;
    		setSelected();
    		
    	}
    	
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        float alpha = getAlpha();
        if (alpha < 1) {
            g2.setColor(Color.GRAY);
            g2.fillRoundRect(0, 0, width, height, 25, 25);
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, 25, 25);
        g2.setColor(getForeground());
        g2.setComposite(AlphaComposite.SrcOver);
        g2.fillOval((int) location, 2, height - 4, height - 4);
        super.paint(grphcs);
    }

    private float getAlpha() {
        float width = getWidth() - getHeight();
        float alpha = (location - 2) / width;
        if (alpha < 0) {
            alpha = 0;
        }
        if (alpha > 1) {
            alpha = 1;
        }
        return alpha;
    }
   

    
}