package testcases.leaftap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public ChromeDriver driver;

	@BeforeMethod
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Test
	public void runDeleteLead() throws InterruptedException   
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("23");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("6380812361");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		WebElement id = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String idnumber = id.getText();
		System.out.println(idnumber);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Name and ID")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(idnumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		String message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println("Result: "+message);
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
