package App.elements.settings.AppSettings;

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
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import App.elements.settings.AppSettings.CreateCreatorDShortcut;
import App.settings.Console;
import App.settings.theme.Theme;

public class DSButton extends Component {
	
    private static final long serialVersionUID = 1L;
    CreateCreatorDShortcut CreateCreatorDShortcut = new CreateCreatorDShortcut();
    
	public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        timer.start();
    }

    private Timer timer;
    private float location;
    private boolean selected;
    private boolean mouseOver;
    private float speed = 0.1f;

    public DSButton() {
        setBackground(Theme.switchColor);
        setPreferredSize(new Dimension(50, 25));
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
  
                        	createDShortcut();
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
                        	removeDShortcut();
                        
                    }
                }
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
    }
    
	public void createDShortcut() {
		try {
			CreateCreatorDShortcut.createDShortcut();
			CreateCreatorDShortcut.warningWindow();
			
		} catch (IOException e) {
			System.out.println(Console.error + "Could not create desktop shortcut");
			e.printStackTrace();
		}
		
	}
	
	public void removeDShortcut() {
		if(CreateCreatorDShortcut.DShortcut.exists()) {
		CreateCreatorDShortcut.removeDShortcut();
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