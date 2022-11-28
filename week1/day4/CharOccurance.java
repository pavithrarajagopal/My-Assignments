package week1.day4;

public class CharOccurance 
{

	public static void main(String[] args) 
	{
		
		String message = "welcome to chennai";
		char check = 'e';
		int count = 0;
		char[] charArray = message.toCharArray();
		for (int i = 0; i < charArray.length; i++) 
		{
			if(check==charArray[i])
			{
				count++;
			}
		}
		System.out.println(count);
	}
}
		
		
		
		
							
	
