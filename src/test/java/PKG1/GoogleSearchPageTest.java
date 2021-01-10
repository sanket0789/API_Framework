package PKG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPageTest {
	
	static WebDriver driver = null;

	public static void main(String[] args) {
		
		GoogleSearchTest();
	}
	
	
	public static void GoogleSearchTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects obj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://google.com");
		
		obj.Search_Textbox_Action("Google Object Test");
		
		obj.Search_Button_Action();
		
		driver.close();
		
		System.out.println("Object Test Completed");
	
	}
}
