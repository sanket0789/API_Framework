package PKG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	private static WebDriver driver= null;
	
	public static void main(String[] args) {

		 // start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("htmlReport.html");
		
        // create ExtentReports and attach reporter(s)		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
        // creates a toggle for the given test, adds all log events under it    
		ExtentTest test1 = extent.createTest("GoogleSearch", "This is test to check google search functionlality");
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting our test");
		
		
		driver.get("https://google.com");
		
		test1.pass("Nevigated to Google Screen");
		
		
		GoogleSearchPage.Textbox_Search(driver).sendKeys("Moms magic tiffin Montreal");
		test1.pass("Entered Test in Search box");
		
		driver.manage().window().maximize();
		test1.warning("Maximizing Screen Size");
		
		
		GoogleSearchPage.Button_Search(driver).click();
		test1.pass("Pressing Search Button");
		
		
		driver.close();
		driver.quit();
		test1.pass("Closed browser successfully");
		
		System.out.println("Test Completed Successfully");
		test1.info("Test completed successfully");
		
		// calling flush writes everything to the log file
        extent.flush();
		
		
	}

}
