package API_Automation_Tracktik;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Payload_API.API_Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Add_Employee extends Auth {

	public static  String key = AUTH();

	@Test
	public static void New_Employee() throws InterruptedException {

		// Rest Assured API works on 3 principals (GIVEN, WHEN, THEN)

		// URL of the API Request
		RestAssured.baseURI = "https://smoke.staffr.net";

		// Given - Input header/query/path details
		String resp = given().header("Authorization", "Bearer " + key).header("Content-Type", "application/json")

				// Body - Provide Body Details
				.body(API_Payload.Add_Employee())

				// When - API End Point
				.when().post("/rest/v1/employees")

				// Then - Verify response
				.then().assertThat().statusCode(201)

				// Extract Response and store it as String
				.extract().response().asString();

		// Declare JsonPath class For parsing Response Json
		JsonPath js = new JsonPath(resp);

		// Filter the key value needed to be used in other API's from object list.
		String Employee_id = js.getString("data.id");

		// Print Newly generated Employee Id
		System.out.println("Employee Created Successfully");
		System.out.println("\n");
		System.out.println("The Newly generated Employee Id is : " + Employee_id);
		System.out.println("\n");
		System.out.println("\n" + "======================== 30 Seconds Wait ==========================" + "\n");

		Thread.sleep(30000);

		// Calling Get Employee API Class
		Get_Employee A = new Get_Employee();
		A.Pull_Employee(Employee_id,key);

	}

}
