package App.imageCreator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import App.elements.options.setAppExe;
import App.elements.options.setAppName;

public class AppExec {
	
	AppExec() throws IOException{

		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Name = setAppName.name.toString();
	   	
	   	String AppFolder = OutputPath + Name + ".AppDir" + "/";
		String execPath = AppFolder + "usr/bin/" + setAppExe.execFullName;
		
		
		File dest = new File(execPath);
		File a = new File(setAppExe.output.getAbsolutePath());
		
	setExe(a, dest);
	
	}
	
	private static void setExe(File source, File dest) throws IOException {
	    FileUtils.copyFile(source, dest);
	}
	
}
