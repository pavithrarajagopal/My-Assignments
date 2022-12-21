package PagesSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseSalesforce.BaseClassTask;

public class VerifyPage extends BaseClassTask{

	public VerifyPage verify()
	{
		WebElement nameElement = driver.findElement(By.xpath("//div[@class='slds-page-header__title slds-m-right--small slds-align-middle clip-text slds-line-clamp']"));
		String name = nameElement.getText();
		String expectedName="Bootcamp";
		if(name.equalsIgnoreCase(expectedName))
		{
			System.out.println("Task created and verified");
		}
		else
		{
			System.out.println("Task not created");
		}
		return this;
	}
}
