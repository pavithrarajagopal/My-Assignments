package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Create Lead")).click();
		
        driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("New TestLeaf");
        
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Pavithraaa");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Rajagopal");
		
		driver.findElement(By.xpath("//textarea[contains(@id,'description')]")).sendKeys("Filling the form");
		
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).sendKeys("abcd@gmail.com");
		
		WebElement Selobj = driver.findElement(By.xpath("//select[contains(@id,'State')]"));
		
		Select Sel = new Select(Selobj);
		
		Sel.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[contains(@value,'Create')]")).click();
		
		driver.close();
	}

}
