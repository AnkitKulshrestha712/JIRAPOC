package com.aricent.JiraPOC;

import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClass {

	/* Initial setup */
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = new DataProvider().getBaseURL();
	}
	
	public DataProvider getDataProvider() {
		return new DataProvider();
	}
}
