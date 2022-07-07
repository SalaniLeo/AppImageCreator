package App.imageCreator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AppSystemIntegration {
	
	public void CreateLauncherShortcut() throws IOException {
	    FileUtils.copyFile(AppShortcut.DesktopFile, new File(System.getProperty("user.home") + "/.local/share/applications/" + AppShortcut.DesktopFile.getName()));
	
	}
	
	
}
