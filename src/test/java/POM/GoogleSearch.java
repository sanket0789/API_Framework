package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {

	WebDriver driver = null;

	//Finding Locators	
	By SearchBox = By.name("q");

	By SearchButton = By.name("btnK");


	
	  public GoogleSearch(WebDriver driver) {
	  
	  this.driver = driver;
	  
	  }
	 
	
	

	public void EnterTextSearchBox(String Text)    {

		driver.findElement(SearchBox).sendKeys(Text);
	}
	
	public void PressButton() {

		driver.findElement(SearchButton).click();


	}

}
