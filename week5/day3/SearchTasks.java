package PagesSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseSalesforce.BaseClassTask;

public class SearchTasks extends BaseClassTask {

	public SearchTasks search() throws InterruptedException
	{
		WebElement searchElement = driver.findElement(By.xpath("//input[@class='slds-input']"));
		searchElement.click();
		searchElement.sendKeys("task");

		Thread.sleep(2000);
		return this;
	}

	public TaskHome clicktasks()
	{
		WebElement taskClick = driver.findElement(By.xpath("//span[@class='slds-truncate label-display']"));
		driver.executeScript("arguments[0].click();", taskClick);
		return new TaskHome();
	}
}
