package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("abcde123@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(3000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		String name = text.getText();
		System.out.println(name);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String title = driver.getTitle();
		String actualTitle = "Duplicate Lead | opentaps CRM";
		if(title.equalsIgnoreCase(actualTitle))
		{
			System.out.println("title matched");
		}
		else
		{
			System.out.println("title does not match");
		}
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		WebElement text2 = driver.findElement(By.id("viewLead_firstName_sp"));
		String duplicatename = text2.getText();
		if(name.equals(duplicatename))
		{
			System.out.println("Confirm");
		}
		driver.close();
		
		}

	}
		
	
