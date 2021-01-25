package Jira_API_Automation;

import org.testng.annotations.Test;

import API_Payload_Files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class Jira_Get_Issue extends Jira_Login{
	
	@Test
	public void Get_Issue()
	{
		
		String Session_id = auth();
		RestAssured.baseURI="http://localhost:8080";
		
		String Response =given().header("Cookie","JSESSIONID="+Session_id+"").pathParam("key", "AUT-5").queryParam("fields", "comment")
		
		.when().get("/rest/api/2/issue/{key}")
		
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath Js = ReUsableMethods.rawToJson(Response);
		
		//Filtering size of an array
		
		int  Count =Js.getInt("fields.comment.comments.size()");
		
		
		//Once we get the size, We are running for loop to filter comment id.
		for (int i=0; i<Count;i++)
			
		{
			
			//We are giving current loop id to access comment id.
			String CommentID = Js.get("fields.comment.comments["+i+"].id").toString();
			
			//If the comment id will match we will enter inside if condition.
			if (CommentID.equalsIgnoreCase("10103"))
			{
			
				//We will retrieve the body for the match id
			String body =	Js.get("fields.comment.comments["+i+"].body").toString();
			
			System.out.println("===============================================================");
			// printing the body.	
			System.out.println("The comment is : " + body);

			System.out.println("===============================================================");
			
			}
		}
		
		
		
	
		
		
	}

}
