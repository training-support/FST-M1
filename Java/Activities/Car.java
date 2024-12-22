
package Activities;

public class Car {

	
		String  color;
		String transmission;
		int make;
		int tyres;
		int doors;

	Car(String color, String transmission, int make)
	{
		this.tyres = 4;
		this.doors = 4;
		this.color = color;
		this.transmission = transmission;
		this.make = make;
				
	}
	
	public void displayCharacteristics()
	{
		System.out.println("Color: " +color);
		System.out.println("Tranmission type: " +transmission);
		System.out.println("Years of making: " +make);
		System.out.println("No. of tyres: " +tyres);
		System.out.println("No. of doors: " +doors);
		
	}
	
	public void accelerate()
	{
		System.out.println("Car is moving forward"); 
		
	}
	
    public void  brake() 
    {
    	System.out.println("Car is stopped"); 
	}

	public void displayCharactesristics() {
		// TODO Auto-generated method stub
		
	}

}
