package week1.day1;

public class TwoWheeler {

	int noOfWheels = 2;
	float mileage = 40.5f;
	boolean isPunctured = false;
	char bikeNameFristLetter ='H';

	public static void main(String[] args) {
		TwoWheeler twoWheelerObject = new TwoWheeler();
		int noOfWheels = twoWheelerObject.noOfWheels;
		System.out.println("Number of Wheels : "+noOfWheels);
		float mileage = twoWheelerObject.mileage;
		System.out.println("Mileage : "+mileage);
		boolean isPunctured2 = twoWheelerObject.isPunctured;
		System.out.println("Vehicle punctured : "+isPunctured2);
		char bikeNameFristLetter2 = twoWheelerObject.bikeNameFristLetter;
		System.out.println("Bike name first letter : "+bikeNameFristLetter2);
	}

}
