package App.loader;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import App.settings.Console;

public class firstOpening {

	public static File AppImage = new File(System.getProperty("user.home") + "/.local/share/AppImage-Creator/AppImageTool.AppImage");
	
	public firstOpening() {
		
		try {	
			copyAppImageTool(new File("appimagetool-x86_64.AppImage"), AppImage);
		} catch (IOException e) {
			System.out.println(Console.error + "Could not copy AppImageTool");
			e.printStackTrace();
		}
		
	}
	
	private static void copyAppImageTool(File source, File dest) throws IOException {
	    FileUtils.copyFile(source, dest);
	    
	    AppImage.setExecutable(true);
	}
}
