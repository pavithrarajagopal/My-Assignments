package week4.day2assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateOpportunityWithMandatory extends BaseClassOppportunity {

	@Test
	public void runCreateOpportunityWithMandatory() throws InterruptedException {
		
		// Click on toggle menu button from the left corner	

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view All and click Sales from App Launcher	

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Opportunity tab 

		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		Thread.sleep(2000);
		
//		Click on New button
		
		WebElement newOpportunity = driver.findElement(By.xpath("//div[text()='New']"));
		driver.executeScript("arguments[0].click();", newOpportunity);
		Thread.sleep(3000);
		
//		Enter Opportunity name
		
		WebElement name = driver.findElement(By.xpath("//input[@name='Name']"));
		name.sendKeys("Salesforce Automation by Pavithra");
		driver.executeScript("arguments[0].click();", name);	
		String text = name.getText();
		System.out.println(text);
		Thread.sleep(2000);
		
//		Choose close date as Today
		
		WebElement date = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click();", date);
		WebElement today = driver.findElement(By.xpath("//span[text()='13']"));		
		driver.executeScript("arguments[0].click();", today);		
		Thread.sleep(2000);
		
//		Select 'Stage' as Need Analysis
		
		WebElement dropdown = driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[3]"));
		dropdown.click();
		WebElement optionSelect = driver.findElement(By.xpath("(//span[text()='Qualification']/following::span)[2]"));
		optionSelect.click();
		Thread.sleep(2000);
		
//		click Save and VerifyOppurtunity Name"
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		WebElement message = driver.findElement(By.xpath("//div[text()='\"Salesforce Automation by Pavithra\"']"));
		driver.executeScript("arguments[0].click();", message);
		Thread.sleep(2000);
		String text2 = message.getText();
		System.out.println(text2);
		String expectedMessage="\"Salesforce Automation by Pavithra\"";
		if(text2.equalsIgnoreCase(expectedMessage))
		{
			System.out.println("opportunity name verified");
		}
		else
		{
			System.out.println("opportunity name not verified");
		}
		Thread.sleep(2000);
	}
}
