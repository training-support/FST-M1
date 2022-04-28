package activities;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car(){
        tyres = 4 ;
        doors = 4;
            }
    public void displaycharactristics (){
     System.out.println("Color of the car :  " + color);
     System.out.println("Make of the car :  " + make);
     System.out.println("Transmission of car :  " +transmission);
     System.out.println("Number of tyres on car :  " + tyres);
     System.out.println("Number of doors on car :  " + doors);
    }

    public void accelarate (){
        System.out.println("Car is moving forward");

    }


    public void brake () {
        System.out.println("Car has stopped");

    }
}
