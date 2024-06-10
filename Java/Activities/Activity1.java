package Activity;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car Hyundai = new Car();
		
		Hyundai.make = 2014 ;
		Hyundai.color = "Black";
		Hyundai.transmission = "Manual" ;
		
		Hyundai.displayCharacteristics();
		Hyundai.accelerate();
		Hyundai.brake();

	}

}
