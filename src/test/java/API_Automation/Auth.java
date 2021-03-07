package API_Automation;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import Payload_API.API_Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Auth {

	@Test
	public static String AUTH() {

		// Rest Assured API works on 3 principals (GIVEN, WHEN, THEN)

		RestAssured.baseURI = "https://smoke.staffr.net";

		// Given - Input header/query/path details
		String res = given().header("Content-Type", "application/json")

				// Body - Provide Body Details
				.body(API_Payload.AUTH())

				// When - API End Point
				.when().post("/rest/v1/auth")

				// Then - Verify response
				.then().assertThat().statusCode(200)

				// Extract Response and store it as String
				.extract().response().asString();

		// Declare JsonPath class For parsing Response Json
		JsonPath js = new JsonPath(res);

		// Filter the key value needed to be used in other API's
		String token = js.getString("auth.token");

		System.out.println("the token is : " + token);
		return token;

	}
}
