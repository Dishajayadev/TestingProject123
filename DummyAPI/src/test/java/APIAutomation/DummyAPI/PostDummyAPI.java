package APIAutomation.DummyAPI;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;



public class PostDummyAPI {
	@BeforeTest
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
	}
	@Test
	public void createEmployee()
	{
		Employee emp= new Employee();
		emp.setEmpName("Rajesh");
		emp.setJob("Developer");
		
				
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(emp)
		.post()
		.then()
		.statusCode(201);
		
		Cookies cookies=given()	
				.when()
				.body(emp)
				.post().getDetailedCookies();
		
		Response response=given()
				
		.contentType(ContentType.JSON)
		.when()
		.body(emp)
		.post();
		
		//validating
		System.out.println(response.prettyPeek());
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);	
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		String contentType=response.contentType();
		System.out.println(contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		String cookie_value= cookies.getValue("__cfduid");
		System.out.println(cookie_value);
				
		}

}
