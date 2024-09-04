package FSTJava.Activities;


public class Activity1 {

    public static void main(String[] args) {
        Car hyundai = new Car();
        hyundai.make = 2014;
        hyundai.color = "Black";
        hyundai.transmission = "Manual";

        //Using Car class method
        hyundai.printCharacterstics();
        hyundai.accelerate();
        hyundai.brake();
    }

}