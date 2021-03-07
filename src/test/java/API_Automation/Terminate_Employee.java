package API_Automation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Payload_API.API_Payload;
import io.restassured.RestAssured;

public class Terminate_Employee {

	@Test
	public void Remove_Employee(String Emp, String key) {
	
		// Rest Assured API works on 3 principals (GIVEN, WHEN, THEN)

				// URL of the API Request
				RestAssured.baseURI = "https://smoke.staffr.net";

				// Given - Input header/query/path details
				given().header("Authorization", "Bearer " + key).pathParam("id", ""+Emp+"")
						.header("Content-Type", "application/json")

						// Body - Provide Body Details
						.body(API_Payload.Terminate_Employee())

						// When - API End Point
						.when().post("/rest/v1/employees/{id}/actions/terminate")

						// Then - Verify response
						.then().log().all().assertThat().statusCode(200)

						// Extract Response and store it as String
						.extract().response().asString();

				System.out.println("\n" + "======================== 30 Seconds Wait ==========================" + "\n");

			}
		
		
	}

