package Activities;

public class Car {
 String color;
String transmission;
int make;
int tyres;
int doors;
 
Car (String color,String transmisson,int make	){
	this.color = color;
	this.transmission = transmission;
	this.make = make;
	this.tyres = 4;
	this.doors = 4;
}
public void displayCharactesristics() {
	System.out.println("color:" + color);
	System.out.println("Transmission type:" + transmission);
	System.out.println("Year of making :" + make);
	System.out.println("No.of tyres:" + tyres);
	System.out.println("No.of doors:" + doors);	
	
}
public void  accelerate() {
System.out.println("car is moving forward");	
}
public void  brake() {
System.out.println("car is stopped");
}
}

