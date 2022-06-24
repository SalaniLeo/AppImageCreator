package App.loader;

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
	public static String defaultLocation;
	public static File file;

	static {
		file = new File(SettingsSaver.file);
	}

	public SettingsLoader() throws IOException {
		try {
			Scanner scanner = new Scanner(file);
			int var2 = 0;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				++var2;
				if (line.equals("Auto-folder-mode | true")) {
					System.out.println(Console.settings + "Auto Folder Mode = true");
					folderMode = true;
				}

				if (line.equals("Auto-integrate-mode | true")) {
					System.out.println(Console.settings + "Auto Integrate Mode = true");
					integrateMode = true;
				}

				if (line.equals("Application-dark-mode | true")) {
					System.out.println(Console.settings + "Application Theme = Dark");
					Theme.darkTheme = true;
				}

				if (line.equals("Auto-desktop-shortcut | true")) {
					System.out.println(Console.settings + "Auto Desktop Shortcut = true");
					desktopFileMode = true;
				}

				if (line.equals("Remove-AppDirs | true")) {
					System.out.println(Console.settings + "Remove AppDirs = true");
					removeAppDirs = true;
				}

				if (line.equals("Remove-AppDirs | false")) {
					System.out.println(Console.settings + "Remove AppDirs = true");
					removeAppDirs = false;
				}

				URI a = file.toURI();
				if (((String) Files.readAllLines(Paths.get(a)).get(5)).equals("Default-AppImages-location | null")) {
				} else {
					defaultLocation = (String) Files.readAllLines(Paths.get(a)).get(6);
					defaultLocationOn = true;
				}
			}
		} catch (FileNotFoundException var5) {
			System.out.println("");
		}

	}
}