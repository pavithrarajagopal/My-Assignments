package week1.day4;

public class Palindrome {

	public static void main(String[] args) {

		String name = "madam";
		String revname ="";
		
		
		char[] charArray = name.toCharArray();
		 
		for (int i =charArray.length-1 ; i >=0; i--) {
			
			revname = revname + charArray[i];
			
		}
		
		if(revname.equalsIgnoreCase(name))
		{
			System.out.println(revname+" is a palindrome");
		}
		else
		{
			System.out.println(revname+" is not a palindrome");
		}
		}
	}






	
	 