package App.elements;

import java.awt.Dimension;
import javax.swing.JScrollBar;

import App.settings.theme.Theme;

/*
 * 
 * 
 *     Made by DJ-Raven
 * 
 * 
 * 
 */

public class ScrollBarCustom extends JScrollBar {

    private static final long serialVersionUID = 1L;

	public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(Theme.switchColor);
        setBackground(Theme.SecondaryColor);
    }
}
