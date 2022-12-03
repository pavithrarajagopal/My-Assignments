package week2.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[contains(@class,sc-hCaUpS)]")).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,sc-hCaUpS)]")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		String checkUrl = "https://in.bookmyshow.com/explore/home/hyderabad";
		if(currentUrl.equalsIgnoreCase(checkUrl))
		{
			System.out.println("Url verified");
		}
		driver.findElement(By.xpath("//span[@id='4']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'sc-hCaUpS')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'sc-hCaUpS')]")).sendKeys("Love Today");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'sc-hCaUpS')]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'tickets')]")).click();
		WebElement firstTheater = driver.findElement(By.xpath("(//div[@class='__title']/a)[1]"));
		String theaterName = firstTheater.getText();
		System.out.println(theaterName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='venue-info-text'])[1]")).click();
		WebElement facilityCheck = driver.findElement(By.xpath("(//div[@class='facility-text'])[4]"));
		String check = facilityCheck.getText();
		if(check.equalsIgnoreCase("parking facility"))
		{
			System.out.println("Parking facility available");
		}
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(@class,'_available')])[1]")).click();
		driver.findElement(By.xpath("//div[@id='btnPopupAccept']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='pop_2']/preceding-sibling::li")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='btn-bar'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='_available']")).click();
		driver.findElement(By.xpath("//a[@id='btmcntbook']")).click();
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.xpath("//span[@id='subTT']"));
		String subTotal = price.getText();
		System.out.println("sub Total amount : "+subTotal);
		Thread.sleep(2000);
		driver.close();
	}
}
