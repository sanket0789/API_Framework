package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	private static WebElement element = null;
	
	
	//Function for Search Field
	public static WebElement Textbox_Search(WebDriver driver) {
		
		element = driver.findElement(By.name("q"));
	
		return element;
	}

	//Function for Search Button
	public static WebElement Button_Search(WebDriver driver) {
		
		element = driver.findElement(By.name("btnK"));
		return element;
	}
}
