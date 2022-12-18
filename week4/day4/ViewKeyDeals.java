package week4.day4.weeklyassignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ViewKeyDeals extends BaseClassKeyDeals
{
	@DataProvider(name= "createOpportunity")
	public String[][] toCreateViewKeyDeals() throws IOException
	{
		String [][] values = ReadViewDeals.read();
		return values;
	}
	
	@Test(dataProvider = "createOpportunity")
	public void runCreateContact(String opportunityName,String amount) throws InterruptedException {

		// 2. Click on toggle menu button from the left corner	

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click view All and click Sales from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		//		4. Click View All Key Deals in Key Deals 

		WebElement viewAll = driver.findElement(By.xpath("(//a[@class='viewAllLink'])[4]"));
		driver.executeScript("arguments[0].click();", viewAll);

		//		6. Click on New

		WebElement newClick = driver.findElement(By.xpath("//div[text()='New']"));
		driver.executeScript("arguments[0].click();", newClick);

		//		7. Give Opportunity Name  (From Excel)

		WebElement name = driver.findElement(By.xpath("//input[@name='Name']"));
		name.sendKeys(opportunityName);

		Thread.sleep(2000);

		//		8. Select Type as New Customer and Lead Source as Partner Referral

		WebElement type = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]"));
		type.click();
		Thread.sleep(2000);

		WebElement clickElement = driver.findElement(By.xpath("//span[text()='New Customer']"));
		clickElement.click();

		Thread.sleep(2000);

		//		9. Give Amount as 75000 (from Excel)
		WebElement amountData = driver.findElement(By.xpath("//input[@name='Amount']"));
		amountData.click();
		amountData.sendKeys(amount);

		Thread.sleep(2000);

		//		10. Select Close Date as Next month 20th day 

		WebElement closeDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		closeDate.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-container'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='20']")).click();

		Thread.sleep(2000);

		//		11. Select Stage as Needs Analysis

		WebElement dropdown = driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[3]"));
		dropdown.click();
		WebElement optionSelect = driver.findElement(By.xpath("(//span[text()='Qualification']/following::span)[2]"));
		optionSelect.click();
		Thread.sleep(2000);

		//		12. Click in Primary Campaign  Source and Select first option
		
		WebElement primary = driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]"));
		driver.executeScript("arguments[0].click();", primary);
		
		Thread.sleep(2000);

		WebElement firstOption = driver.findElement(By.xpath("//span[@class='slds-listbox__option-text slds-listbox__option-text_entity']"));
		driver.executeScript("arguments[0].click();", firstOption);
		
		Thread.sleep(2000);

		//		13. Click Save and Verify the opportunity is created"
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		WebElement message = driver.findElement(By.xpath("//div[text()='\"Opportunity name\"']"));
		driver.executeScript("arguments[0].click();", message);
		Thread.sleep(2000);
		String text2 = message.getText();
		System.out.println(text2);
		String expectedMessage="\"Opportunity name\"";
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