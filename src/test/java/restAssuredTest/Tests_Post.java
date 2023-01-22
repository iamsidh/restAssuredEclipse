package restAssuredTest;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Tests_Post {
	
	@Test
	public void post_test() {
		//using Map
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Siddhesh");
		map.put("job", "Software Tester");
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		
		System.out.println(request);
		
		
	
	}
	
	@Test
	public void post_test2() {
		//using json request direct
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Siddhesh");
		
		request.put("job", "Software Tester");
		
		System.out.println(request);
		
		given().header("Content-type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().body();
		
	}

}
