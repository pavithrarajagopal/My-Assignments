package week3.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);

		//		1. Launch Sales force application

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//		2. Login with Provided Credentials

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//input[@id='Login']")).click();

		//		3. Click on Learn More link in Mobile Publisher  and click Confirm

		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowSet = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowSet);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();

		//		4. Click Learning and Mouse hover on Learning On Trail head

		Shadow obj = new Shadow(driver);
		obj.findElementByXPath("//span[text()='Learning']").click();

		Thread.sleep(2000);

		Shadow obj1 = new Shadow(driver);
		WebElement move = obj1.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions actionobj = new Actions(driver);
		actionobj.moveToElement(move).perform();
		Thread.sleep(3000);

		//		5. select SalesForce Certification

		obj.findElementByXPath("//a[text()='Salesforce Certification']").click();

		//		6. Choose Your Role as Sales force Architect and verify the URL

		driver.findElement(By.xpath("//div[text()='Architect']")).click();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl="https://trailhead.salesforce.com/en/credentials/architectoverview/";
		if (currentUrl.equals(expectedUrl))
		{
			System.out.println("URL verified");
		}
		else
		{
			System.out.println("different URL");
		}

		//		7. Get the Text(Summary) of Sales force Architect 

		WebElement slArchitect = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following-sibling::div"));
		String summary = slArchitect.getText();
		System.out.println("Summary : "+ summary);


		//		8. Get the List of Sales force Architect Certifications Available

		List<WebElement> certiElement = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		List<String> certifications = new ArrayList<String>();
		for (WebElement onebyone : certiElement) 
		{
			String text = onebyone.getText();
			certifications.add(text);
		}
		System.out.println("list of Salesforce Architect Certifications available : " +certifications);

		//		9. Click on Application Architect 

		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		Thread.sleep(2000);

		//		10.Get the List of Certifications available

		List<WebElement> certiElement1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		List<String> certifications1 = new ArrayList<String>();
		for (WebElement onebyone : certiElement1) 
		{
			String text1 = onebyone.getText();
			certifications1.add(text1);
		}
		System.out.println("list of Application Architect Certifications available : " +certifications1);
	}
}
