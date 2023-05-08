package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane aero =new Plane(10);
        aero.onboard("Max");
        aero.onboard("Sam");
        aero.onboard("John");
        aero.onboard("Kevin");

        System.out.println("Take off Time:" +aero.takeoff());
        System.out.println("Passengers:" + aero.getPassesngers());
        Thread.sleep(5000);
        aero.land();
        System.out.println("Land Time:" + aero.getLastTimeLanded());
        System.out.println("Passengers:" + aero.getPassesngers());
    }

    static class Plane  {
         private List<String> passengers;
         private int maxPassengers;
         private Date lastTimeTookOf;
         private Date lastTimeLanded;

         public Plane(int p){
             maxPassengers=p;
             passengers= new ArrayList<>();
         }

         public void onboard(String S){
             passengers.add(S);
         }
         public Date takeoff(){
             lastTimeTookOf=new Date();
             return lastTimeTookOf;
         }
         public void land(){
             lastTimeLanded= new Date();
             passengers.clear();
         }
         public Date getLastTimeLanded(){
             return lastTimeLanded;
         }
         public List getPassesngers(){
             return passengers;
         }
    }
}
