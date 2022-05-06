
public class Activity1 {
public static void main(String[] args)
{
	System.out.println("Hellow world");
	Car swift= new Car();
	
	swift.color="White";
	swift.company="Maruthi";
	swift.manufacturingYear=2015;
	swift.numberOfSeats=4;
	
	swift.accelerate();
	swift.charactersticsOfCar();
	swift.brake();
}

}