package Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import BaseClass.BaseClassSalesforce;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class HomePage extends BaseClassSalesforce{

	@When ("Click on toggle menu button from the left corner")
	public HomePage toggle() throws IOException
	{
		try {
			getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			reportStep("toggle successful", "pass");

		} catch (Exception e) {
			reportStep("toggle not successful", "fail");

		}
		return this;
	}
	
	@And ("Click view All and click Sales from Application Launcher")
	public SalesHome viewall() throws IOException
	{
		try {
			getDriver().findElement(By.xpath("//button[text()='View All']")).click();
			reportStep("viewall successful", "pass");

		} catch (Exception e) {
			reportStep("viewall not successful", "fail");

		}
		try {
			getDriver().findElement(By.xpath("//p[text()='Sales']")).click();
			reportStep("save successful", "pass");

		} catch (Exception e) {
			reportStep("save not successful", "fail");

		}
		return new SalesHome();
	}
}
