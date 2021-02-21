package APIAutomation.DummyAPI;



import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetDummyAPI {
	@BeforeTest
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
	}
	@Test
	public void getUsersInfo()
	{
		Response response=given()
		.when()
		.get();
		
		//validating 
		System.out.println(response.prettyPeek());
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);	
	
	}
	
	@Test
	public void getUserInfo()
	{
		
		Cookies cookies=given()	
				.when()
				.get("/1")
				.getDetailedCookies();
		
		Response response=given()	
		.when()
		.get("/1");
		
	
		
		//validating 
		System.out.println(response.prettyPeek());
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);	
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		String contentType=response.contentType();
		System.out.println(contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		String cookie_value= cookies.getValue("__cfduid");
		System.out.println(cookie_value);
	}
	
	

}
