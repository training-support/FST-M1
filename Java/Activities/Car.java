package org.example.activities;

public class Car {
    //Class Member Variables
    String color;
    int make;
    String transmission;
    //int tyres=4;
   // int doors=4;
    int tyres;
    int doors;

    //Constructor
    Car() {
        /*tyres = 4;
        doors = 4;*/
    }

    //Class Methods
    public void displayCharacterstics(){
        System.out.println("Color of the Car: " + color);
        System.out.println("Make of the Car: " + make);
        System.out.println("Transmission of the Car: " + transmission);
        System.out.println("Number of doors on the car: " + doors);
        System.out.println("Number of tyres on the car: " + tyres);
    }

    public void reversegear() {
        System.out.println("Car is moving back.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }
    public void running()
    {
        System.out.println("Car moving fast");
    }
}