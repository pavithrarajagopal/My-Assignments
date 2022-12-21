package PagesSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseSalesforce.BaseClassTask;

public class NewTaskEdit extends BaseClassTask{

	public NewTaskEdit subject()
	{
		WebElement subject = driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']"));
		subject.click();
		subject.sendKeys("Bootcamp");
		return this;
	}

	public NewTaskEdit status()
	{
		WebElement status = driver.findElement(By.xpath("//a[@class='select']"));
		driver.executeScript("arguments[0].click();", status);

		WebElement statusDropdown = driver.findElement(By.xpath("//a[text()='Waiting on someone else']"));
		driver.executeScript("arguments[0].click();", statusDropdown);
		return this;
		
	}
	
	public VerifyPage save()
	{
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		return new VerifyPage();
	}
}
