package App.imageCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import App.elements.options.SetAppCategories;
import App.elements.options.setAppExe;
import App.elements.options.setAppName;
import App.elements.options.setAppShortcut;
import App.elements.options.setAppType;

public class AppShortcut {

	setAppExe setAppExe = new setAppExe();
	public static File DesktopFile;
	AppIcon AppIcon = new AppIcon();
	
	public void createAppShortcut() throws IOException{
		
		@SuppressWarnings("unused")
		    setAppShortcut shortcut = new setAppShortcut();
			
		    DesktopFile = new File(System.getProperty("user.home") + "/Desktop", setAppName.name.toString() + ".desktop");
			BufferedWriter writer = new BufferedWriter(new FileWriter(DesktopFile));
			
				writer.write("[Desktop Entry]");
				writer.newLine();
				writer.write("Name=" + setAppName.name.toString());
				writer.newLine();
				writer.write("Icon=" + AppIcon.sysIcon);
				writer.newLine();
				writer.write("Exec=" + AppLocation.AppPath.getText() + "/" + setAppName.name.toString() +"-x86_64.AppImage ");
				writer.newLine();
				writer.write("Type=" + setAppType.typeSelector.getText());
				writer.newLine();
				writer.write("Categories=" + SetAppCategories.categoriesSelector.getText());
				writer.close();

	}
	
}
