package FSTJava.Activities;


public class Car {
    //Class Member Variables
    String color;
    int make;
    String transmission;
    int seats;
    int window;

    //Constructor
    Car() {
        seats = 5;
        window = 4;
    }

    //Class Methods
    public void printCharacterstics(){
        System.out.println("Color of the Car: " + color);
        System.out.println("Make of the Car: " + make);
        System.out.println("Transmission of the Car: " + transmission);
        System.out.println("Seats in the car: " + seats);
        System.out.println("Windows in the car: " + window);
    }

    public void accelerate() {
        System.out.println("Car moves forward.");
    }

    public void brake() {
        System.out.println("Car stops on brake");
    }
}