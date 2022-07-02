package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

public class DriverUtils extends BaseClass {
	// nelow method will take ss and return us path of file where we hv stored
	// ss.
	public static String getScreenShot(String testcasename ) {
		TakesScreenshot ts = (TakesScreenshot)driver;

		File src = ts.getScreenshotAs(OutputType.FILE);// this will return us o/p in file
		// need to create path to save our fail case's ss
		String path = System.getProperty("user.dir")+"/screenshot/"+testcasename+".jpg";
		File dest = new File(path);
		// to copy "screenshot" into new path "failSS"
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}
}
