package App.imageCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import App.elements.options.setAppExe;
import App.elements.options.setAppName;

public class AppRun {

	public void createAppRun() throws IOException{

		File AppRunFile = new File(AppLocation.AppPath.getText() + "/" + setAppName.name.toString() + ".AppDir" + "/" + "AppRun");
		BufferedWriter writer = new BufferedWriter(new FileWriter(AppRunFile));
		
		writer.write("#!/bin/sh");
		writer.newLine();
		writer.write("HERE=\"$(dirname \"$(readlink -f \"${0}\")\")\"");
		writer.newLine();
		writer.write("EXEC=\"${HERE}/usr/bin/" + setAppExe.execFullName + "\"");
		writer.newLine();
		writer.write("exec \"${EXEC}\"");
		writer.close();
		
		setExecutable();
		
	}
	
	private void setExecutable() {
		
		File AppRunFile = new File(AppLocation.AppPath.getText() + "/" + setAppName.name.toString() + ".AppDir" + "/" + "AppRun");
		AppRunFile.setExecutable(true);
		
	}
	
	}		

		

	
