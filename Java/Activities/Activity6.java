package Activity;


public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        
        Plane plane = new Plane(10);
       
        plane.onboard("Roe");
        plane.onboard("Mathew");
        plane.onboard("Amy");
       
        System.out.println("Plane take off TIME : " + plane.takeOff());
        
        System.out.println("Passengers boarded : " + plane.getPassengers());
        
        Thread.sleep(5000);
       
        plane.land();
       
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }
}