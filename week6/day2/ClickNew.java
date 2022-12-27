package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClassSalesforce;
import io.cucumber.java.en.And;

public class ClickNew extends BaseClassSalesforce {

	@And ("Click on New button")
	public CreateAccount newbutton() throws InterruptedException, IOException
	{
		WebElement newbutton = getDriver().findElement(By.xpath("(//ul[contains(@class,'branding-actions')]//a)[1]"));
		try {
			getDriver().executeScript("arguments[0].click();", newbutton);
			reportStep("new successful", "pass");

		} catch (Exception e) {
			reportStep("new not successful", "fail");

		}
		Thread.sleep(5000);
		return new CreateAccount();
	}
	
}
