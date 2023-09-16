package Activities;

public class Activity1 {

    public static void main(String[] args)
    {
        Car benz = new Car();
        benz.make = 2014;
        benz.color = "Black";
        benz.transmission = "Manual";
        benz.displayCharacteristics();
        benz.accelerate();
        benz.brake();

    }
}
