package restAssuredTest;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Tests_Get {
	
	@Test
	public void test_get1() {
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		
		
		
	}
	@Test
	public void test_get2() {
		
		ValidatableResponse status = given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data.first_name",hasItems("Michael","Tobias") );
		
		System.out.println(status);
		
		
		
	}

}
