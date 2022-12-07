package week3.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//dealing with outer frame
		WebElement first = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(first);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Learning Frames");
		
		//switching to inner frame
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		Thread.sleep(2000);
		
		//to top window
		driver.switchTo().defaultContent();
		
		//dealing with 2nd frame in the page
		WebElement second = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(second);
		Thread.sleep(2000);
		WebElement sel = driver.findElement(By.id("animals"));
		Select obj= new Select(sel);
		obj.selectByVisibleText("Baby Cat");
		Thread.sleep(2000);
		
		driver.close();
	}
}
