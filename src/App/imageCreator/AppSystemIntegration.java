package App.imageCreator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AppSystemIntegration {

	AppSystemIntegration() throws IOException{
		
    setIntegration(AppShortcut.DesktopFile, new File(System.getProperty("user.home") + "/.local/share/applications/" + AppShortcut.DesktopFile.getName()));
		
	}
	
	private static void setIntegration(File source, File dest) throws IOException {
	    FileUtils.copyFile(source, dest);
	
	}
	
	
}
