package week4.day4.weeklyassignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact extends BaseClassContact {

	@DataProvider(name= "createContact")
	public String[][] toCreateContact() throws IOException
	{
		String [][] values = ReadCreateContact.readContact();
		return values;
	}
	
	@Test(dataProvider = "createContact")
	public void runCreateContact(String search,String fName,String lName,String emaiL,String aName,String fullName) throws InterruptedException {
		
		// 2. Click on toggle menu button from the left corner	

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click view All and Enter Contacts in Search Box

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		WebElement searchElement = driver.findElement(By.xpath("//input[@class='slds-input']"));
		searchElement.click();
		searchElement.sendKeys(search);
		
		Thread.sleep(2000);
		
//		4. Click Contacts
		
		WebElement findContacts = driver.findElement(By.xpath("//mark[text()='Contacts']"));
		driver.executeScript("arguments[0].click();", findContacts);
		
		Thread.sleep(2000);

//		5. Click on New
		
		WebElement clickNew = driver.findElement(By.xpath("//div[text()='New']"));
		driver.executeScript("arguments[0].click();", clickNew);
		
		Thread.sleep(3000);
		
//		6. Pick Salutation as 'Mr.'
		
		WebElement salutation = driver.findElement(By.xpath("//button[@name='salutation']"));
		salutation.click();
		
		Thread.sleep(2000);
		
		WebElement salutationSelect = driver.findElement(By.xpath("//span[text()='Mrs.']"));
		salutationSelect.click();
		
//		7. Enter First Name as 'Your Name'
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstName.click();
		firstName.sendKeys(fName);
		
		Thread.sleep(2000);
		
//		8. Enter Last Name as 'YOur Last Name'
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastName.click();
		lastName.sendKeys(lName);
		
		Thread.sleep(2000);
		
//		9. Enter email as 'Your EMail' 

		WebElement email = driver.findElement(By.xpath("//input[@name='Email']"));
		Actions obj = new Actions(driver);
		obj.scrollToElement(email).perform();
		Thread.sleep(2000);
		driver.executeScript("arguments[0].click();", email);		
		email.sendKeys(emaiL);
		
		Thread.sleep(2000);
		
//		10. Create a New Account for Account Name
		
		WebElement clickAccount = driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']"));
		clickAccount.click();
		
		Thread.sleep(2000);
		
		WebElement newAccount = driver.findElement(By.xpath("//span[text()='New Account']"));
		newAccount.click();
		
		Thread.sleep(3000);

//		11. Enter account name as 'Credits' and save
		
		WebElement accountName = driver.findElement(By.xpath("//input[@class=' input']"));
		accountName.click();
		accountName.sendKeys(aName);
		
//		12. Click and save
		
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		Thread.sleep(2000);
		
//		13. Verify contact using Unique name and print the name
		
		
		
		WebElement actualMessage = driver.findElement(By.xpath("//div[text()='\"Mrs. Pavithra Devi\"']"));
		String text = actualMessage.getText();
//		String message = "\""+opportunityName+"\"";
		String message="\""+fullName+"\"";
		if (text.equals(message)) {
			System.out.println("contact verified");
		}
		else
		{
			System.out.println("contact does not match");
		}

}
}