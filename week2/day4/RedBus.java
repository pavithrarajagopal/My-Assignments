package week2.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("src")).sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElement(By.id("src")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.id("dest")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("onward_cal")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[contains(@class,'current')]/following-sibling::td")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//i[contains(@class,'icon-close')]")).click();
		Thread.sleep(10000);
		WebElement Count = driver.findElement(By.xpath("//span[contains (@class,'busFound')]"));
		String Output = Count.getText();
		System.out.println("No.of.Buses found : "+Output);
		driver.findElement(By.xpath("//label[text()='SLEEPER']/preceding-sibling::label")).click();
		Thread.sleep(3000);
		WebElement Secondbus = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]"));
		String bus = Secondbus.getText();
		System.out.println("2nd resulting Bus name : "+bus);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[2]")).click();
		Thread.sleep(3000);
		driver.close();
	}
}






