package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import App.elements.settings.AppImageSettings.AutoDesktopFile;
import App.elements.settings.AppImageSettings.AutoEnableFolderMode;
import App.elements.settings.AppImageSettings.AutoIntegrateInSystem;
import App.elements.settings.AppImageSettings.DefaultAppLocation;
import App.elements.settings.AppImageSettings.RemoveAppDir;
import App.settings.theme.Theme;

public class Settings implements Serializable {
	
	
	public static boolean folderMode;
	public static boolean integrateMode;
	public static boolean desktopFileMode;
	public static boolean defaultLocationOn;
	public static boolean removeAppDirs = true;
	public static boolean desktopShorcut;
	public static boolean launcherShorcut;
	public static String defaultLocation;
	private static final long serialVersionUID = 1L;
	public static String filePath = System.getProperty("user.home") + "/.local/share/AppImage-Creator/settings.conf";
	static File file = new File(filePath);
	
	public void saveSettings() throws Exception {
		
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

		writer.close();
		
	}
		
		public void loadSettings() throws IOException {
			try {
				System.out.println("settings");

				Scanner scanner = new Scanner(file);
				int var2 = 0;
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					++var2;
					if (line.equals("Auto-folder-mode | true")) {
						folderMode = true;
						System.out.println(folderMode);
					}

					if (line.equals("Auto-integrate-mode | true")) {
						integrateMode = true;
					}

					if (line.equals("Application-dark-mode | true")) {
						Theme.darkTheme = true;
					}

					if (line.equals("Auto-desktop-shortcut | true")) {
						desktopFileMode = true;
					}

					if (line.equals("Remove-AppDirs | true")) {
						removeAppDirs = true;
					}

					if (line.equals("Remove-AppDirs | false")) {
						removeAppDirs = false;
					}

					URI a = file.toURI();
					if (((String) Files.readAllLines(Paths.get(a)).get(6)).equals("Default-AppImages-location | null")) {
					} else {
						defaultLocation = (String) Files.readAllLines(Paths.get(a)).get(7);
						defaultLocationOn = true;
					}
				
					if (line.equals("Desktop-shortcut | true")) {
						desktopShorcut = true;
					}
					
					if (line.equals("Launcher-shortcut | true")) {
						launcherShorcut = true;
					}
					
				}
			} catch (FileNotFoundException var5) {
				System.out.println("");
			}

		}
	}
