package week3.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateLetters {

	public static void main(String[] args) 
	{
		String company = "PayPal India";
		char[] charArray = company.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		for (Character ch : charArray) 
		{
			charSet.add(ch);
		}
		for (Character ch : charSet) 
		{
			if(!ch.equals(' '))
			{
				System.out.print(ch);
			}
		}
	}
}




