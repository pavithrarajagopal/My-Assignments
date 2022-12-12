package testcases.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public ChromeDriver driver;

	@BeforeMethod
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notifications");
		driver = new ChromeDriver(option);

		// Launch Sales force application

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Logging with credentials

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}
	
	@Test
	public void runCreateContact() throws InterruptedException 
	{
		// Click on toggle menu button from the left corner	

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view All and click Sales from App Launcher	

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Opportunity tab 

		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		Thread.sleep(2000);
		
		//	Click on Accounts tab

		WebElement accounts = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accounts);
		Thread.sleep(2000);

		//	Click on New button		

		WebElement newbutton = driver.findElement(By.xpath("(//ul[contains(@class,'branding-actions')]//a)[1]"));
		driver.executeScript("arguments[0].click();", newbutton);

		Thread.sleep(5000);

		//	Enter 'your name' as account name	

		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("pavithra");

		Thread.sleep(2000);

		//	select Public

		WebElement dropdownElement = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[4]"));
		driver.executeScript("arguments[0].click();", dropdownElement);
		Thread.sleep(2000);


		WebElement publicOption = driver.findElement(By.xpath("//span[text()='Public']"));
		Actions obj= new Actions(driver);
		obj.moveToElement(publicOption);
		driver.executeScript("arguments[0].click();", publicOption);

		// click save

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		// verify message

		WebElement nameElement = driver.findElement(By.xpath("//lightning-formatted-text[text()='pavithra']"));
		String name = nameElement.getText();
		String expectedName="pavithra";
		if(name.equalsIgnoreCase(expectedName))
		{
			System.out.println("Account created and verified");
		}
		else
		{
			System.out.println("Account not created");
		}
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
}


