package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {

	WebDriver driver = null;
	
	
	  @BeforeTest 
	  public void SetUpTest() {
	  
	  WebDriverManager.chromedriver().setup(); 
	  
	  driver = new ChromeDriver();
	  }
	
	
	@Test(dataProvider = "Test1Data")
	public void Test1(String username, String password) throws Exception {

		System.out.println(username + " | " + password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
		
		//driver.findElement(By.name("Submit")).click();

	}

	@DataProvider(name = "Test1Data")
	public static Object[][] getData() {

		String excelPath = "C:\\Users\\Sanket\\git\\TestProject\\MavenFramework\\Excel\\Data.xlsx";
		Object data[][] = TestNGData(excelPath, "Sheet1");
		return data;

	}

	public static Object[][] TestNGData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.GetRowCount();
		int colCount = excel.GetColCount();

		Object Data[][] = new Object [rowCount-1][colCount];

		for(int i = 1; i<rowCount; i++) {

			for(int j = 0; j<colCount; j++) {

				String CellData = excel.getCellDataString(i, j);


				//System.out.print(CellData + " | ");

				Data [i-1][j] = CellData;
			}

			//System.out.println();
		}
		return Data;
	}

}
