package App.imageCreator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import App.elements.options.setAppExe;
import App.elements.options.setAppName;

public class AppExec {
	
	public void setExe() throws IOException  {
		File dest = new File(AppLocation.AppPath.getText() + "/" +  setAppName.name.toString() + ".AppDir" + "/" + "usr/bin/" + setAppExe.execFullName);
		File a = new File(setAppExe.output.getAbsolutePath());
	    FileUtils.copyFile(a, dest);
	}
	
}
