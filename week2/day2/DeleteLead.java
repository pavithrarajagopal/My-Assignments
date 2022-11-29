package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		//1	Launch the browser
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//		2	Enter the username

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		//		3	Enter the password

		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");

		//		4	Click Login

		driver.findElement(By.className("decorativeSubmit")).click();

		//		5	Click crm/sfa link

		driver.findElement(By.linkText("CRM/SFA")).click();

		//		6	Click Leads link

		driver.findElement(By.linkText("Leads")).click();

		//		7	Click Find leads

		driver.findElement(By.linkText("Find Leads")).click();

		//		8	Click on Phone

		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		//		9	Enter phone number

		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("23");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("6380812361");

		//		driver.findElement(By.linkText("Name and ID")).click();
		//		
		//        driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Pavithra");
		//        
		//        driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("Devi");
		//        
		//		10	Click find leads button

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//		11	Capture lead ID of First Resulting lead

		//      12	Click First Resulting lead

		Thread.sleep(3000);

		String id = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(id);

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//		13	Click Delete

		driver.findElement(By.linkText("Delete")).click();

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//		14	Click Find leads

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.linkText("Name and ID")).click();

		//		15	Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(id);

		//		16	Click find leads button

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();


		//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		Thread.sleep(3000);
		String message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println("Result: "+message);
		Thread.sleep(5000);
		//		18	Close the browser (Do not log out)
		driver.close();


	}

}
