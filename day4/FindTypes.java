package week1.day4;

public class FindTypes 
{

	public static void main(String[] args) 
	{
		int letter=0;
		int digit=0;
		int space=0;
		int specialChar=0;
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		char[] charArray = test.toCharArray();
		for (int i = 0; i < charArray.length; i++) 
		{
			if(Character.isLetter(charArray[i]))
			{
				letter++;
			}
			else if(Character.isDigit(charArray[i]))
			{
				digit++;
			}
			else if (Character.isSpaceChar(charArray[i]))
			{
				space++;
			}
			else
			{
				specialChar++;
			}
		}
		System.out.println("letter: " + letter);
		System.out.println("number: " + digit);
		System.out.println("space: " + space);
		System.out.println("specialCharcter: " + specialChar);

	}
}

