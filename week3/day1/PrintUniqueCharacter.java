package week3.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class PrintUniqueCharacter 
{
	public static void main(String[] args) 
	{
		String name = "pavithra";
		char[] charArray = name.toCharArray();

		Set<Character> duplicate = new LinkedHashSet<Character>();
		Set<Character> charSet = new LinkedHashSet<Character>();
		for (Character ch : charArray) 
		{
			if(!charSet.add(ch)) {
				duplicate.add(ch);
			}
		}
		for (Character ch : charArray) 
		{
			if(duplicate.contains(ch))
			{
				charSet.remove(ch);
			}
		}
		System.out.println(charSet);
	}
}
