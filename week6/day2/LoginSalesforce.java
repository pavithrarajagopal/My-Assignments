package Runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.BaseClassSalesforce;
import Pages.LoginPage;

public class LoginSalesforce extends BaseClassSalesforce {

	@BeforeTest
	public void setValues()
	{
		datafile="AccountName";
		testCase="Login Page";
		testDescription="using extent report to get result";
		testAuthor="Pavithra";
		testCategory="sanity";
	}
	
	@Test(dataProvider="fetch")
	public void createAccount(String name) throws IOException, InterruptedException
	{
		LoginPage lp= new LoginPage();
		lp.username("hari.radhakrishnan@qeagle.com").password("Testleaf$321").login().toggle().viewall().
		accounts().newbutton().name(name).select().save().verify();
	}
}
