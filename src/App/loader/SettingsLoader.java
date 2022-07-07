package App.loader;

import App.elements.settings.AppSettings.CreateCreatorDShortcut;
import App.elements.settings.AppSettings.CreateCreatorLShortcut;
import App.saver.SettingsSaver;
import App.settings.Console;
import App.settings.theme.Theme;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SettingsLoader {
	public static boolean folderMode;
	public static boolean integrateMode;
	public static boolean desktopFileMode;
	public static boolean defaultLocationOn;
	public static boolean removeAppDirs = true;
	public static boolean desktopShorcut;
	public static boolean launcherShorcut;
	public static String defaultLocation;
	public static File file;

	static {
		file = new File(SettingsSaver.file);
	}

	@SuppressWarnings({ "unused", "resource" })
	public SettingsLoader() throws IOException {
		try {
			Scanner scanner = new Scanner(file);
			int var2 = 0;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				++var2;
				if (line.equals("Auto-folder-mode | true")) {
					folderMode = true;
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