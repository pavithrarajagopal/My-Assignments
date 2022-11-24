package week1.day4;

public class ReverseEvenWords 
{
	public static void main(String[] args) 
	{
		String test = "I am a software tester"; 
		String[] ru = test.split(" ");
		for (int i = 0; i < ru.length; i++) 
		{
			if((i+1)%2==0)
			{
				String  name =ru[i];
				char[] charArray = name.toCharArray();
				String output="";
				for (int j = charArray.length-1; j >=0; j--) 
				{
					output=output+charArray[j];
				}
				ru[i]=output;
			}	
		}
		for (int i = 0; i < ru.length; i++) 
		{
			System.out.print(ru[i]+" ");
		}
	}
}




