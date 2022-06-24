package App.elements.advancedOptions;

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
import App.settings.Console;
import App.settings.theme.Theme;

@SuppressWarnings("serial")
public class setSystemIntegration extends Component {
	
	public String buttonOn;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected() {
        this.selected = true;
        timer.start();
    }

    private Timer timer;
    private float location;
    private boolean selected;
    private boolean mouseOver;
    private float speed = 0.1f;
	public JLabel textArea = new JLabel();
	public static int isOn;
	
    public setSystemIntegration() {
    	
    	textArea = new JLabel();
    	
    	textArea.setText("Set launcher shortcut:");
    	textArea.setBounds(10,10,300,20);
    	textArea.setVisible(true);
    	textArea.setForeground(Color.white);
    	
    	
        setBackground(Theme.switchColor);
        setBounds(180,10,42,23);
        setVisible(true);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        location = 2;
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (isSelected()) {
                    int endLocation = getWidth() - getHeight() + 2;
                    if (location < endLocation) {
                        location += speed;
                        repaint();
                    } else {
                        timer.stop();
                        location = endLocation;
                        repaint();
                        SetOn();
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
                        SetOff();
                    }
                }
            }

			private void SetOff() {

				isOn = 0;
				System.out.println(Console.info + "System Integration: no");
				
				
			}

			public void SetOn() {
				
				isOn = 1;
				System.out.println(Console.info + "System Integration: yes");
				
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
        
    	if(SettingsLoader.integrateMode == true) {
    		
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
            g2.setColor(Theme.ButtonColor);
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