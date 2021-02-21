package APIAutomation.DummyAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

public class PutDummyAPI {
	@BeforeTest
	public static void init ()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
	}
		@Test
		public void updateUser()
		{
			Employee emp= new Employee();
			emp.setEmpName("Disha");
			emp.setJob("Automation");
			
			given()
			.contentType(ContentType.JSON)
			.when()
			.body(emp)
			.put("/758")
			.then()
			.statusCode(200);
			
			Cookies cookies=given()	
					.when()
					.body(emp)
					.put("/758")
					.getDetailedCookies();
			
			Response response=given()
					
			.contentType(ContentType.JSON)
			.when()
			.body(emp)
			.put("/758");
			
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


