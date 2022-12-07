package week3.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Simple Alert
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		driver.switchTo().alert().accept();
		String text1= driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		System.out.println(text1);
		Thread.sleep(2000);
		
		//Confirm Alert
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		driver.switchTo().alert().dismiss();
		String text2 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println(text2);
		Thread.sleep(2000);
		
		//Sweet Alert-Simple Dialog
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		Thread.sleep(2000);
		
		//Sweet Modal Dialog
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all'])[2]")).click();
		Thread.sleep(2000);
		
		//Prompt Alert
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		driver.switchTo().alert().sendKeys("Pavi thra");
		driver.switchTo().alert().accept();
		String text3 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(text3);
		
		//Sweet Alert Confirmation
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.name("j_idt88:j_idt109")).click();
		Thread.sleep(2000);
		
		//Minimize Maximize
		driver.findElement(By.xpath("//button[@name='j_idt88:j_idt111']")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
		Thread.sleep(2000);
		
		driver.close();
	}
}
