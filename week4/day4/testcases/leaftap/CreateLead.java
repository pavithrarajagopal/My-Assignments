package testcases.leaftap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateLead {

	public ChromeDriver driver;

	@BeforeMethod
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Test
	public void runCreateLead()  
	{
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pavithra");

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Devi");

		driver.findElement(By.id("createLeadForm_description")).sendKeys("Filling the form");

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("pavithrarajagopal3@gmail.com");

		WebElement Sele = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		Select src = new Select(Sele);

		//src.selectByValue("NY");
		src.selectByVisibleText("New York");

		driver.findElement(By.name("submitButton")).click();

	}

	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
}

