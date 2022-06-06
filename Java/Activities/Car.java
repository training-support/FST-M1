package activities;

public class Car {
 String  color;
 String transmission;
  int make;
  int tyres;
  int doors;
  
  Car()
  {
  	tyres=4;
  	doors=4;
  }
  void displayCharacteristics()
  {
	  System.out.println("The value of color: " +color +"\n");
	  System.out.println("The value of transmission: " +transmission +"\n");
	  System.out.println("The value of  make: " +make +"\n");
	  System.out.println("The value of  tyres: " +tyres +"\n");
	  System.out.println("The value of doors: " +doors +"\n");
  }
  
  void accelarate() 
  {
	  System.out.println("Car is moving forward\n");
  }
  
  void brake()
  {
	  System.out.println("Car has stopped\n");
  }
}

