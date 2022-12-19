package StepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceSteps {
	
	public ChromeDriver driver;
	@Given ("Launch browser and  Salesforce Url and Login")
	
	public void login()
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
	
	@When ("Click on toggle menu button from the left corner")
	public void toggle()
	{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	}
	
	@And ("Click view All and click Sales from Application Launcher")
	public void viewall()
	{
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}

	@And ("Click on Accounts tab")
	public void accounts() throws InterruptedException
	{
		WebElement accounts = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accounts);
		Thread.sleep(2000);
	}
	
	@And ("Click on New button")
	public void newbutton() throws InterruptedException
	{
		WebElement newbutton = driver.findElement(By.xpath("(//ul[contains(@class,'branding-actions')]//a)[1]"));
		driver.executeScript("arguments[0].click();", newbutton);
		Thread.sleep(5000);
	}
	
	@And ("Enter account name {string}")
	public void name(String name) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		Thread.sleep(2000);
	}
	
	@And ("Select Public")
	public void select() throws InterruptedException
	{
		WebElement dropdownElement = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[4]"));
		driver.executeScript("arguments[0].click();", dropdownElement);
		Thread.sleep(2000);


		WebElement publicOption = driver.findElement(By.xpath("//span[text()='Public']"));
		Actions obj= new Actions(driver);
		obj.moveToElement(publicOption);
		driver.executeScript("arguments[0].click();", publicOption);
	}
	
	@And ("click save")
	public void save()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	@Then ("verify message")
	public void verify()
	{
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
	
}
