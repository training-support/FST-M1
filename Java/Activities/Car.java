package activities;

public class Car {

	String color;
	String transmission;
	int make;
	int tyres;
	int doors;

	public Car(String color, String transmission, int make) {

		this.color = color;
		this.transmission = transmission;
		this.make = make;
		this.tyres = 4;
		this.doors = 4;
	}

	public void displayCharacteristics() {
		System.out.println("Color of the car is   : " + color);
		System.out.println("Transmission type is  :" + transmission);
		System.out.println("Year of making is     :" + make);
		System.out.println("Number of tyres       :" + tyres);
		System.out.println("Number of doors       :" + doors);
	}

	public void accelarate() {

		System.out.println("The car is having good acceleration power");
	}

	public void brake() {

		System.out.println("Brake is working properly");
	}
}