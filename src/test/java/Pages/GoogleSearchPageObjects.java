package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	
	By Textbox_Search = By.name("q");
	
	By Button_Search = By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public void Search_Textbox_Action(String text) {
		
		driver.findElement(Textbox_Search).sendKeys(text);
	}
	
    public void Search_Button_Action() {
		
		driver.findElement(Button_Search).click();
	}
	

}
