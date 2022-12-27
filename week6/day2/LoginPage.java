package Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import BaseClass.BaseClassSalesforce;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LoginPage extends BaseClassSalesforce {

	@And ("Enter the username as {string}")
	public LoginPage username(String username) throws IOException
	{
		try {
			getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			reportStep("username successful", "pass");

		} catch (Exception e) {
			reportStep("username not successful", "fail");

		}
		return this;
	}
	
	@And ("Enter the password as {string}")
	public LoginPage password(String password) throws IOException
	{
		try {
			getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			reportStep("password successful", "pass");

		} catch (Exception e) {
			reportStep("password not successful", "fail");

		}
		return this;
	}

	@When ("Click on Login Button")
	public HomePage login() throws IOException
	{
		try {
			getDriver().findElement(By.xpath("//input[@id='Login']")).click();
			reportStep("login successful", "pass");

		} catch (Exception e) {
			reportStep("login not successful", "fail");

		}
		return new HomePage();
	}
}
