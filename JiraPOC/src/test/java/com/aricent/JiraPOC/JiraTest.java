package com.aricent.JiraPOC;

import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aricent.pojo.AuthenticationRequest;
import com.aricent.pojo.Issuetype;
import com.aricent.pojo.Project;
import com.aricent.pojo.Request;
import com.aricent.pojo.Requestfields;
import com.aricent.pojo.Response;

public class JiraTest extends BaseClass {

	public SessionFilter session;
	public static int jiraId;

	@Test
	public void cookieAuthentication() {
		session = new SessionFilter();

		AuthenticationRequest req = new AuthenticationRequest();
		req.setUsername(getDataProvider().getUserName());
		req.setPassword(getDataProvider().getPassword());

		String response = given().header("Content-Type", "application/json").
				          body(req).log().all().
				          filter(session).when().
				          post(getDataProvider().getAuthenticationURL()).
				          then().extract().response().asString();

		System.out.println("Response " + response);
	}

	@Test(dependsOnMethods = "cookieAuthentication",
		  dataProvider = "createJiraData")
	public void createIssue(String type, String key, String summary, String desc) {

		Request req = new Request();
		Project proj = new Project();
		Requestfields fields = new Requestfields();
		Issuetype issuetype = new Issuetype();
		issuetype.setName(type);
		proj.setKey(key);
		fields.setSummary(summary);
		fields.setDescription(desc);
		fields.setIssuetype(issuetype);
		fields.setProject(proj);

		req.setFields(fields);

		String response = given().log().all().header("Content-Type", "application/json").
						  body(req).filter(session).
						  when().post(getDataProvider().
						  getCreateJiraURL()).then().log().
						  all().assertThat().statusCode(201).
						  extract().response().asString();

		JsonPath js = Utility.JSONParser(response);

		jiraId = js.getInt("id");
		System.out.println("Jira Id " + jiraId);
	}

	
	/*
	 * @Test(dependsOnMethods = "cookieAuthentication") public void deleteIssue() {
	 * 
	 * given().log().all().pathParam("id",
	 * jiraId).header("Content-Type","application/json"). filter(session).
	 * when().delete(getDataProvider().getDeleteURL()).then().log().all().assertThat
	 * (). statusCode(204);
	 * 
	 * }
	 */
	 

	@Test(dependsOnMethods = "createIssue")
	public void getIssueDetails() {

		Response res = given().filter(session).pathParam("key", jiraId).
					   queryParam("fields", "comment").log().
					   all().when().get(getDataProvider().getJiraURL()).
					   then().log().all().extract().as(Response.class);

		System.out.println(res.getId());
		System.out.println(res.getKey());

	}
	
	@DataProvider
	public Object[][] createJiraData(){
		return new Object[][] {{"Bug","TEST","ABC","YXZ"}};
	}
}
