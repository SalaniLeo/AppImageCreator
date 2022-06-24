package App.settings;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import App.settings.theme.Theme;

public class Borders {

	JPanel base;
    
	
	static Border oldBorder = null;
    static Border blackBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black);
    static Border newTopBorder = BorderFactory.createCompoundBorder(blackBorder, oldBorder);
    public static Border topBorder = newTopBorder;
	
    static Border oldBorder1 = null;
    static Border blackBorder1 = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.black);
    static Border newLeftBorder = BorderFactory.createCompoundBorder(blackBorder1, oldBorder1);
    public static Border leftBorder = newLeftBorder;
      
      
      
       static Border oldBorder2 = null;
       static Border blackBorder2 = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.black);
	   static Border newRightBorder = BorderFactory.createCompoundBorder(blackBorder2, oldBorder2);
	   public static Border rightBorder = newRightBorder;
	       
	       
	       
	         static Border oldBorder3 = null;
		     static Border blackBorder3 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
		     static Border newDownBorder = BorderFactory.createCompoundBorder(blackBorder3, oldBorder3);
		     public static Border downBorder = newDownBorder;
		     
		     
		     
	         static Border oldBorder4 = null;
		     static Border blackBorder4 = BorderFactory.createMatteBorder(1, 1, 0, 0, Color.black);
		     static Border newLeftTopBorder = BorderFactory.createCompoundBorder(blackBorder4, oldBorder4);
		     public static Border leftTopBorder = newLeftTopBorder;
		     
		     
		     
	         static Border oldBorder5 = null;
		     static Border blackBorder5 = BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black);
		     static Border newLeftTopBottomBorder = BorderFactory.createCompoundBorder(blackBorder5, oldBorder5);
		     public static Border leftTopBottomBorder = newLeftTopBorder;
		     
		     
		     
	         static Border oldBorder6 = null;
		     static Border blackBorder6 = BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black);
		     static Border newLeftBottomBorder = BorderFactory.createCompoundBorder(blackBorder6, oldBorder6);
		     public static Border leftBottomBorder = newLeftTopBorder;
      
	     
	         static Border oldBorder7 = null;
		     static Border blackBorder7 = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(150, 0, 0));
		     static Border newErrorBorder = BorderFactory.createCompoundBorder(blackBorder7, oldBorder7);
		     public static Border errorBorder = newErrorBorder;

		     
		 	public static Border buttonPressed = BorderFactory.createBevelBorder(BevelBorder.RAISED, Theme.MainColor,
			        Theme.MainColor);
		 	
		 	public static Border buttonReleased = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY,
			        Color.DARK_GRAY);
		     
	        public static Border buttonBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, Theme.MainColor, Theme.MainColor);
}
