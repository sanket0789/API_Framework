package API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Get_Payload_From_External_File {
	
	@Test
	public void Add_Place() throws IOException 
	{
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
	//When getting Json from file, First step is to convert Json Into String.
	
			//Given - all input details
			String Response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
			.body(new String(java.nio.file.Files.readAllBytes(Paths.get("C:\\Users\\Kumar Joshi\\Desktop\\Add_Place.json"))))
			//When - Submit API
			.when().post("/maps/api/place/add/json")

			//Then - Validate the response.
			.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
			.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();


	System.out.println("===================================================================");
	}

}
