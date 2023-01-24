package restAssuredTest;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

//"https://demoqa.com/BookStore/v1/Books"

public class getBookDetails {
	
	@Test
	public void getBookDetailsfromweb() {
		
	ValidatableResponse response=
	given().contentType(ContentType.JSON).accept(ContentType.JSON)
	.when().get("https://demoqa.com/BookStore/v1/Books").
	then().statusCode(200).log().body().body("books[0].title", equalTo("Git Pocket Guide"));
	
	response.statusCode(200);

		
	}
	@Test
	public void GetBooksDetails() { 
		// Specify the base URL to the RESTful web service 
		baseURI = "https://demoqa.com/BookStore/v1/Books"; 
		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = given(); 
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		Response response = httpRequest.request(Method.GET, "");
		// Print the status and message body of the response received from the server 
		System.out.println("Status received => " + response.getStatusLine()); 
		System.out.println("Response=>" + response.prettyPrint());
	    	
	}

}
