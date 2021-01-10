package POM_TESTS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.GoogleSearch;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	private static WebDriver driver = null;


	public static void main(String[] args) {
		GoogleSearchPageTest();

	}

	public static void GoogleSearchPageTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		GoogleSearch PageObj = new GoogleSearch(driver);

		PageObj.EnterTextSearchBox("Moms Magic Tiffin Montreal");
		
		driver.manage().window().maximize();


		PageObj.PressButton();

		driver.close();

		System.out.println("Test Completed successfully.");





	}

}
