package week1.day4;

import java.util.Arrays;

public class Anagram 
{
	public static void main(String[] args) 
	{
		String text1 = "stops";
		String text2 = "potss";

		if(text1.length()==text2.length())
		{
			boolean isAnagram= true;
			char[] charArray1 = text1.toCharArray();
			char[] charArray2 = text2.toCharArray();
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			for (int i = 0; i < charArray2.length; i++)
			{	
				if(charArray1[i]!=charArray2[i])
				{
					isAnagram=false;
					break;
				}
			}
			if(isAnagram==true) {
				System.out.println("given input is an anagram");
			}
			else
			{
				System.out.println("given input is not an anagram");
			}
		}
		else
		{
			System.out.println("not same length so not an anagram");
		}
	}
}






