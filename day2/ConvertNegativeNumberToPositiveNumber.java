package week1.day2;

public class ConvertNegativeNumberToPositiveNumber {

	public static void main(String[] args) {
		int number = -2;
		
		if(number<0)
		{
			System.out.println("The given number "+number+" is Negative");
		}
		
		int result = -(number) ;
		
		if (result>0)
		{
			System.out.println("The converted number is Positive");
		}

		System.out.println("Positive Number: "+result);
	}

}
