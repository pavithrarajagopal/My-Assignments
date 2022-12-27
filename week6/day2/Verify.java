package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClassSalesforce;
import io.cucumber.java.en.Then;

public class Verify extends BaseClassSalesforce {

	@Then ("verify message")
	public Verify verify() throws IOException
	{
		WebElement nameElement;
		try {
			nameElement = getDriver().findElement(By.xpath("//lightning-formatted-text[text()='pavithra']"));
		
		String name = nameElement.getText();
		String expectedName="pavithra";
		if(name.equalsIgnoreCase(expectedName))
		{
			System.out.println("Account created and verified");
		}
		else
		{
			System.out.println("Account not created");
		}
		reportStep("verify successful", "pass");

		} catch (Exception e) {
			reportStep("verify not successful", "fail");

		}
		return this;
}
}