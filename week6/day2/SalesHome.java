package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClassSalesforce;
import io.cucumber.java.en.And;

public class SalesHome extends BaseClassSalesforce{

	@And ("Click on Accounts tab")
	public ClickNew accounts() throws InterruptedException, IOException
	{
		WebElement accounts = getDriver().findElement(By.xpath("//span[text()='Accounts']"));
		try {
			getDriver().executeScript("arguments[0].click();", accounts);
			reportStep("salepage successful", "pass");

		} catch (Exception e) {
			reportStep("salepage not successful", "fail");

		}
		Thread.sleep(2000);
		return new ClickNew();
	}
}
