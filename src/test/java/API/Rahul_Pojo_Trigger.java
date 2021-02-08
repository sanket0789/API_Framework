package API;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourse;

public class Rahul_Pojo_Trigger {

	@Test
	public void Pojo() throws InterruptedException
	{
		
		//Below code is used to login and retrieve code from Browser, But Chrome does not allow it anymore.
		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver= new
		 * ChromeDriver();
		 * 
		 * driver.get(
		 * "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss"
		 * ); driver.findElement(By.cssSelector("input[type='email']")).sendKeys(
		 * "ghostrider0789@gmail.com");
		 * driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER
		 * ); Thread.sleep(3000);
		 * driver.findElement(By.cssSelector("input[type='password']")).sendKeys(
		 * "sanket789");
		 * driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.
		 * ENTER); Thread.sleep(4000);
		 */
		
		// Manually go to above URL and login and copy the code from Browser URL.
		String code="4%2F0AY0e-g6kUdWXvoMdNHcXTr42AK02n3ipRSqY98yRyxBH8iU1rtzO7SI-F7xeVIRHe6adyg";
		//System.out.println(code);
		
		
		//   tagname[attribute='value']
		
		// Sending request to Google with auth code and required details.
String accessTokenResponse=	given().urlEncodingEnabled(false)
	.queryParams("code",code)
	.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
	.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
	.queryParams("grant_type","authorization_code")
	.when().log().all()
	.post("https://www.googleapis.com/oauth2/v4/token").asString();
JsonPath js=new JsonPath(accessTokenResponse);
String accessToken=js.getString("access_token");
	
	
	
	//deserializing data from Json to Java Class
	GetCourse Get=given().log().all().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
			.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
			
	
		// Filtering data from Java class
	  System.out.println(Get.getLinkedIn()); System.out.println(Get.getInstructor());
	  System.out.println(Get.getCourses().getApi().get(1).getCourseTitle());
	  
	  
	  List<Api> apiCourses=Get.getCourses().getApi(); 
	  for(int i=0;i<apiCourses.size();i++) 
	  { 
		  if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) 
		  {
	  System.out.println(apiCourses.get(i).getPrice()); 
		  } 
	  }
	 
	
	//Get the course names of WebAutomation
	/*ArrayList<String> a= new ArrayList<String>();
	
	
	List<pojo.WebAutomation> w=gc.getCourses().getWebAutomation();
	
	for(int j=0;j<w.size();j++)
	{
		a.add(w.get(j).getCourseTitle());
	}
	
	List<String> expectedList=	Arrays.asList(courseTitles);
	
	Assert.assertTrue(a.equals(expectedList));*/
	
	
	
	
	
	
	//System.out.println(response);
	
	
//}
	}
	
}
