package Jira_API_Automation;

import org.testng.annotations.Test;

import API_Payload_Files.Payload;
import API_Payload_Files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class Add_Bug extends Jira_Login{
	
	
	
	@Test
	public static void Create_Issue()
	{
		
		String Session_id = auth();
		
		
		//API URL
		RestAssured.baseURI="http://localhost:8080";
		
		String A = given().header("Content-Type", "application/json").header("Cookie","JSESSIONID="+Session_id+"")
		
		.body(Payload.Jira_Add_Bug())
		
		.when().post("/rest/api/2/issue")
		
		.then().log().all().statusCode(201).extract().response().asString();
					
					   JsonPath js= ReUsableMethods.rawToJson(A);
					   
					   String id=js.get("id");
					   System.out.println(id);
	}

}
