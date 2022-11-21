package week1.day1;

public class Mobile1 {

	char mobileLogo = '$' ;
	short noOfMobilePiece = 5 ;
	int modelNumber = 10 ;
	float mobilePrice = 10000.99F;
	boolean isDamaged = false;

	public static void main(String[] args) {

		Mobile1 mobile1Object = new Mobile1();
		char mobileLogo = mobile1Object.mobileLogo;
		System.out.println("Mobile Logo : " +mobileLogo);
		short noOfMobilePiece = mobile1Object.noOfMobilePiece;
		System.out.println("Number of Mobiles : "+noOfMobilePiece);
		int modelNumber = mobile1Object.modelNumber;
		System.out.println("Model Number : "+modelNumber);
		float mobilePrice = mobile1Object.mobilePrice;
		System.out.println("Price : "+mobilePrice);
		boolean isDamaged2 = mobile1Object.isDamaged;
		System.out.println("Damaged : "+isDamaged2);

	}

}
