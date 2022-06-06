package activities;
import java.util.*;


public class Activity6 {
	public static void main(String [] args) throws InterruptedException
	{
		Plane plane =new Plane(10);
		plane.onboard("Vijay");
		plane.onboard("Samuel");
		Date  takeoff = plane.takeOff();
		System.out.println("The takeoff time is"+takeoff);
		System.out.println("The list of passengers is :" +plane.getPassesngers());
		Thread.sleep(5000);
        plane.land();		
        System.out.println("The landed time:" +plane.getLastTimeLanded());
	}

}

class Plane {

    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    
    public Plane(int maxPassengers)
    {
    	this.maxPassengers = maxPassengers;
        this.passengers= new ArrayList();
    }
    
    void onboard(String passengers)
    { 
    	this.passengers.add(passengers);
    }
    
    Date takeOff()
    {
    	this.lastTimeTookOf =new Date();
    	return lastTimeTookOf;
    }	
    
   void land()
    {
       this.lastTimeLanded =new Date();
       this.passengers.clear();
    }
    Date getLastTimeLanded() {
    	return lastTimeLanded;
    }
  
    public  List<String> getPassesngers()
    { 
    return	passengers;
    }
}