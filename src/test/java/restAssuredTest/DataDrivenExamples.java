package restAssuredTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples {

	@DataProvider(name = "dataforpost")
	public Object[][] DataForPost() {

		Object[][] data = new Object[2][3];

		data[0][0] = "Thor";
		data[0][1] = "Odinson";
		data[0][2] = 1;

		data[1][0] = "Steve";
		data[1][1] = "Rogers";
		data[1][2] = 3;

		return data;
	}

	@DataProvider(name = "dataforpost2")
	public Object[][] dataForPost2() {

		return new Object[][] 
				{

					{ "Natasha", "Maxximof", 2 }, 
					{ "Peter", "Parker", 1 } 
				};
	}

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
}
