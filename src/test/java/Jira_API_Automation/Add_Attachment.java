package Jira_API_Automation;

import org.testng.annotations.Test;

import API_Payload_Files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class Add_Attachment extends Jira_Login {
	
	@Test
	public static void attachment()
	{
		
		String Session_id = auth();
		
		SessionFilter Session = new SessionFilter();
		
		RestAssured.baseURI="http://localhost:8080";
		
		//Provide parameters and header details (Please notice that the Content-Type is different here)
		String Response =	given().header("X-Atlassian-Token","no-check").filter(Session).pathParam("key", "AUT-5").header("Content-Type","multipart/form-data")
		.header("Cookie","JSESSIONID="+Session_id+"")
			
			
		
		// The attachment will be send with below command and you will also need to use Java file class to send attachment with REST API.
		.multiPart("file", new File("C:\\Users\\Sanket\\Desktop\\Add_Place.json"))
		
		//Enter End-point details.
		.when().post("/rest/api/2/issue/{key}/attachments")
		
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//The response that we get from Jira comes with Square brackets, below code is helping us to remove those brackets so that we can use response if we want.
		Response = Response.substring(1, Response.length()-1);
		
		//Converting String Response into Json
		JsonPath Js = ReUsableMethods.rawToJson(Response);
		
		//Retrieving data from Json Response.
		String id = Js.getString("id");
		
		System.out.println("====================================================================");
		
		System.out.println("The Id for the attached document is : " + id);
		
		System.out.println("====================================================================");
		
		
		
	}

}
