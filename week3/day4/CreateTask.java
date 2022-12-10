package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask {

	public static void main(String[] args) throws InterruptedException {

		// Launch the browser

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);

		//Launch Sales force application

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click Login by giving credentials

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//input[@id='Login']")).click();

		// Click on Global Actions SVG icon(App Launcher)

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view all

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		Thread.sleep(2000);

		// Type task and select task

		WebElement searchElement = driver.findElement(By.xpath("//input[@class='slds-input']"));
		searchElement.click();
		searchElement.sendKeys("task");

		Thread.sleep(2000);
		
		WebElement taskClick = driver.findElement(By.xpath("//span[@class='slds-truncate label-display']"));
		driver.executeScript("arguments[0].click();", taskClick);

		WebElement dropdownClick = driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']"));
		driver.executeScript("arguments[0].click();", dropdownClick);

		// Click New Task under dropdown icon

		WebElement newwTask = driver.findElement(By.xpath("//div[text()='New Task']"));
		driver.executeScript("arguments[0].click();", newwTask);

		Thread.sleep(2000);

		//	Enter subject 
		
		WebElement subject = driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']"));
		subject.click();
		subject.sendKeys("Bootcamp");

		//	Select status as 'Waiting on someone else'

		WebElement status = driver.findElement(By.xpath("//a[@class='select']"));
		driver.executeScript("arguments[0].click();", status);

		WebElement statusDropdown = driver.findElement(By.xpath("//a[text()='Waiting on someone else']"));
		driver.executeScript("arguments[0].click();", statusDropdown);

		//	Save and verify the 'Task created' message

		driver.findElement(By.xpath("//span[text()='Save']")).click();

		WebElement nameElement = driver.findElement(By.xpath("//div[@class='slds-page-header__title slds-m-right--small slds-align-middle clip-text slds-line-clamp']"));
		String name = nameElement.getText();
		String expectedName="Bootcamp";
		if(name.equalsIgnoreCase(expectedName))
		{
			System.out.println("Task created and verified");
		}
		else
		{
			System.out.println("Task not created");
		}
	}
}








