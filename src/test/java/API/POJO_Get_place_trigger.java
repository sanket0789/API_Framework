package API;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import POJO_Class.Get_Place_API;
import POJO_Class.location;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class POJO_Get_place_trigger {

	@Test
	public static void pojo_get_place() 
	
	{
	RestAssured.baseURI="https://rahulshettyacademy.com";

	Get_Place_API Get=
			
			given().queryParam("key", "qaclick123").queryParam("place_id", "c7f4777bb6e7f6acc380e9bb53fb0b89").expect().defaultParser(Parser.JSON)
			.when().get("maps/api/place/get/json").as(Get_Place_API.class);
	
	
	System.out.println("===================================================================");
	
			System.out.println(Get.getAccuracy());
			System.out.println(Get.getName());
			System.out.println(Get.getPhone_number());
			System.out.println(Get.getAddress());
			System.out.println(Get.getTypes());
			System.out.println(Get.getWebsite());
			System.out.println(Get.getLanguage());
			
			System.out.println("The Latitude is : " + Get.getLocation().getLatitude());
			System.out.println("The Longtitude is : " + Get.getLocation().getLongitude());


	System.out.println("===================================================================");
	
	}
	
}
