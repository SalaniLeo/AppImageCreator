package App.saver;

import App.elements.settings.AutoDesktopFile;
import App.elements.settings.AutoEnableFolderMode;
import App.elements.settings.AutoIntegrateInSystem;
import App.elements.settings.DefaultAppLocation;
import App.elements.settings.RemoveAppDir;
import App.settings.Console;
import App.settings.theme.Theme;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

public class SettingsSaver implements Serializable {
	
	public static String file = System.getProperty("user.home") + "/.local/share/AppImage-Creator/settings.conf";
	
	public SettingsSaver() throws Exception {
		
		new File(System.getProperty("user.home") + "/.local/share/AppImage-Creator/").mkdirs();
		File file = new File(System.getProperty("user.home") + "/.local/share/AppImage-Creator/settings.conf");
		FileWriter writer = new FileWriter(file);
		if (AutoEnableFolderMode.IsOn == 1) {
			writer.write("Auto-folder-mode | true");
		} else {
			writer.write("Auto-folder-mode | false");
		}

		writer.write(System.lineSeparator());
		if (AutoIntegrateInSystem.IsOn == 1) {
			writer.write("Auto-integrate-mode | true");
		} else {
			writer.write("Auto-integrate-mode | false");
		}

		writer.write(System.lineSeparator());
		if (Theme.darkTheme) {
			writer.write("Application-dark-mode | true");
		} else {
			writer.write("Application-dark-mode | false");
			writer.write(System.lineSeparator());
		}

		writer.write(System.lineSeparator());
		if (AutoDesktopFile.IsOn) {
			writer.write("Auto-desktop-shortcut | true");
		} else {
			writer.write("Auto-desktop-shortcut | false");
		}

		writer.write(System.lineSeparator());
		if (RemoveAppDir.IsOn) {
			writer.write("Remove-AppDirs | true");
		} else {
			writer.write("Remove-AppDirs | false");
		}

		writer.write(System.lineSeparator());
		if (DefaultAppLocation.LocationSelector.getText().isEmpty()) {
			writer.write("Default-AppImages-location | null");
		} else {
			writer.write("Default-AppImages-location { ");
			writer.write(System.lineSeparator());
			writer.write(DefaultAppLocation.LocationSelector.getText());
			writer.write(System.lineSeparator());
			writer.write("}");
		}

		writer.close();
		
	}
}