package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClass.BaseClassSalesforce;
import io.cucumber.java.en.And;

public class CreateAccount extends BaseClassSalesforce {

	@And ("Enter account name (.*)$")
	public CreateAccount name(String name) throws InterruptedException, IOException
	{
		try {
			getDriver().findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
			reportStep("name successful", "pass");

		} catch (Exception e) {
			reportStep("name not successful", "fail");
		}
		Thread.sleep(2000);
		return this;
	}
	
	@And ("Select Public")
	public CreateAccount select() throws InterruptedException, IOException
	{
		WebElement dropdownElement = getDriver().findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[4]"));
		try {
			getDriver().executeScript("arguments[0].click();", dropdownElement);
			reportStep("select successful", "pass");

		} catch (Exception e) {
			reportStep("select not successful", "fail");

		}
		Thread.sleep(2000);


		WebElement publicOption = getDriver().findElement(By.xpath("//span[text()='Public']"));
		Actions obj= new Actions(getDriver());
		obj.moveToElement(publicOption);
		try {
			getDriver().executeScript("arguments[0].click();", publicOption);
			reportStep("option successful", "pass");

		} catch (Exception e) {
			reportStep("option not successful", "fail");

		}
		
		return this;
	}
	
	@And ("click save")
	public Verify save() throws IOException
	{
		try {
			getDriver().findElement(By.xpath("//button[text()='Save']")).click();
			reportStep("save successful", "pass");

		} catch (Exception e) {
			reportStep("save not successful", "fail");

		}
		return new Verify();
	}
}
