package PKG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
	
	private static WebDriver driver= null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		GoogleSearch(); 
	}
	
	public static void GoogleSearch() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		GoogleSearchPage.Textbox_Search(driver).sendKeys("Moms magic tiffin Montreal");
		
		driver.manage().window().maximize();
		
		GoogleSearchPage.Button_Search(driver).click();
		
		driver.close();
		
		System.out.println("Test Completed Successfully");


	}
}
