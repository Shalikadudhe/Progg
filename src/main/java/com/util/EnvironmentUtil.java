package com.util;

public class EnvironmentUtil {
	// used for url userid pwd

	public String filePath ="/src/main/resources/Environment.properties";

/*	public static String Url;
 	public static String appUser1;
	public static String appUser_pwd;

	//static  {
	//	PropUtil prop = new PropUtil();
	//	String basedir = System.getProperty("user.dir");
	//	Url = prop.getValue(basedir + filePath, "app_url");
	//	appUser1 = prop.getValue(basedir + filePath, "app_User1");
    //		appUser_pwd = prop.getValue(basedir + filePath, "app_User_Pwd");
//	}
	
	*/
	
	   public String  getappUrl() {
		
		   PropUtil prop = new PropUtil();
			String basedir = System.getProperty("user.dir");
			 
		 return  prop.getValue(basedir + filePath, "app_url");
	}

	 
}
