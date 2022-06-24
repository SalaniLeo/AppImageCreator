package App.elements.AppImageConfiguration.folderMode;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import App.loader.SettingsLoader;
import App.settings.Console;
import App.settings.theme.Theme;

@SuppressWarnings("serial")
public class folderModePanel extends Component {
	
	public static int IsOn = 0;
	
	public String IsGloballyAvailable;
	
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
    public JPanel folderMode = new JPanel();
	JLabel ask = new JLabel();
    public folderModePanel() {
    	
    	this.ask = new JLabel();
    	
    	ask.setText("Folder mode:");
    	ask.setBounds(10,10,100,20);
    	ask.setVisible(true);
    	ask.setForeground(Color.white);
    	
    	folderMode.setVisible(true);
    	folderMode.setBackground(Theme.SecondaryColor);
    	folderMode.setPreferredSize(new Dimension(50,40));
    	folderMode.setOpaque(true);
    	folderMode.setLayout(null);
    	folderMode.add(ask);
    	folderMode.add(this);
    	
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(Theme.switchColor);
        setBounds(115,10,42,23);
        setForeground(Color.WHITE);
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
				
				IsOn = 0;
				setParentDirectory.ParentDir.setVisible(false);
				System.out.println(Console.info + "Folder mode: " + "no");
				//add this to next panel not that as of now
				
			}

			public void IsOn() {
				
				IsOn = 1;
				setParentDirectory.ParentDir.setVisible(true);
				System.out.println(Console.info + "Folder mode: " + "yes");
				
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
        
    	if(SettingsLoader.folderMode == true) {
    		
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