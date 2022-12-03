package week2.day4;

public class SmartPhone extends Iphone implements Mobile {

	@Override
	public void setRingtone() 
	{
		System.out.println("ringtone set in Iphone");
		
	}

	public void call() 
	{
		System.out.println("calling in Mobile");
	}

	public void sendMessage() 
	{
		System.out.println("sending message in Mobile");
	}

	public void takePhoto() 
	{
		System.out.println("Taking Photo in Mobile");
	}
	
	public static void main(String[] args) 
	{
		SmartPhone obj = new SmartPhone();
		obj.setRingtone();
		obj.whatsapp();
		obj.call();
		obj.sendMessage();
		obj.takePhoto();
	}

}
