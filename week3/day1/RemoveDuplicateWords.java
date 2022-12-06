package week3.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWords 
{
	public static void main(String[] args) 
	{
		String text = "We learn java basics as part of java sessions in java week1";
		Set <String> obj = new LinkedHashSet<String>();
		String[] split = text.split(" ");
		for (String words : split) 
		{
			obj.add(words);
		}
		System.out.println(obj);
        String joined = String.join(" ", obj);
        System.out.println(joined);
	}
}




