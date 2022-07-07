package App.imageCreator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;

import App.elements.options.setAppName;
import App.elements.settings.AppImageSettings.RemoveAppDir;
import App.imageCreator.waitingWindow.WaitingWindow;
import App.settings.Console;

public class AppImageFileCreator {

	WaitingWindow WaitingWindow = new WaitingWindow();		
	public static String AppRunDir = System.getProperty("user.home") + "/.local/share/AppImage-Creator/" + "AppRun";
	
    public void CreateAppImage() throws IOException, InterruptedException { 	
    	
		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Name = setAppName.name.toString();
		String AppFolder = OutputPath + Name + ".AppDir" + "/";
		
		System.out.println(Name);
		System.out.println(AppFolder);
		
        //creates the script to execute AppImageBuilder
		File file = new File(AppRunDir);
		file.setExecutable(true);
		
    	PrintWriter writer = new PrintWriter(AppRunDir);
    	writer.println("#!/bin/sh");
		writer.println("HERE=\"$(dirname \"$(readlink -f \"${0}\")\")\"");
		writer.println("cd ${HERE}");
		writer.println("ARCH=x86_64 ./AppImageTool.AppImage " + AppFolder);
    	writer.close();
    	

		File AppRun = new File(AppRunDir);
		AppRun.setExecutable(true);
		
		//prints the script to execute AppImageBuilder
    	System.out.println(Console.script + "(ARCH=x86_64) ./AppImageTool.AppImage " + AppFolder);
        
    	//executes the script to execute AppImageBuilder
    	Thread thread = new Thread(){
    	    public void run(){
    	      try {
				AppImage();
			} catch (IOException e) {
				System.out.println(Console.error + "Could not create the appimage");
				e.printStackTrace();
			}
    	    }
    	  };

    	  thread.start();
    	  
    	  WaitingWindow.resetDialog();
    	  WaitingWindow.WaitingFrame();
    	  
    	  
    }
    
	//executes the script to execute AppImageBuilder
	@SuppressWarnings({ "deprecation"})
	public void AppImage() throws IOException {
		File exec = new File("exec");
		exec.setExecutable(true);
    	
    String command1 = "./exec";
	Process proc1 = Runtime.getRuntime().exec(command1);
    BufferedReader reader1 =  new BufferedReader(new InputStreamReader(proc1.getInputStream()));
    String line1 = "";
    while((line1 = reader1.readLine()) != null ) {
    	WaitingWindow.sc.setValue(WaitingWindow.sc.getValue());
    	WaitingWindow.ta.setText(WaitingWindow.ta.getText() + "\n" + line1);
        String finalline = AppLocation.AppPath.getText() + "/" + setAppName.name + ".AppDir " + "should be packaged as " + setAppName.name + "-x86_64.AppImage";
       
        String sqashfs = "Generating squashfs...";
         
        if(line1.equals(sqashfs)) {
        	WaitingWindow.feedbackLabel.setText(sqashfs);
        	
        }
        
        if(line1.startsWith("[")) {
        	
        	WaitingWindow.feedbackLabel.setText("Creating filesystem");
        } 
        
        if(line1.equals("Success")) {
        	
        	WaitingWindow.feedbackLabel.setText("Succes");
        	
        }
        
        if(line1.equals(finalline)) {
        	 
        	WaitingWindow.changePanel();
        	
        	System.out.println(Console.info + "(ARCH=x86_64) " + setAppName.name + ".AppImage created succesfully");
        	
            //moves the appimage to the wanted directory
            File AppImage = new File(System.getProperty("user.home") + "/.local/share/AppImage-Creator/" + setAppName.name.toString() +"-x86_64.AppImage");
            AppImage.renameTo(new File(AppLocation.AppPath.getText() + "/" + AppImage.getName()));
            
            if(RemoveAppDir.sb.isSelected()) {
            	FileUtils.deleteDirectory(new File(AppLocation.AppPath.getText() + "/" + setAppName.name.toString() + ".AppDir" + "/"));
            }
        	
        }
      } 
   }
}

    	    

   
