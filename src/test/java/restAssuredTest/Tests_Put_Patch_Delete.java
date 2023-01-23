package restAssuredTest;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
//import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Tests_Put_Patch_Delete {
	@Test
	public void test_put() {

		JSONObject request = new JSONObject();

		request.put("name", "Siddhesh Madgaonkar");

		request.put("job", "Software Tester");

		System.out.println(request);

		given().header("Content-type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log()
				.body();
	}
	
	@Test
	public void test_patch() {
		
		JSONObject request = new JSONObject();

		request.put("name", "Siddhesh Madgaonkar");

		request.put("job", "Software Tester");
		
		given().header("Content-type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log()
		.body();
	}
	
	@Test
	public void test_delete() {
		
		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
		
		
	}

}
