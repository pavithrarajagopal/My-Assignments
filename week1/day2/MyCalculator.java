package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {

		Calculator calci = new Calculator();
		
		int a = calci.add(1,2,3);
		System.out.println(a);
		
		int b = calci.sub(10,5);
		System.out.println(b);
		
		double c = calci.mul(1.2,1.2);
		System.out.println(c);
		
		float d = calci.divide(1.5f, 1.5f);
		System.out.println(d);
		
	}
}
