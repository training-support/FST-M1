package activities;

public class Activity7 
{
	public static void main (String args[])
	{
		MountainBike mb = new MountainBike(7, 50, 25);
	    System.out.println(mb.bicycleDesc());
	    mb.speedUp(20);
	    mb.applyBrake(5);
		
	}

}


interface BicycleParts 
{
	public int gears =0;
	public int speed=0;
}

interface BicycleOperations
{
	public void applyBrake(int decrement);
	public void speedUp(int increment);
	
}

class Bicycle implements BicycleOperations,BicycleParts
{
    public int gears;
    public int speed;
	
 	Bicycle(int gears,int speed)
	{
		this.gears=gears;
		this.speed=speed;
		
	}
	
	public void applyBrake(int decrement)
	{
		speed =speed-decrement;
		System.out.println("The current speed after decrementing: " +speed);
	}
	
	public void speedUp(int increment)
	{
		this.speed =speed+increment;
		System.out.println("The current speed after Increment: " +speed);
	}
	
	
	public String bicycleDesc() {
	    return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
	}
}


class MountainBike extends Bicycle
{
	public int seatHeight=0;
	
	public MountainBike (int gears, int speed , int seatHeight)
	{
		super(gears, speed);
		this.seatHeight=seatHeight;
		
    }
	
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	
	public String bicycleDesc()
	{
		return( super.bicycleDesc() + "\nSeat height is " + seatHeight);
		
	}
}