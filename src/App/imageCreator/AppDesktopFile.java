package App.imageCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import App.elements.options.SetAppCategories;
import App.elements.options.setAppExe;
import App.elements.options.setAppIcon;
import App.elements.options.setAppName;
import App.elements.options.setAppType;

public class AppDesktopFile {
	
	String execName;
	
	public AppDesktopFile() throws IOException{
		
		String Name = setAppName.name.toString();
		String Type = setAppType.typeSelector.getText();
		String Categories = SetAppCategories.categoriesSelector.getText();
		String ExecFullName = setAppExe.execFullName;
		String IconFullName = setAppIcon.IconName;
		String OutputPath = AppLocation.AppPath.getText() + "/";
		
		String AppFolder = OutputPath + Name + ".AppDir" + "/";
		File DesktopFile = new File(AppFolder, Name + ".desktop");
		BufferedWriter writer = new BufferedWriter(new FileWriter(DesktopFile));		
		
		String IconName = FilenameUtils.removeExtension(IconFullName);
		
			writer.write("[Desktop Entry]");
			writer.newLine();
			writer.write("Name=" + Name);
			writer.newLine();
			writer.write("Exec=" + ExecFullName);
			writer.newLine();
			writer.write("Icon=" + IconName);
			writer.newLine();
			writer.write("Type=" + Type);
			writer.newLine();
			writer.write("Categories=" + Categories);
			writer.close();
	}
}
	

