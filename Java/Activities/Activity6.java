package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers; //List is Generic class, so used <>
    private int maxPassengers;
    private Date lastTakeOffTime;
    private Date lastLandingTime;

    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<String>();
    }

    public void onboard(String passengerName) {
        this.passengers.add(passengerName);
    }

    public void settakeOff() {
        this.lastTakeOffTime = new Date();
    }

    public Date getTakeOffTime() {
        return this.lastTakeOffTime;
    }
    
    public void setland() {
        this.lastLandingTime = new Date();
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
        return this.lastLandingTime;
    }

    public List<String> getPassengers() {
        return this.passengers;
    }
}

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
    	
        //There is a plane with max 10 passengers
        Plane plane = new Plane(10);
        
        //Add passengers on the list
        plane.onboard("Reddy");
        plane.onboard("Rao");
        plane.onboard("Choudary");
        
        //Plane takes off time
        plane.settakeOff();
        System.out.println("Plane took off at: " + plane.getTakeOffTime());
        
        //Print list of people on board
        System.out.println("People on the plane: " + plane.getPassengers());
        
        //Flying.....
        System.out.println("Plane is flying....");
        Thread.sleep(5000);        
                
        //Plane has landed on time
        plane.setland();        
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("The passengers on the plane after landing: " + plane.getPassengers());
    }
}