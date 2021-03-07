package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Kiosk_Elements {

	private static WebElement element = null;

	// Function To locate Domain
	public static WebElement Domain(WebDriver driver) {

		element = driver.findElement(By.id("input-34"));
		return element;
	}

	// Function To locate Activation Code
	public static WebElement Activation_Code(WebDriver driver) {

		element = driver.findElement(By.id("input-40"));
		return element;
	}

	// Function To locate Activation Code
	public static WebElement Setup_Button(WebDriver driver) {

		element = driver.findElement(By.xpath(
				"//div[@id='inspire']/div/main/div/div/div/div/div/div/div/form/div[4]/div[2]/button/span/span"));
		return element;
	}

	public static WebElement Activate_Kiosk(WebDriver driver) {

		element = driver.findElement(By
				.xpath("//div[@id='inspire']/div/main/div/div/div/div/div/div[2]/form/div/div/div[6]/button/span/div"));
		return element;
	}

	public static WebElement Start_Using_Kiosk(WebDriver driver) {

		element = driver.findElement(By.xpath(
				"/html/body/div[@id='inspire']/div[@class='v-application--wrap']/main[@class='v-content']/div[@class='v-content__wrap']/div[@class='container container--fluid py-0 fill-height']/div[@class='row fill-height align-stretch']/div[@class='col col-12']/div[@class='fill-height done-card v-card v-card--flat v-sheet theme--dark primary']/div[@class='container fill-height']/div[@class='row align-center justify-center']/div[@class='col-sm-8 col-12']/div[@class='v-card__actions justify-center']/a[@class='v-btn v-btn--contained v-btn--router theme--light v-size--large white']"));

		return element;
	}

	public static WebElement Employee_Code(WebDriver driver) {

		element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));

		return element;
	}

	public static WebElement Login(WebDriver driver) {

		element = driver.findElement(By
				.xpath("//div[@id='inspire']/div/main/div/div/div/div/div/div/div[2]/form/div/div/div[2]/button/span"));

		return element;
	}

	public static WebElement Clock_In(WebDriver driver) {

		element = driver.findElement(By.cssSelector("div.pb-0.col.col-12 > i.div > svg"));

		return element;
	}

	public static WebElement Clock_In_popup(WebDriver driver) {

		element = driver.findElement(
				By.xpath("//div[@id='inspire']/div[2]/div/div/div/div/div/div[2]/div/div[2]/button/span/i"));

		return element;
	}

	public static WebElement Start_Break(WebDriver driver) {

		element = driver.findElement(By.xpath(
				"//body/div[@id='inspire']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]/div[1]/div[1]/i[1]/*[1]"));

		return element;
	}

	public static WebElement Start_Break_popup(WebDriver driver) {

		element = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]"));

		return element;
	}

	public static WebElement End_Break(WebDriver driver) {

		element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]/div[1]/div[1]"));

		return element;
	}

	public static WebElement End_Break_popup(WebDriver driver) {

		element = driver.findElement(By.xpath("//i[contains(text(),'close')]"));

		return element;
	}

	public static WebElement ClockOut(WebDriver driver) {

		element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]/span[1]/span[1]"));

		return element;
	}

	public static WebElement ClockOut_Popup(WebDriver driver) {

		element = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]"));

		return element;
	}

	public static WebElement ClockOut_Popup_2(WebDriver driver) {

		element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]/i[1]"));

		return element;
	}

}
