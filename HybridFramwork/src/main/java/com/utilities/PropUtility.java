package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropUtility {
public static Properties properties;
public static FileInputStream fileInputStream;
public static String readProp(String browser) throws Exception{
	properties = new Properties();
	fileInputStream  = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
	properties.load(fileInputStream);
	return properties.getProperty(browser);
}

}
