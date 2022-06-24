package App.imageCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import App.elements.options.SetAppCategories;
import App.elements.options.setAppExe;
import App.elements.options.setAppName;
import App.elements.options.setAppType;

public class AppShortcut {

	String execName;
	setAppExe setAppExe = new setAppExe();
	public static File DesktopFile;
	
	AppShortcut() throws IOException{
		
		@SuppressWarnings("unused")
		App.elements.options.setAppShortcut shortcut = new App.elements.options.setAppShortcut();
			String Name = setAppName.name.toString();
			String Type = setAppType.typeSelector.getText();
			String Categories = SetAppCategories.categoriesSelector.getText();

			
			DesktopFile = new File(System.getProperty("user.home") + "/Desktop", Name + ".desktop");
			BufferedWriter writer = new BufferedWriter(new FileWriter(DesktopFile));
			
				writer.write("[Desktop Entry]");
				writer.newLine();
				writer.write("Name=" + Name);
				writer.newLine();
				writer.write("Icon=" + AppIcon.sysIcon);
				writer.newLine();
				writer.write("Exec=" + AppLocation.AppPath.getText() + "/" + setAppName.name.toString() +"-x86_64.AppImage ");
				writer.newLine();
				writer.write("Type=" + Type);
				writer.newLine();
				writer.write("Categories=" + Categories);
				writer.close();

	}
	
}
