package RunnerSalesforce;

import org.testng.annotations.Test;

import BaseSalesforce.BaseClassTask;
import PagesSalesforce.LoginPage;

public class loginsalesforce extends BaseClassTask{

	@Test
	public void run() throws InterruptedException
	{
		LoginPage obj= new LoginPage();
		obj.username().password().login().title().toggle().viewall().search().clicktasks().
		dropdown().newclick().subject().status().save().verify();
	}
}
