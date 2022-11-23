package week1.day3;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {

		int [] input = {1,2,3,4,7,6,8};

		Arrays.sort(input);

		for (int i = 0; i <input.length; i++) {
			int a=i+1;
			if(a!=input[i])
			{
				System.out.println("missing element in array : "+a);
				break;
			}
		}
	}
}

