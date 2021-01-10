package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;

import Files.Payload;
import Files.ReUsableMethods;


public class API_Basics {

	public static void main(String[] args) {

		Add_Place_API();
	}

	public static void Add_Place_API()  {

		//Validate if Add Place API is working as expected.

		//Rest Assurad API works on below 3 principals.
		//Given - all input details
		//When - Submit API
		//Then - Validate the responce.

		RestAssured.baseURI="https://rahulshettyacademy.com";

		String Response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.Add_Place()).when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

		System.out.println(Response);
		JsonPath js = new JsonPath(Response);//Declare JsonPath class For parsing Json
		String PlaceId = js.getString("place_id");

		System.out.println("===================================================================");
		
		
		//Update Place

		String NewAddress = "1645 De Maisonneuve Ouest, Canada";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+PlaceId+"\",\r\n" + 
				"\"address\":\""+NewAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		System.out.println("===================================================================");
		
		
		
		//Get Place to verify above update request.
		
		String Get=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceId)
		.when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath Js1 = ReUsableMethods.rawToJson(Get);
		String ActualAddress = Js1.getString("address");
		System.out.println(ActualAddress);
		Assert.assertEquals(NewAddress, ActualAddress);
		 
	}

}
