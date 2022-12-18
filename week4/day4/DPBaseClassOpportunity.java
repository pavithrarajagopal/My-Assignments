package week4.day4.weeklyassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DPBaseClassOpportunity {

public RemoteWebDriver driver;
	
	@Parameters({"browser","url","username","password"})
	
	@BeforeMethod 
	public void preCondition(String browser,String url,String username,String password )
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("-disable-notifications");
			driver = new ChromeDriver(option);
		}
		// Launch Sales force application

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Logging with credentials

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}
	
	@AfterMethod 
	public void postCondition()
	{
		driver.close();
	}
}
