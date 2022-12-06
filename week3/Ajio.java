package week3.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notiofications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'react-autosuggest__container')]/input")).sendKeys("bags");
		driver.findElement(By.xpath("//div[contains(@class,'react-autosuggest__container')]/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(@class,'facet-linkname facet-linkname-genderfilter facet-linkname-Men')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-l1l3nestedcategory facet-linkname-Men - Fashion Bags']")).click();
		Thread.sleep(1000);
		WebElement count = driver.findElement(By.xpath("//div[@class='length']"));
		String noOfItems = count.getText();
		System.out.println(noOfItems);
		Thread.sleep(2000);

		// to get the list of brands
		List<WebElement> brands = driver.findElements(By.xpath("//div[@class='brand']"));
        List <String> brandList = new ArrayList<String>();
		for (WebElement brandNames : brands) 
		{
			String brandText = brandNames.getText();
			brandList.add(brandText);
		}
		System.out.println(brandList);
		int sizeOfList = brands.size();
		System.out.println("Total no.of brands : "+sizeOfList);

		Set<String> brandSet = new TreeSet<String>(brandList);
		int sizeOfSet = brandSet.size();
		System.out.println("size of brand set : " +sizeOfSet );
		System.out.println(brandSet);
		
		//to get the list of bag names
		List<WebElement> bags = driver.findElements(By.xpath("//div[@class='nameCls']"));
        List <String> bagList = new ArrayList<String>();
        for (WebElement bagNames: bags) 
        {
        	String bagText = bagNames.getText();
            bagList.add(bagText);
		}
        System.out.println(bagList);
		int sizeOfList1 = bags.size();
		System.out.println("Total no.of bags : "+sizeOfList1);

		Set<String> bagSet = new TreeSet<String>(bagList);
		int sizeOfSet1 = bagSet.size();
		System.out.println("size of bag set : " +sizeOfSet1 );
		System.out.println(bagSet);
	}

}

//. Launch the URL https://www.ajio.com/
//2. In the search box, type as "bags" and press enter
//3. To the left  of the screen under " Gender" click the "Men"
//4. Under "Category" click "Fashion Bags"
//5. Print the count of the items Found. 
//6. Get the list of brand of the products displayed in the page and print the list.
//7. Get the list of names of the bags and print it



