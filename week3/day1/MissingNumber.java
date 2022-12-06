package week3.day1;

import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {
	
public static void main(String[] args) 
{
	int[] runningNumbers={9,7,4,3,2,3,6,7,8,3,1};
	Set<Integer> uniqueNumbers = new TreeSet<Integer>();
	for (Integer number : runningNumbers) 
	{
		uniqueNumbers.add(number);
	}
	System.out.println(uniqueNumbers);
	
	int prevNumber = 0;
	int missingNumber=0 ;
	for(Integer number: uniqueNumbers) 
	{
		int predictedNextNumber = prevNumber + 1;
		if (predictedNextNumber != number) 
		{
			missingNumber = predictedNextNumber;
			break;
		}
		prevNumber = number;
	}
	System.out.println("Missing number: " + missingNumber);
}
}
