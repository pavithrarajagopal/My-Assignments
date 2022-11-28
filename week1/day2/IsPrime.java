package week1.day2;

public class IsPrime {

	public static void main(String[] args) {
		int number=6;
		int count=0;
		
		for (int i = 1; i <(number-1); i++) 
		{
			
			if(number%i==0)
			{
				count= count+1;
			}	
			
		}
		
		if (count>1)
		{
			System.out.println("not prime");
		}
		else
		{
			System.out.println("prime");
		}
		
	}
}


