package App.imageCreator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import App.elements.options.setAppIcon;
import App.elements.options.setAppName;

public class AppIcon {

	public static String iconName = setAppIcon.IconName;
	
	public static File sysIcon = new File(System.getProperty("user.home") + "/" + ".local/share/AppImage-Creator/icons/" + setAppName.name);
	
	AppIcon() throws IOException{
		
		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Name = setAppName.name.toString();
		String AppFolder = OutputPath + Name + ".AppDir" + "/";
		
	File source = new File(App.elements.options.setAppIcon.iconDir.getText());
	File dest = new File(AppFolder + "/" + source.getName());
	
	setIcon(source,dest);
	systemIcon(source,sysIcon);
	
	}
	
	private static void setIcon(File source, File dest) throws IOException {
	    FileUtils.copyFile(source, dest);
	}
	
	private static void systemIcon(File source, File dest) throws IOException {
	    FileUtils.copyFile(source, dest);
	  
	
	}

	
}
