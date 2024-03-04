package com.utility;

public class Environment {
	
	public String getAppUrl() {
		
		PropertiesUtility pu=new PropertiesUtility();
		String fpath="/src/main/resources/Environment.properties";
		String baseDir=System.getProperty("user.dir"); 
		return pu.getValue(baseDir+fpath, "get_appUrl");
		

	}

}
