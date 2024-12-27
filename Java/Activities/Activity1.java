package activities;

public class Activity1 {

	public static void main(String[] args) {
		Car carobj=new Car("Red","Manual",2024);
		carobj.displayCharacteristics();
		carobj.accelarate();
		carobj.brake();
	}
}
