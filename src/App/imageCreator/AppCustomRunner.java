package App.imageCreator;

import java.io.File;

import App.elements.options.setAppName;

public class AppCustomRunner {

    public void moveCustomAppRun(){
		String OutputPath = AppLocation.AppPath.getText() + "/";
		String Name = setAppName.name.toString();
		
		String AppFolder = OutputPath + Name + ".AppDir" + "/";
		File a = new File(selectCustomAppRun.AppRunDir.getText());
		
	a.renameTo(new File(AppFolder + "/" + a.getName()));
	
	new File(AppFolder + "/" + a.getName()).renameTo(new File(AppFolder + "/" + "AppRun"));

	
	}
	
}
