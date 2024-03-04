package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	public String getValue(String filePath, String key) {

		FileInputStream fis = null;
		try {
			fis= new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			System.err.println("file is not found "+filePath);
		}
		
		Properties prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {

		System.err.println("Unable to load properties file "+filePath);
		
		
		}
		
		   return prop.getProperty(key);
	}
	
	/*
	 * This method can be used on OR.properties file only.
	 * @para key for which we want the locator
	 * @return the loactor value in the form of {@code String}
	 */
	public String getLocator(String key) {
		
		String fpath="/src/main/resources/OR.properties";
		String baseDir=System.getProperty("user.dir"); //cwd----current working directory
		getValue(baseDir+fpath, key);
		return key;

	}

	
}
