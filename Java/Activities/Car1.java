package org.example.activities;

public class Car1 {

    String color;
    int make;
    String transmation;
    int tyres;
    int  doors;


    Car1()
    {
        tyres=6;
        doors=6;
    }

    public void  accelerate()
    {
        System.out.println("Color of the car :" + color);
        System.out.println("Number of tyres for car :" + tyres);
    }

}
