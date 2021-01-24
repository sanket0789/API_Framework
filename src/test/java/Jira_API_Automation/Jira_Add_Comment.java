package Jira_API_Automation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import API_Payload_Files.Payload;
import API_Payload_Files.ReUsableMethods;


public class Jira_Add_Comment extends Jira_Login {

	@Test
	public static void Insert_comment () 
	{
		
		String Session_id = auth();
		
		//Define URL for the API
		RestAssured.baseURI="http://localhost:8080";
		
		String Comment = given().pathParam("id", "10101").header("Content-Type","application/json").header("Cookie","JSESSIONID="+Session_id+"")
		
		//Get body data from payload class
		.body(Payload.Add_Issue_Comment())
	
		//This is the endpoint of the API
		.when().post("/rest/api/2/issue/{id}/comment")
		
		//Verifying API response and status code.
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		//Converting String into Json
		 JsonPath js= ReUsableMethods.rawToJson(Comment);
		   
		  String Com=js.get("id");
		   System.out.println(Com);
		
	}
	
}
