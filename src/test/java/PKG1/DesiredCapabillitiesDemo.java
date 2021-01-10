package PKG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabillitiesDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {


	DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("IgnoreProtectedModeSettings", "True");
		
		WebDriverManager.iedriver().setup();
		
		driver = new InternetExplorerDriver(caps);
		
		

		driver.get("https://google.com");


		GoogleSearchPage.Textbox_Search(driver).sendKeys("Moms magic tiffin Montreal");

		driver.manage().window().maximize();


		GoogleSearchPage.Button_Search(driver).click();


		driver.close();
		driver.quit();

		System.out.println("Test Completed Successfully");

		

	}

}
