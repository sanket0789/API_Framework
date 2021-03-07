package API_Automation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Payload_API.API_Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Update_Employee extends Auth {

	

	@Test
	public void Edit_Employee(String Emp, String key) throws InterruptedException {

		// Rest Assured API works on 3 principals (GIVEN, WHEN, THEN)

		// URL of the API Request
		RestAssured.baseURI = "https://smoke.staffr.net";

		// Given - Input header/query/path details
		String resp = given().header("Authorization", "Bearer " + key).pathParam("id", ""+Emp+"")
				.header("Content-Type", "application/json")

				// Body - Provide Body Details
				.body(API_Payload.Update())

				// When - API End Point
				.when().put("/rest/v1/employees/{id}")

				// Then - Verify response
				.then().log().all().assertThat().statusCode(200)

				// Extract Response and store it as String
				.extract().response().asString();

		// Declare JsonPath class For parsing Response Json JsonPath js = new
		JsonPath js = new JsonPath(resp);

		// Filter the key value needed to be used in other API's from object list.
		String Employee_Details = js.getString("data");

		// Print Newly generated Employee Id
		System.out.println("Here is Employee Details : " + Employee_Details);

		System.out.println("\n" + "======================== 30 Seconds Wait ==========================" + "\n");
		
		Terminate_Employee T = new Terminate_Employee();
		T.Remove_Employee(Emp, key);

	}
}
