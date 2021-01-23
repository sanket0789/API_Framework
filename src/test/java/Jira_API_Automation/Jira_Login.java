package Jira_API_Automation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import API_Payload_Files.ReUsableMethods;


public class Jira_Login {

	@Test
	public static String auth() 
	
	{
		RestAssured.baseURI="http://localhost:8080";
		
		String res = given().header("Content-Type", "application/json")
		.body("{ \"username\": \"himali\", \"password\": \"Admin@123\" }")
		
		.when().post("/rest/auth/1/session")
		
		
		//Verify response
		.then().log().all().assertThat().statusCode(200)
		
		//Extract Response and store it as String
		.extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(res);
		
		System.out.println("\n"+ "======================================================");
		
		
		//Finding sub node to print session value.
		String value = js.getString("session.value");
		
		System.out.println("The Session ID is : " + value);
		
		System.out.println("\n"+ "======================================================");
		return value;
		
		
		
	}

}
