package Activities.Activity1;

public class Activity1 extends Car{

    public static void main(String a[]){
        Car honda = new Car();
        honda.make = 2014;
        honda.color = "Black";
        honda.transmission = "Manual";

        honda.displayCharacteristics();
        honda.accelarate();
        honda.brake();

    }
}
