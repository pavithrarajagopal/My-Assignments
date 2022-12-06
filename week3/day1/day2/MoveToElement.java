package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notiofications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement kids = driver.findElement(By.xpath("//span[contains(text(),'Kids')]"));
		Thread.sleep(3000);
		Actions builder= new Actions(driver);
		builder.moveToElement(kids).perform();
		Thread.sleep(1000);
	}

}
