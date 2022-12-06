package week3.day1;

import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) 
	{
		int[] numbers = {3,2,11,4,6,7,2,3,3,6,7};
		Set<Integer> obj = new TreeSet<Integer>();
		for (Integer inputs : numbers) 
		{
			obj.add(inputs);
		}
		System.out.println(obj);
		int size = obj.size();
		System.out.println("size of set : "+size);
		Object[] array = obj.toArray();
		Object object = array[array.length-2];
		System.out.println("second largest number : " +object);
	}
}
