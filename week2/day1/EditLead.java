package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.ByteArrayDataOutput;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		//* 1	Launch the browser
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();
		
		//* 2	Enter the user name
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		
		//* 3	Enter the password
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		//* 4	Click Login
		
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//* 5	Click crm/sfa link
		
        driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
        
      //* 6	Click Leads link
        
        driver.findElement(By.xpath("//a[(text()='Leads')]")).click();
        
      //* 7	Click Find leads
        
        driver.findElement(By.xpath("//a[(text()='Find Leads')]")).click();
        
      //* 8	Enter first name
        
        driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Pavithra");
        
        driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("Devi");
        
        
      //* 9	Click Find leads button
        
        driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
        
      //* 10 Click on first resulting lead
        
        driver.findElement(By.xpath("//a[text()='15487']")).click();
        
      //* 11 Verify title of the page
        
        String title = driver.getTitle();
        System.out.println("The title of the page is " +title);
        
        if(title.contains("View Lead | opentaps CRM"))
        {
        	System.out.println("I confirm the title");
        }
        else 
        {
        	System.out.println("The title does not match");
        }
        
      //* 12 Click Edit
        
        driver.findElement(By.xpath("//a[text()='Edit']")).click();
        
      //* 13 Change the company name
        
        driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
        
        
        driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("changed to testleaf");
        
      //* 14 Click Update
        
        driver.findElement(By.xpath("//input[@value='Update']")).click();
        
      //* 15 Confirm the changed name appears
        
      //* 16 Close the browser (Do not log out)
        
        driver.close();
	}

}
















