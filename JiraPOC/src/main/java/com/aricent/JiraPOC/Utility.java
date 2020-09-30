package com.aricent.JiraPOC;

import io.restassured.path.json.JsonPath;

public class Utility {
	
	public static JsonPath JSONParser(String response)
	{
		JsonPath json = new JsonPath(response);
		return json;
	}
	
}
