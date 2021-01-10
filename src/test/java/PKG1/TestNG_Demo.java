package PKG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {

	static WebDriver driver = null;

	@BeforeTest
	public void SetUpTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void GoogleSearch() throws InterruptedException {

		driver.get("https://google.com");

		GoogleSearchPage.Textbox_Search(driver).sendKeys("Moms magic tiffin Montreal");

		driver.manage().window().maximize();

		GoogleSearchPage.Button_Search(driver).click();

	}

	@AfterTest
	public void TearDownTest() {

		driver.close();

		driver.quit();
		System.out.println("Test Completed Successfully");
	}

}
