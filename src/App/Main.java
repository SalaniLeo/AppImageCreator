package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import App.frame.mainFrame.mainFrame;
import App.imageCreator.AppImageFileCreator;
import App.loader.SettingsLoader;
import App.loader.firstOpening;
import App.settings.Console;

public class Main {
	
	public static double version = 1.0;
	
	public static void main(String[] args) throws IOException, InterruptedException {	
		
		System.out.println(Console.appVersion + version);

		System.out.println(Console.sysArch + System.getProperty("os.arch"));
		distroInfo();
		
		File file = new File(firstOpening.AppImage.getAbsolutePath());
		if(!file.exists()) {
			new firstOpening();
		}
		
		if(SettingsLoader.file.exists()) { 
		    new SettingsLoader();
		}
		
		new mainFrame();
		
        }
	
	static void distroInfo(){
		
		String[] cmd = {"/bin/sh", "-c", "cat /etc/*-release" };
		try {
		    Process p = Runtime.getRuntime().exec(cmd);
		    BufferedReader bri = new BufferedReader(new InputStreamReader(
		            p.getInputStream()));
		    String line = "";
		    while ((line = bri.readLine()) != null) {
		    	if(line.contains("DISTRIB_DESCRIPTION=")) {
		    		int max = line.length();
		        System.out.println(Console.distroName + line.substring(20,max).replaceAll("\"", ""));
		    	}
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
}
