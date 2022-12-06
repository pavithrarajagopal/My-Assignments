package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML1 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notiofications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<WebElement> row = driver.findElements(By.xpath("//div[@class='render']/table//tr"));
		int rowSize = row.size();
		System.out.println("number of rows in first table : "+rowSize);

		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='related-pages']/table//tr"));
		int rowSize1 = rows.size();
		System.out.println("number of rows in second table : "+rowSize1);

		int totalRows= rowSize+rowSize1;
		System.out.println("total number of rows in the page : " +totalRows);

		List<WebElement> column = driver.findElements(By.xpath("//div[@class='render']/table/thead/tr/th"));
		int columnSize = column.size();
		System.out.println("number of columns in first table : "+columnSize);

		List<WebElement> columns = driver.findElements(By.xpath("//div[@class='related-pages']/table/tbody/tr/th"));
		int columnSize1 = columns.size();
		System.out.println("number of columns in second table : "+columnSize1);

		int totalColumns=columnSize+columnSize1;
		System.out.println("total number of columns in the page :"+totalColumns);
	}
}
