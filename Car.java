package activites;

public class Car 
{
	String colour;
	String transmission;
	int make;
	int tyres;
	int doors;
Car()

   {
	tyres=4;
	doors=4;
   }
public void displayCharacteristics()
{
	System.out.println(make);
	System.out.println(tyres);
	System.out.println(doors);
}
public void accelarate()
{
	System.out.println("Car is moving forward.");
}
public void brake()
{
	System.out.println("Car has stopped.");
}


}
