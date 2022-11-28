package week1.day1;

public class Mobile {

	public void makeCall() 
	{
		System.out.println("Call Testleaf");
	}
	public void sendMsg()
	{
		System.out.println("Hello Testleaf Team");	
	}

	public static void main(String[] args) {

		Mobile mobileObject = new Mobile();
		mobileObject.makeCall();
		mobileObject.sendMsg();
	}

}
