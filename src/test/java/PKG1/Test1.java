package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		GoogleSearch();
	}
	
	public static void GoogleSearch() {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();



		driver.get("https://www.google.com/");


		driver.findElement(By.name("q")).sendKeys("Moms Magic tiffin service in Montreal");


		driver.findElement(By.name("btnK")).click();
		
		
		driver.close();

		System.out.println("Test Completed successfully.");
	}

		

}
