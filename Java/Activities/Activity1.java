package org.example.activities;

public class Activity1 {

    public static void main(String[] args) {

        Car Swift = new Car();
        Swift.make =2022;
        Swift.color="White";
        Swift.transmission="Manual";
        Swift.tyres=5;
        Swift.doors=10;


        Swift.displayCharacterstics();
        Swift.reversegear();
        Swift.brake();
        Swift.running();
    }

}
