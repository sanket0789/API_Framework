package API_Automation_Tracktik;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Get_Employee extends Auth {

	//static String key = AUTH();

	@Test
	public void Pull_Employee(String Emp, String key) throws InterruptedException {

		// Rest Assured API works on 3 principals (GIVEN, WHEN, THEN)

		// URL of the API Request
		RestAssured.baseURI = "https://smoke.staffr.net";

		// Given - Input header/query/path details
		given().log().all().header("Authorization", "Bearer " + key).header("Content-Type", "application/json")
				.queryParam("id", "" + Emp + "")

				// When - API End Point
				.when().get("/rest/v1/employees")

				// Then - Verify response
				.then().log().all().assertThat().statusCode(200)

				// Extract Response and store it as String
				.extract().response().asString();

		System.out.println("\n" + "======================== 30 Seconds Wait ==========================" + "\n");

		Thread.sleep(30000);

		Update_Employee E = new Update_Employee();
		E.Edit_Employee(Emp, key);

	}
}
