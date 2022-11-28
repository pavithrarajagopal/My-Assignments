package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {

		// Step 1: Download and set the path (WebDriverManager)
		
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the Chrome browser
		
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/

		driver.get("https://en-gb.facebook.com/");

		// Step 4: Maximize the window
		
		driver.manage().window().maximize();
		
		// Step 5: Add implicit wait
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 6: Click on Create New Account button
        
        driver.findElement(By.xpath("//a[contains(@data-testid,'registration')]")).click();
        
		// Step 7: Enter the first name
        
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pavithra");
        
		// Step 8: Enter the last name
        
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Devi");

		// Step 9: Enter the mobile number
        
        driver.findElement(By.xpath("(//input[contains(@name,'email')])[2]")).sendKeys("7418088640");
		
        // Step 10: Enter the password
        
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Anjeneya@1");

		// Step 11: Handle all the three drop downs
        
        WebElement Selobj = driver.findElement(By.id("day"));
        Select sel = new Select(Selobj);
        sel.selectByVisibleText("28");
        
        WebElement Selobj1 = driver.findElement(By.id("month"));
        Select sel1 = new Select(Selobj1);
        sel1.selectByVisibleText("May");
        
        WebElement Selobj2 = driver.findElement(By.id("year"));
        Select sel2 = new Select(Selobj2);
        sel2.selectByVisibleText("1994");
        
		// Step 12: Select the radio button "Female" 
        
        driver.findElement(By.xpath("//label[text()='Female']")).click();
		            //( A normal click will do for this step) 
		driver.close();
		
	}

}
