package POM_TESTS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import POM.GoogleSearch;

public class TestNG_Trial {

	WebDriver driver = null;

	public static void main(String[] args) {

	}

	@BeforeTest
	public void GoogleTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void GoogleTestActions() {

		driver.get("https://google.com");
		
		GoogleSearch obj= new GoogleSearch(driver);

		obj.EnterTextSearchBox("Moms Magic Tiffin Service Montreal");

		driver.manage().window().maximize();

		obj.PressButton();
	}

	@AfterTest
	public void TearDown() {

		driver.close();

		System.out.println("Object Test Completed");
	}

}
