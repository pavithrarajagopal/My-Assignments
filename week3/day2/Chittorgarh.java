package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notiofications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		Thread.sleep(2000);
		List<WebElement> securityNames = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr/td[3]"));
		List<String> nameList = new ArrayList<String>();
		for (WebElement names : securityNames) 
		{
			String text = names.getText();
			nameList.add(text);
		}
		System.out.println(nameList);
		int sizeOfList = nameList.size();
		System.out.println("size of list : "+sizeOfList);
		Set<String> nameSet = new LinkedHashSet<String>(nameList);
		System.out.println(nameSet);
		int sizeOfSet = nameSet.size();
		System.out.println("size of set : "+sizeOfSet);
		if(sizeOfList==sizeOfSet)
		{
			System.out.println("no Duplicates found");
		}
		else
		{
			System.out.println("Duplicates Found");
		}
	}
}
