package restAssuredTest;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Examples_JSON_Local_Server {
	
	//JSON Server installation : https://github.com/typicode/json-server 

	// C:\Windows\System32>json-server --watch db.json
	@Test(priority = 1)
	public void json_get() {

		baseURI = "http://localhost:3000/";

		// given().get("/users").then().statusCode(200).log().all();
		try {

			given().params("name", "Automation").get("/subjects").then().statusCode(200).log().body();
		} catch (Exception e) {
			System.out.println("errror occured");
			//e.printStackTrace();
		}
	}

	@Test
	public void json_post() {

		baseURI = "http://localhost:3000/";

		JSONObject request = new JSONObject();

		request.put("firstname", "Sidh");
		request.put("lastname", "Mad");
		request.put("subjectid", 5);
		request.put("id", 5);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().post("/users")
				.then().statusCode(201).log().body();

	}

	@Test
	public void json_patch() {

		baseURI = "http://localhost:3000/";

		JSONObject request = new JSONObject();

		request.put("firstname", "Nikita");

		request.put("lastname", "Madgaonkar");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().patch("/users/5")
				.then().statusCode(200).log().body();

	}

	@Test
	public void json_put() {

		baseURI = "http://localhost:3000/";

		JSONObject request = new JSONObject();

		request.put("firstname", "Nikki");
		request.put("lastname", "Madgaonkar");
		request.put("subjectid", 3);
		request.put("id", 3);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().put("/users/3")
				.then().statusCode(200).log().body();

	}

	@Test
	public void json_delete() {
		baseURI = "http://localhost:3000/";

		when().delete("/users/4").then().statusCode(200).log().all();

	}

}
