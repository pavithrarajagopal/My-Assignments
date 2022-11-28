package week1.day3;

public class FindIntersection {

	public static void main(String[] args) {

		int [] first = {3,2,11,4,6,7};
		int [] second = {1,2,8,4,9,7};
		for (int i = 0; i < first.length; i++) 
		{
			for (int j = 0; j < second.length; j++) 
			{
				if(first[i]==second[j])
				{
					System.out.println(first[i]);
				}

			}

		}

	}

}



/*
 * Pseudo Code

 * a) Declare An array for {3,2,11,4,6,7};	 
 * b) Declare another array for {1,2,8,4,9,7};
 * c) Declare for loop iterator from 0 to array length
 * d) Declare a nested for another array from 0 to array length
 * e) Compare Both the arrays using a condition statement

 *  f) Print the first array (shoud match item in both arrays)
 */