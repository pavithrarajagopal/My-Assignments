package PagesSalesforce;

import org.openqa.selenium.By;
import org.testng.Assert;

import BaseSalesforce.BaseClassTask;

public class HomePage extends BaseClassTask {
	
	public HomePage title() throws InterruptedException
	{
		Thread.sleep(15000);
		String title = driver.getTitle();
		String expectedTitle="Home | Salesforce";
		Assert.assertEquals(title, expectedTitle);
		System.out.println(title);
		return this;
	}

	public HomePage toggle() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		return this;
	}

	public SearchTasks viewall() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		Thread.sleep(2000);
		return new SearchTasks();
	}

}
