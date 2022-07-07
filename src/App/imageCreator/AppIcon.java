package App.imageCreator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import App.elements.options.setAppIcon;
import App.elements.options.setAppName;

public class AppIcon {

	public static String iconName = setAppIcon.IconName;
	
	File sysIcon = new File(System.getProperty("user.home") + "/" + ".local/share/AppImage-Creator/icons/" + setAppName.name.toString());
	
	public void SetIcon() throws IOException {
		File source = new File(App.elements.options.setAppIcon.iconDir.getText());
		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Name = setAppName.name.toString();
		String AppFolder = OutputPath + Name + ".AppDir" + "/";
		File dest = new File(AppFolder + "/" + source.getName());
	    FileUtils.copyFile(source, dest);
	}
	
	public void SystemIcon() throws IOException {
		
		File sysIcon = new File(System.getProperty("user.home") + "/" + ".local/share/AppImage-Creator/icons/" + setAppName.name.toString());
		File source = new File(App.elements.options.setAppIcon.iconDir.getText());
	    FileUtils.copyFile(source, sysIcon);
	  
	
	}

	
}
