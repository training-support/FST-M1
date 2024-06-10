package Activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date takeOfftime;
    private Date landedtime;

    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    public void onboard(String passenger) {
        this.passengers.add(passenger);
    }

    public Date takeOff() {
        this.takeOfftime = new Date();
        return takeOfftime;
    }

      public Date getLastTimeLanded() {
        return landedtime;
    }
    
    public void land() {
        this.landedtime = new Date();
      }

    public List<String> getPassengers() {
        return passengers;
    }
   
}

