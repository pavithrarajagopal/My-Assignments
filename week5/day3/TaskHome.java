package PagesSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseSalesforce.BaseClassTask;

public class TaskHome extends BaseClassTask {

	public TaskHome dropdown() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement dropdownClick = driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']"));
		driver.executeScript("arguments[0].click();", dropdownClick);
		return this;
	}

	public NewTaskEdit newclick() throws InterruptedException
	{
		WebElement newwTask = driver.findElement(By.xpath("//div[text()='New Task']"));
		driver.executeScript("arguments[0].click();", newwTask);

		Thread.sleep(2000);
		return new NewTaskEdit();
	}
}
