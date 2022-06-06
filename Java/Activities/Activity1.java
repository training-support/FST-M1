package activities;

public class Activity1 {

    public static void main(String[] args) {
        Car benz = new Car();
        benz.make = 2019;
        benz.color = "Black";
        benz.transmission = "Manual";
    
        benz.displayCharacterstics();
        benz.accelerate();
        benz.brake();
    }

}
