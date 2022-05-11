package Activities;

public class Activity1 {

    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.make = 2020;
        toyota.color = "Black";
        toyota.transmission = "Manual";
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();
    }

}