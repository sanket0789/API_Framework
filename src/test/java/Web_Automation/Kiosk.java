package Web_Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Kiosk_Elements;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Kiosk {

	private static WebDriver driver = null;

	@Test
	public void Kiosk_Home() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://kiosk.tracktik.app/#/install/index");

		driver.manage().window().maximize();

		// Setup Kiosk
		Kiosk_Elements.Domain(driver).sendKeys("smoke.staffr.net");
		Thread.sleep(4000);

		Kiosk_Elements.Activation_Code(driver).sendKeys("930LA09");
		Thread.sleep(4000);

		Kiosk_Elements.Setup_Button(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.Activate_Kiosk(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.Start_Using_Kiosk(driver).click();
		Thread.sleep(14000);

		// Login Kiosk
		Kiosk_Elements.Employee_Code(driver).sendKeys("0789");
		Thread.sleep(4000);

		Kiosk_Elements.Login(driver).click();
		Thread.sleep(4000);

		// Clock In
		Kiosk_Elements.Clock_In(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.Clock_In_popup(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.Employee_Code(driver).sendKeys("0789");
		Thread.sleep(4000);

		Kiosk_Elements.Login(driver).click();
		Thread.sleep(4000);

		// Start Break
		Kiosk_Elements.Start_Break(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.Start_Break_popup(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.Employee_Code(driver).sendKeys("0789");
		Thread.sleep(4000);

		Kiosk_Elements.Login(driver).click();
		Thread.sleep(4000);

		// End Break
		Kiosk_Elements.End_Break(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.End_Break_popup(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.Employee_Code(driver).sendKeys("0789");
		Thread.sleep(4000);

		Kiosk_Elements.Login(driver).click();
		Thread.sleep(4000);

		// Clock Out
		Kiosk_Elements.ClockOut(driver).click();
		Thread.sleep(4000);

		Kiosk_Elements.ClockOut_Popup(driver).click();
		Thread.sleep(4000);
		
		Kiosk_Elements.ClockOut_Popup_2(driver).click();
		Thread.sleep(4000);
		
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("=================================== Test Completed Successfully ===================================");
		System.out.println("\n");
		System.out.println("\n");
	}

}
