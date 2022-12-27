package BaseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utils.ExcelReadingCreateAccount;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassSalesforce {

	private static final ThreadLocal<RemoteWebDriver> remote = new ThreadLocal<RemoteWebDriver>();
	public String datafile;
	public ExtentReports extent;
	public String testCase,testDescription,testAuthor,testCategory;
	public static ExtentTest test;

	public void set()
	{
		remote.set(new ChromeDriver());
	}
	
	public RemoteWebDriver getDriver()
	{
		return remote.get();
	}
	
	@DataProvider(name= "fetch",indices=0)
	public String[][] fetchData() throws IOException
	{
		String [][] values = ExcelReadingCreateAccount.read(datafile);
		return values;
	}
	
	@BeforeSuite
	public void startReport()
	{
		ExtentHtmlReporter repo= new ExtentHtmlReporter("./results/report.html");
		repo.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(repo);
	}
	
	@BeforeClass
	public void testcaseDetails(){
		test = extent.createTest(testCase, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	public void reportStep(String message, String status) throws IOException
	{
		if(status.equalsIgnoreCase("pass"))
		{
			test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
			
			throw new RuntimeException("see the report for details");
		}
	}
	
	public int takeSnap() throws IOException
	{
		int random=(int) (Math.random()*9999999);
		File scr = getDriver().getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/img"+random+".png");
		FileUtils.copyFile(scr, dest);
		return random;
	}

	@BeforeMethod
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();

		set();

		getDriver().get("https://login.salesforce.com");

		getDriver().manage().window().maximize();
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterMethod
	public void postCondition()
	{
		getDriver().close();
	}
	
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
}
