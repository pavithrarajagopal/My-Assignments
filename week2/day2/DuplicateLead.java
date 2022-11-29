package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

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

		String id = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(id);
		
		Thread.sleep(3000);
		
		String Name = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		String Element = driver.findElement(By.linkText("Duplicate Lead")).getText();
		
		System.out.println(Element);
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		String DuplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		if(Name.equals(DuplicateName))
		{
			System.out.println("Confirm");
		}
		
		driver.close();
		
		
		
//		1   Browser Launch
//		2	Enter the username
//		3	Enter the password
//		4	Click Login
//		5	Click crm/sfa link
//		6	Click Leads link
//		7	Click Find leads
//		8	Click on Email
//		9	Enter Email
//		10	Click find leads button
//		11	Capture name of First Resulting lead
//		12	Click First Resulting lead
//		13	Click Duplicate Lead
//		14	Verify the title as 'Duplicate Lead'
//		15	Click Create Lead
//		16	Confirm the duplicated lead name is same as captured name
//		17	Close the browser (Do not log out)
		
		
		}

	}
		
	
