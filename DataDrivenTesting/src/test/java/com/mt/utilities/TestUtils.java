package com.mt.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mt.base.TestBase;

public class TestUtils extends TestBase {
	
	public static String screenShotName;
	
	public static void captureScreenshot() throws IOException {
		Date d=new Date();
		File scrFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenShotName=d.toString().replace(" ", "-").replace(":", "-") + ".jpg";
		
		FileUtils.copyFile(scrFile, new File( System.getProperty("user.dir")  + "\\target\\surefire-reports\\html\\" + screenShotName));
		
	}
}
