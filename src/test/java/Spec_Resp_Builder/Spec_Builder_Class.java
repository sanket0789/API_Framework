package Spec_Resp_Builder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import Serializations.Add_Place_Serialization;
import Serializations.Location_Serialize;

public class Spec_Builder_Class {

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
		
		//Request Spec Builder
				RequestSpecification Request = new RequestSpecBuilder()
						.setBaseUri("https://rahulshettyacademy.com")
						.addQueryParam("key", "qaclick123")
						.addQueryParam("place_id", PlaceId)
						.setContentType(ContentType.JSON)
						.build();
				
		// Response Spec Builder
				ResponseSpecification Response = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
						
		
		RequestSpecification get =given().spec(Request) ;
		
		
		String resp = get.when().get("maps/api/place/get/json").then().assertThat().spec(Response).log().all()
		.extract().response().asString();

		System.out.println("Here is the result of GET request : " + get);
		
		
		
		
		
		
	}

}
