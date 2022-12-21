package BaseSalesforce;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTask {

public static ChromeDriver driver;
	
	@BeforeMethod
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://login.salesforce.com");

		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
}
