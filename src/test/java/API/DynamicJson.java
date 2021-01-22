package API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import API_Payload_Files.Payload;
import API_Payload_Files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider = "BooksData")
	public static void AddBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		//Given - all input details
		String response = given().header("Content-Type", "application/json")
		.body(Payload.AddBook(isbn,aisle)).
		
		//When - Submit API
		when()
		.post("/Library/Addbook.php")
		
		//Then - Validate the response.
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(response);
		
		System.out.println("\n"+ "======================================================");
		
		String ID = js.get("ID");
		
		System.out.println("The Book ID is : " + ID);
		
		System.out.println("\n"+ "======================================================");
		
		// Delete Book Method
		
		RestAssured.baseURI="http://216.10.245.166";
		
		//Given - all input details
				String Resp = given().header("Content-Type", "application/json")
				.body(Payload.DeleteBook(ID)).
		
		//When - Submit API
				when()
				.post("/Library/DeleteBook.php")
				
		//Then - Validate the response.
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
				JsonPath J= ReUsableMethods.rawToJson(Resp);
				
				System.out.println("\n"+ "======================================================");
				
		
	}
	

	
	
	//Mothod 1 : Provide dynamic data for above API using Array.
	@DataProvider(name = "BooksData")
	public Object[][] getData()
	{
		
		//Array Collection of Elements
		//Multi dimentional array = collection of arrays.
		
		return new Object[][] {{"sanket","21"},{"sanket","22"}};
		
			//{"sanket","16"},{"sanket","17"},{"sanket","18"}};
		
	}

}
