package restAssuredTest;


import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

//import io.restassured.response.Response;

public class RestAssuredStaticImport {
	
	@Test
	public void get2() {
		
		//Response response ;
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		//given().get("https://reqres.in/api/users?page=2").then().statusCode(201);
		
		given().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200)
		.body("data.id[0]", equalTo(7));
		
		given().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200)
		.body("data.email[1]", equalTo("lindsay.ferguson@reqres.in"));
		
		
		
		
		
	}

}
