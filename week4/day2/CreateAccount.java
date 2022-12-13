package week4.day2assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateAccount extends BaseAccountClass {

	@Test
	public void runCreateAccount() throws InterruptedException 
	{
		// Click on toggle menu button from the left corner	

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view All and click Sales from App Launcher	

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Opportunity tab 

		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		Thread.sleep(2000);

		//	Click on Accounts tab

		WebElement accounts = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accounts);
		Thread.sleep(2000);

		//	Click on New button		

		WebElement newbutton = driver.findElement(By.xpath("(//ul[contains(@class,'branding-actions')]//a)[1]"));
		driver.executeScript("arguments[0].click();", newbutton);

		Thread.sleep(5000);

		//	Enter 'your name' as account name	

		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("pavithra");

		Thread.sleep(3000);

		//	select Public

		WebElement dropdownElement = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[4]"));
		driver.executeScript("arguments[0].click();", dropdownElement);
		Thread.sleep(3000);


		WebElement publicOption = driver.findElement(By.xpath("//span[text()='Public']"));
		Actions obj= new Actions(driver);
		obj.moveToElement(publicOption);
		driver.executeScript("arguments[0].click();", publicOption);

		// click save

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		// verify message

		Thread.sleep(2000);
		WebElement nameElement = driver.findElement(By.xpath("//div[text()='\"pavithra\"']"));
		driver.executeScript("arguments[0].click();", nameElement);
		Thread.sleep(2000);
		String name = nameElement.getText();
		Thread.sleep(2000);
		String expectedName="\"pavithra\"";
		if(name.equalsIgnoreCase(expectedName))
		{
			System.out.println("Account created and verified");
		}
		else
		{
			System.out.println("Account not created");
		}
		Thread.sleep(2000);
	}
}


