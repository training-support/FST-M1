
public class Car {

	//Class Member Variables
	int numberOfSeats;
	String company;
    String color;
    int manufacturingYear;

    
    
	void accelerate(){
		System.out.println("Car moving forward");
	}
	void brake() {
		System.out.println("Car is stopped");
	}
	void charactersticsOfCar() {
		System.out.println("Which Seater:"+numberOfSeats);
		System.out.println("Manufacturer:"+company);
		System.out.println("Car color:"+color);
		System.out.println("Manufacturing year:"+manufacturingYear);
		
	}
	
}
