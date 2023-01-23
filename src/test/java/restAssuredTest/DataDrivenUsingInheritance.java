package restAssuredTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenUsingInheritance extends DataForTests {
	
	@Test(dataProvider = "dataforpost")
	public void json_post_using_dataprovider(String firstname, String lastname, int subjectid) {

		baseURI = "http://localhost:3000/";

		JSONObject request = new JSONObject();

		request.put("firstname", firstname);
		request.put("lastname", lastname);
		request.put("subjectid", subjectid);
		// request.put("id", 6);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().post("/users")
				.then().statusCode(201).log().body();

	}
	@Test(dataProvider = "dataforpost2",priority = 2)
	public void json_post(String firstname,String lastname,int subjectid) {
		
		baseURI="http://localhost:3000/";
		JSONObject request = new JSONObject();
		
		request.put("firstname", firstname);
		request.put("lastname", lastname);
		request.put("subjectid", subjectid);

		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().post("/users")
		.then().statusCode(201).log().body();
		
	}
	
	//@Test(dataProvider = "datafordelete",priority = 3)
	public void json_delete_using_dataprovider(int UserID) {
		baseURI="http://localhost:3000/";
		when().delete("/users/"+UserID).then().statusCode(200).log().body();
	}
	
	@Parameters({"userID"})
	@Test
	public void delete_using_testng_parameters(int UserID) {
		System.out.println("Value for userid from TestNG.xml is: "+UserID);
		baseURI="http://localhost:3000/";
		when().delete("/users/"+UserID).then().statusCode(200).log().body();
		
	}

}
