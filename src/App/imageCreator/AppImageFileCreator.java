package App.imageCreator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;

import App.elements.options.setAppName;
import App.elements.settings.RemoveAppDir;
import App.settings.Console;

public class AppImageFileCreator {
	
	public static String AppRunDir = System.getProperty("user.home") + "/.local/share/AppImage-Creator/" + "AppRun";
			
    public AppImageFileCreator() throws IOException, InterruptedException { 	
    	
		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Name = setAppName.name.toString();
		String AppFolder = OutputPath + Name + ".AppDir" + "/";

        
		
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
        AppImage();
        
        
        
        //moves the appimage to the wanted directory
		String command2 = "mv " + System.getProperty("user.home") + "/.local/share/AppImage-Creator/" + setAppName.name.toString() +"-x86_64.AppImage " + AppLocation.AppPath.getText() + "/";
		Process proc2 = Runtime.getRuntime().exec(command2);
        BufferedReader reader2 =  new BufferedReader(new InputStreamReader(proc2.getInputStream()));
        String line2 = "";
        while((line2 = reader2.readLine()) != null ) {
            System.out.print(line2 + "\n");}
        proc2.waitFor();
        
        
        if(RemoveAppDir.IsOn == true) {

        	FileUtils.deleteDirectory(new File(AppLocation.AppPath.getText() + "/" + setAppName.name.toString() + ".AppDir" + "/"));
        	
        }
        
 
    
    }
    
	//executes the script to execute AppImageBuilder
	public void AppImage() throws IOException {
    	
		File exec = new File("exec");
		exec.setExecutable(true);
		
    String command1 = "./exec";
	Process proc1 = Runtime.getRuntime().exec(command1);
    BufferedReader reader1 =  new BufferedReader(new InputStreamReader(proc1.getInputStream()));
    String line1 = "";
    while((line1 = reader1.readLine()) != null ) {
        System.out.print(line1 + "\n");
    }
    }

}

    	    

   
