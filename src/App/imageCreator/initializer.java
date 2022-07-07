package App.imageCreator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import App.elements.advancedOptions.setCustomRunner;
import App.elements.options.setAppExe;
import App.elements.options.setAppIcon;
import App.elements.options.setAppName;
import App.elements.options.setAppShortcut;
import App.elements.options.setAppType;
import App.elements.options.setLauncherShortcut;
import App.frame.mainFrame.mainFrame;
import App.settings.Console;

public class initializer {
	
	static String icon;
	static File iconPath;
	
	public static String ExecFolder;

	AppExec AppExec = new AppExec();
	AppIcon AppIcon = new AppIcon();
	AppRun AppRun = new AppRun();
	AppCustomRunner AppCustomRunner = new AppCustomRunner();
	AppDesktopFile AppDesktopFile = new AppDesktopFile();
	AppShortcut AppShortcut = new AppShortcut();
	AppImageFileCreator AppImageFileCreator = new AppImageFileCreator();
	AppSystemIntegration AppSystemIntegration = new AppSystemIntegration();
	
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
	   	AppExec.setExe();
	   	
	    //moves the icon from selected folder into the .AppImage
	    AppIcon.SetIcon();
	   	
	   	if(setAppShortcut.sb.isSelected()||setLauncherShortcut.sb.isSelected()) {
	   	//copies the icon to /.local/share/applications/AppImage-Creator/ for system access of the icon
	   	AppIcon.SystemIcon();
	   	}
	   	
	    //create the .desktop file for the .AppImage
	   	AppDesktopFile.createDesktopFile();
		
		if(setCustomRunner.sb.isSelected()) {
			
			//picks the selected AppRun File to execute the application
	    AppCustomRunner.moveCustomAppRun();
			
		} else {
		
		//create the default AppRun file for the .AppImage
		AppRun.createAppRun();
		
		}
		
		if(setAppShortcut.sb.isSelected()) {
			
		AppShortcut.createAppShortcut();
		}
		
		if(setLauncherShortcut.sb.isSelected()) {
			
		AppSystemIntegration.CreateLauncherShortcut();
		}
		
		//create (name).AppImage in selected directory
		AppImageFileCreator.CreateAppImage();
	}
	
	//Starts the second JFrame
	
	public void AppImageInit() throws IOException {
	
	  mainFrame.AppImageWindow();
	
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
	    AppExec.setExe();
	   	
	    //moves the icon from selected folder into the .AppImage
	   	AppIcon.SetIcon();
	   	AppIcon.SystemIcon();
	   	
	    //create the .desktop file for the .AppImage
	   	AppDesktopFile.createDesktopFile();
		
		
		if(setAppShortcut.sb.isSelected()) {
		AppShortcut.createAppShortcut();

     	} 
		
		if(setCustomRunner.sb.isSelected()) {	
		AppCustomRunner.moveCustomAppRun();
		} else {

		AppRun.createAppRun();
		}
		
		if(setLauncherShortcut.isOn == 1) {
		AppSystemIntegration.CreateLauncherShortcut();
		}

		copyDirectory();
		
		AppImageFileCreator.CreateAppImage();
		
		
		
	}

	    	public static void copyDirectory() throws IOException {
	    		String OutputPath = AppLocation.AppPath.getText() + "/";
	    		String Name = setAppName.name.toString();
	    		String AppFolder = OutputPath + Name + ".AppDir/";
	    	    File sourceDirectory = new File(AppDirectory.AppRunDir.getText());
	    	    File destinationDirectory = new File(AppFolder+ "/usr/");
	    	    FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
	    	}
	    	
}
