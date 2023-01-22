package restAssuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssured_Get {
	
	@Test
	public void getTest() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.asString());
		System.out.println(response.getContentType());
		//System.out.println(response.getCookie(null));
		System.out.println(response.getSessionId());
		System.out.println(response.getTime());
		System.out.println(response.getClass());
		
		int statuscode = response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		
	}

}
