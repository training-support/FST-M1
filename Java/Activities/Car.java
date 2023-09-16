package Activities;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int door;

    Car(){
        tyres = 4;
        door = 4;
    }
    public void displayCharacteristics(){
        System.out.println("Color of the Car is "  +color);
        System.out.println("Transmission of the Car is "+transmission);
        System.out.println("Make of the Car is "+make);
        System.out.println("No of Tyres of the Car is "+tyres);
        System.out.println("No of Doors of the Car is "+door);
    }
    public void accelerate(){
        System.out.println("Car is moving forward");
    }
    public void brake(){
        System.out.println("Car has stopped");
    }
}
