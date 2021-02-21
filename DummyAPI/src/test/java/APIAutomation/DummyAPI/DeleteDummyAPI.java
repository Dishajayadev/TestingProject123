package APIAutomation.DummyAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteDummyAPI {
	@BeforeTest
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
	}
	@Test
	public void deleteUser()
	{
		given()
		.when()
		.delete("/758")
		.then()
		.statusCode(204);
		
		Response response= given()
		.when()
		.delete("/758");
		String contentType= response.contentType();
		System.out.println(contentType);
		int status_code= response.statusCode();
		System.out.println(status_code);
		Assert.assertEquals(status_code, 204);
		
		
	}

}
