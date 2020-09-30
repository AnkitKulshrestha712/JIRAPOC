package com.aricent.JiraPOC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProvider {

	public static Properties prop;
	
	public DataProvider() {
		super();
		
		prop = new Properties();
		
		try {
			prop.load(new FileInputStream("C:\\Users\\kulsh\\eclipse-workspace\\JiraPOC\\config\\Config.properties"));
		} catch(IOException e) {
			System.out.println("Unable to read/load config file");
		}
	}

	public String getJiraURL() {
		return prop.getProperty("getJiraAPI");
	}
	
	public String getCreateJiraURL() {
		return prop.getProperty("createJiraAPI");
	}
	
	public String getAuthenticationURL() {
		return prop.getProperty("authenticationAPI");
	}
	
	public String getUserName() {
		return prop.getProperty("username");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getBaseURL() {
		return prop.getProperty("baseURI");
	}
	
	public String getDeleteURL() {
		return prop.getProperty("deleteJiraAPI");
	}
}
