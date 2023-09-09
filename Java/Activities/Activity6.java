package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    public List<String> passengers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;

    public Plane(int maxPass) {
        this.maxPassengers = maxPass;
        this.passengers = new ArrayList<>();
    }

    public void onboard(String passenger) {
        this.passengers.add(passenger);
    }

    public Date takeOff() {
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }
    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }
}

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);

        plane.onboard("Priyanka");
        plane.onboard("Annyesha");
        plane.onboard("Kritika");
        plane.onboard("Anishi");
        plane.onboard("Bhavya");

        System.out.println("Flight takes off at " + plane.takeOff());
        System.out.println("Passengers on the flight" + plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Flight lands at " + plane.getLastTimeLanded());
    }
}
