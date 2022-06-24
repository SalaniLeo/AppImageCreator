package App.imageCreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import App.elements.options.setAppExe;
import App.elements.options.setAppName;

public class AppRun {

	public AppRun() throws IOException, InterruptedException{
		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Name = setAppName.name.toString();
		
		String AppFolder = OutputPath + Name + ".AppDir" + "/";
		File AppRunFile = new File(AppFolder + "AppRun");
		BufferedWriter writer = new BufferedWriter(new FileWriter(AppRunFile));
		
		writer.write("#!/bin/sh");
		writer.newLine();
		writer.write("HERE=\"$(dirname \"$(readlink -f \"${0}\")\")\"");
		writer.newLine();
		writer.write("EXEC=\"${HERE}/usr/bin/" + setAppExe.execFullName + "\"");
		writer.newLine();
		writer.write("exec \"${EXEC}\"");
		writer.close();
		
        String command = "chmod +x " + AppFolder + "AppRun";
        Process proc = Runtime.getRuntime().exec(command);
        new BufferedReader(new InputStreamReader(proc.getInputStream()));
		
		
		}
	
	
	}		

		

	
