package Activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Rashmi");
        plane.onboard("Vivek");
        plane.onboard("Bharathi");
        plane.onboard("Vishwanath");

        System.out.println("Plane take off time is " +plane.takeOff());

        System.out.println("List of passengers traveling in the plane are "+plane.getPassengers());

        Thread.sleep(5000);

        plane.land();

        System.out.println("Tome of landing of the plane is "+plane.getLastTimeLanded());

        System.out.println("Passengers in the plane after getting down are "+plane.getPassengers());
    }
}
