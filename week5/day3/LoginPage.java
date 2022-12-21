package PagesSalesforce;

import org.openqa.selenium.By;

import BaseSalesforce.BaseClassTask;

public class LoginPage extends BaseClassTask {

	public LoginPage username()
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		return this;
	}

	public LoginPage password()
	{
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		return this;
	}

	public HomePage login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000);
		return new HomePage();
		
	}
}
