package App.imageCreator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import App.elements.AppImageConfiguration.folderMode.setParentDirectory;
import App.elements.advancedOptions.setCustomRunner;
import App.elements.advancedOptions.setSystemIntegration;
import App.elements.options.setAppExe;
import App.elements.options.setAppIcon;
import App.elements.options.setAppName;
import App.elements.options.setAppShortcut;
import App.elements.options.setAppType;
import App.settings.Console;

public class initializer {
	
	static String icon;
	static File iconPath;
	
	public static String ExecFolder;
	
	public void createImageFiles() throws IOException, InterruptedException{

		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Icon = setAppIcon.iconDir.getText();
		String Name = setAppName.name.toString();
		String Type = setAppType.typeSelector.getText();
		String Program = setAppExe.directory.getText();
		
		System.out.println(Console.info + "Program Path: " + Program);
		System.out.println(Console.info + "Name: " + Name);
		System.out.println(Console.info + "Icon Path: " + Icon);
		System.out.println(Console.info + "Type: " + Type);
	   	System.out.println(Console.info + "Path: " + OutputPath);
	   	
	   	String AppFolder = OutputPath + Name + ".AppDir" + "/";
		String execPath = AppFolder + "usr/bin/";
	   	
		initializer.ExecFolder = execPath;
		
		//creates the .AppDir folder
	   	new File(OutputPath + Name + ".AppDir").mkdirs();
	   	//creates default executable path
	   	new File(AppFolder + "usr/bin/").mkdirs();
	   	
	   	
	    //moves the executable file from selected folder into the .AppImage
	   	new AppExec();
	   	
	    //moves the icon from selected folder into the .AppImage
	   	new AppIcon();
	   	
	    //create the .desktop file for the .AppImage
		new AppDesktopFile();
		
		if(setCustomRunner.IsOn == 1) {
			
			//picks the selected AppRun File to execute the application
			new AppCustomRunner();
			
		} else {
		
		//create the default AppRun file for the .AppImage
		new AppRun();
		
		}
		
		if(setAppShortcut.IsOn == 1) {
				new AppShortcut();

		} 
		
		if(setSystemIntegration.isOn == 1) {
			
			new AppSystemIntegration();
			
		}
		
		//create (name).AppImage in selected directory
		new AppImageFileCreator();
	}
	
	//Starts the second JFrame
	
	public void AppImageInit() throws IOException {
	
	  App.frame.mainFrame.mainFrame.AppImageWindow();
	
	}
	
	public void FolderModeInit() throws IOException, InterruptedException {
		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Name = setAppName.name.toString();
		
		String AppFolder = OutputPath + Name + ".AppDir" + "/";
		
		//creates the .AppDir folder
	   	new File(OutputPath + Name + ".AppDir").mkdirs();
	   	//creates default executable path
	   	new File(AppFolder + "usr").mkdirs();
	   	
	   	
	    //moves the executable file from selected folder into the .AppImage
	   	new AppExec();
	   	
	    //moves the icon from selected folder into the .AppImage
	   	new AppIcon();
	   	
	    //create the .desktop file for the .AppImage
		new AppDesktopFile();
		
		
		if(setAppShortcut.IsOn == 1) {
			new AppShortcut();

     	} 
		
		if(setCustomRunner.IsOn == 1) {	
			new AppCustomRunner();
		} else {

			new AppRun();
		}
		
		if(setSystemIntegration.isOn == 1) {
			
			new setSystemIntegration();
			
		}

		copyDirectory();
		
		
		
		new AppImageFileCreator();
		
		
		
	}

	    	public static void copyDirectory() throws IOException {
	    		String OutputPath = AppLocation.AppPath.getText() + "/";
	    		String Name = setAppName.name.toString();
	    		String AppFolder = OutputPath + Name + ".AppDir/";
	    	    File sourceDirectory = new File(setParentDirectory.AppRunDir.getText());
	    	    File destinationDirectory = new File(AppFolder+ "/usr/");
	    	    FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
	    	}
	    	
}
