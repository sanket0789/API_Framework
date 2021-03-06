package Serializations;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Serialize_Main_Class {

	@Test
	public static void Serialize_Method() {

		// For Serialization we will have to feed all data to our main class setter
		// methods.
		// Creating object of the POJO Class
		Add_Place_Serialization obj = new Add_Place_Serialization();

		Location_Serialize L = new Location_Serialize();
		L.setLat(-38.383494);
		L.setLng(33.427362);

		obj.setLocation(L);

		obj.setAccuracy(11);
		obj.setName("Sanket Joshi");
		obj.setPhone_number("+1 438-866-3999");
		obj.setAddress("1975 blvd maisonneuve O");

		// Define a ArrayList and store data inside Array
		List<String> mylist = new ArrayList<String>();
		mylist.add("Functional");
		mylist.add("Non-Functional");
		obj.setTypes(mylist);

		obj.setWebsite("Thesprintx.com");
		obj.setLanguage("English");

		// API Serialization (POST METHOD)

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String res = given().log().all().queryParam("key", "qaclick123").body(obj).when()
				.post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();

		// GET ABOVE ADDED PLACE RECORD
		JsonPath Js = new JsonPath(res);

		String PlaceId = Js.getString("place_id");
		
		String get =given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceId)
		.when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response().asString();

		System.out.println("Here is the result of GET request : " + get);
	}

}
