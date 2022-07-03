package App.saver;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

import App.elements.settings.AppImageSettings.AutoDesktopFile;
import App.elements.settings.AppImageSettings.AutoEnableFolderMode;
import App.elements.settings.AppImageSettings.AutoIntegrateInSystem;
import App.elements.settings.AppImageSettings.DefaultAppLocation;
import App.elements.settings.AppImageSettings.RemoveAppDir;
import App.elements.settings.AppSettings.CreateCreatorDShortcut;
import App.elements.settings.AppSettings.CreateCreatorLShortcut;

public class SettingsSaver implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static String file = System.getProperty("user.home") + "/.local/share/AppImage-Creator/settings.conf";
	
	public SettingsSaver() throws Exception {
		
		new File(System.getProperty("user.home") + "/.local/share/AppImage-Creator/").mkdirs();
		File file = new File(System.getProperty("user.home") + "/.local/share/AppImage-Creator/settings.conf");
		FileWriter writer = new FileWriter(file);
		
		writer.write("////Creator Settings");
		
		writer.write(System.lineSeparator());
		writer.write(System.lineSeparator());
		if (AutoEnableFolderMode.sb.isSelected()) {
			writer.write("Auto-folder-mode | true");
		} else {
			writer.write("Auto-folder-mode | false");
		}

		writer.write(System.lineSeparator());
		if (AutoIntegrateInSystem.sb.isSelected()) {
			writer.write("Auto-integrate-mode | true");
		} else {
			writer.write("Auto-integrate-mode | false");
		}

		writer.write(System.lineSeparator());
		if (AutoDesktopFile.sb.isSelected()) {
			writer.write("Auto-desktop-shortcut | true");
		} else {
			writer.write("Auto-desktop-shortcut | false");
		}

		writer.write(System.lineSeparator());
		if (RemoveAppDir.sb.isSelected()) {
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
		
		writer.write(System.lineSeparator());
		
		writer.write(System.lineSeparator());
		
		writer.write("////App settings ");
		
		writer.write(System.lineSeparator());
		if (CreateCreatorDShortcut.sb.isSelected()) {
			writer.write("Desktop-shortcut | true");
		} else {
			writer.write("Desktop-shortcut | false");
		}
		
		writer.write(System.lineSeparator());
		
		if (CreateCreatorLShortcut.sb.isSelected()) {
			writer.write("Launcher-shortcut | true");
		} else {
			writer.write("Launcher-shortcut | false");
		}

		writer.close();
		
	}
}